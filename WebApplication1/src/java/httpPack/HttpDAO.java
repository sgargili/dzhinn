/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpPack;

import DAO.FactoryDAO;
import Pojo.Nixdata;
import Pojo.Nixlinks;
import Pojo.PTLinks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author APopov
 */
public class HttpDAO {

    private HttpClient client = new HttpClient();
    private String fullName;
    private String manufacturer;
    private String article;
    private String productType;
    private String pictureUrl;
    private String groupe;
    private String attribute;
    private String attributeValue;

    public boolean Login4Value(String Login, String Password) {
        boolean output = false;
        String st_url = "https://www.value4it.com/login/authorize2.jsp";
        PostMethod method = new PostMethod(st_url);
        method.setParameter("USERNAME", Login);
        method.setParameter("PASSWORD", Password);
        method.setParameter("btlogin", "SIGN-IN");
        try {
            int returnCode = client.executeMethod(method);
            output = true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }
        return output;
    }

    public boolean Logout4Value() {
        boolean output = false;
        String url = "https://www.value4it.com/login/logout.jsp";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            output = true;
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return output;
    }

    public String DownloadFromValue(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String DownloadContent(String url, String pt, String filename) throws IOException, XmlPullParserException, SQLException {
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        String inputLine = "";
        String allString = "";
        String outputString = "";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result, "WINDOWS-1251");
            BufferedReader in = new BufferedReader(isr);
            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            String re = "id='goods_name'>(.*?)</h1>";
            Pattern p = Pattern.compile(re);
            Matcher m = p.matcher(allString);
            if (m.find()) {
                fullName = m.group(1);
            }
            re = "temp_good_id=(\\d+)";
            p = Pattern.compile(re);
            m = p.matcher(allString);
            if (m.find()) {
                article = m.group(1);
            }
            re = "(id=\"PriceTable\".*?</table>)";
            p = Pattern.compile(re);
            m = p.matcher(allString);
            if (m.find()) {
                outputString = "<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>" +
                        "<table fullname=\"" +
                        fullName +
                        "\" " +
                        "article=\"" +
                        article +
                        "\" " +
                        m.group();//&
                outputString = outputString.replaceAll("(&nbsp;)|(&lt;)|(&gt;)", " ");
                outputString = outputString.replaceAll("&quot;", "inch ");
                outputString = outputString.replaceAll("<tr>.*?price_container'>", "");
                outputString = outputString.replaceAll("target=new", "");
                outputString = outputString.replaceAll("([|].*?<a.*?</a>)|(<a.*?</a>)", "");
                outputString = outputString.replaceAll("\\s+", " ");
                outputString = outputString.replaceAll("<tr>.*?юмориста.*?tr>", " ");
                outputString = outputString.replaceAll("&", "and");
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        fullName = "";
        article = "";
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(outputString));
        Nixdata ptl;
        List<Nixdata> nixdataList = new ArrayList<Nixdata>();
        boolean gbool = false, abool = false, vbool = false;
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (xpp.getName().equals("table")) {
                    fullName = xpp.getAttributeValue(0);
                    article = xpp.getAttributeValue(1);
                } else if (xpp.getName().equals("td") && xpp.getAttributeValue(0).equals("e")) {
                    gbool = true;
                } else if (xpp.getName().equals("td") && xpp.getAttributeValue(0).equals("desc_property")) {
                    abool = true;
                } else if (xpp.getName().equals("td") && xpp.getAttributeValue(0).equals("desc_desc")) {
                    vbool = true;
                }
            } else if (eventType == XmlPullParser.TEXT) {
                if (gbool && !abool && !vbool) {
                    groupe = xpp.getText().trim();
                } else if (abool) {
                    attribute = xpp.getText().trim();
                } else if (vbool) {
                    attributeValue = xpp.getText().trim();
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                if (xpp.getName().equals("td") && gbool) {
                    gbool = false;
                } else if (xpp.getName().equals("td") && abool) {
                    abool = false;
                } else if (xpp.getName().equals("td") && vbool) {
                    vbool = false;
                    ptl = new Nixdata();
                    ptl.setFullName(fullName);
                    ptl.setManufacturer("NoName");
                    ptl.setArticle(article);
                    ptl.setProductType(pt);
                    ptl.setPictureUrl("NoPics");
                    ptl.setGroupe(groupe);
                    ptl.setAttribute(attribute);
                    ptl.setAttributeValue(attributeValue);
                    nixdataList.add(ptl);
                }
            }
            eventType = xpp.next();


        }
        manufacturer = "";
        for (Iterator it = nixdataList.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            if (ndt.getAttribute().equals("Производитель")) {
                manufacturer = ndt.getAttributeValue();
                break;
            }
        }
        int i = 0;
        for (Iterator it = nixdataList.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            ndt.setManufacturer(manufacturer);
            nixdataList.set(i, ndt);
            FactoryDAO.getInstance().getNixdataDAO().addNixdata(nixdataList.get(i));
            i++;
        }

//        FileUtils.writeStringToFile(new File(filename), outputString);
        return outputString;
    }

    public List DownloadContentPT(String url) throws XmlPullParserException, IOException {
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        String inputLine = "";
        boolean tbool = false, abool = false;
        String allString = "";
        String outputString = "";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result, "WINDOWS-1251");
            BufferedReader in = new BufferedReader(isr);
            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            String re = "valign='top'(.*?)</table>(.*?)</table>(.*?)</table>(.*?)</table>(.*?</table>)";
            Pattern p = Pattern.compile(re);
            Matcher m = p.matcher(allString);
            if (m.find()) {
                outputString = "<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>" +
                        "<table><tr><td" +
                        m.group(1) + "</td></tr></table>" +
                        m.group(2) + "</td></tr></table>" +
                        m.group(3) + "</td></tr></table>" +
                        m.group(4) + "</td></tr></table>" +
                        m.group(5);
                outputString = outputString.replaceAll("(&nbsp;)|(&lt;)|(&gt;)", " ");
                outputString = outputString.replaceAll("&quot;", "inch ");
                outputString = outputString.replaceAll("<tr>.*?price_container'>", "");
                outputString = outputString.replaceAll("target=new", "");
                outputString = outputString.replaceAll("<a\\sclass='n'\\sonClick=.*?Собрать\\sсвой\\sкомпьютер.*?</a>", "");
                outputString = outputString.replaceAll("\\s+", " ");
                outputString = outputString.replaceAll("<br>", " ");
                outputString = outputString.replaceAll("&", "and");
                outputString = outputString.replaceAll("-", "");
            }
            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        List<String> PTList = new ArrayList<String>();
        XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(outputString));
        PTLinks ptl = new PTLinks();
        List<PTLinks> PTLinklist = new ArrayList<PTLinks>();
        int eventType = xpp.getEventType();
        String pt = "";
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                if (xpp.getName().equals("td") && xpp.getAttributeCount() == 1) {
                    pt += ")";
                    pt = pt.replaceAll(",[)]", ")");
                    if (!pt.equals(")")) {
                        PTList.add(pt);
                    }
                    pt = "";
                    tbool = true;
                } else if (xpp.getName().equals("a")) {

                    ptl = new PTLinks();
                    abool = true;
                    ptl.setLink(xpp.getAttributeValue(1));
                }
            } else if (eventType == XmlPullParser.TEXT) {
                if (abool) {
                    ptl.setPT(xpp.getText().trim());
                }
                if (tbool) {
                    pt = xpp.getText().trim() + " (";
                } else if (!xpp.getText().equals(" ")) {
                    pt += xpp.getText().trim() + "|";
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                if (tbool && xpp.getName().equals("td")) {
                    tbool = false;
                }
                if (abool && xpp.getName().equals("a")) {
                    abool = false;
                    PTLinklist.add(ptl);
                }
            }
            eventType = xpp.next();
        }
        PTList.add(pt + ")");
        List<PTLinks> outputList = new ArrayList<PTLinks>();
        for (Iterator it = PTList.iterator(); it.hasNext();) {
            String str = (String) it.next();
            str = str.replaceAll("[|][)]", ")");
            str = str.replaceAll("\\(PDA\\)", "PDA");
            Pattern pat;
            Matcher mat;
            pat = Pattern.compile("\\((.+)\\)");
            mat = pat.matcher(str);
            if (mat.find()) {
                String[] strPT = mat.group(1).split("[|]");
                for (int k = 0; k < strPT.length; k++) {
                    for (Iterator iter = PTLinklist.iterator(); iter.hasNext();) {
                        PTLinks PTL = (PTLinks) iter.next();
                        PTLinks oPTL = new PTLinks();
                        if ((PTL.getPT()).equals(strPT[k])) {
                            oPTL.setPT(strPT[k]);
                            oPTL.setLink(PTL.getLink());
                            outputList.add(oPTL);
                            break;
                        }
                    }
                }
            } else {
                pat = Pattern.compile("(.*)\\s\\(\\)");
                mat = pat.matcher(str);
                if (mat.find()) {
                    for (Iterator iter = PTLinklist.iterator(); iter.hasNext();) {
                        PTLinks PTL = (PTLinks) iter.next();
                        PTLinks oPTL = new PTLinks();
                        if ((PTL.getPT()).equals(mat.group(1).replaceAll("PDA", "(PDA)"))) {
                            oPTL.setPT(mat.group(1).replaceAll("PDA", "(PDA)"));
                            oPTL.setLink(PTL.getLink());
                            outputList.add(oPTL);
                            break;
                        }
                    }
                }
            }
        }
        int i = 0;
        for (Iterator it = outputList.iterator(); it.hasNext();) {
            PTLinks str = (PTLinks) it.next();
            for (Iterator itpt = PTList.iterator(); itpt.hasNext();) {
                String temp = (String) itpt.next();
                Pattern pat = Pattern.compile(str.getPT().toString());
                Matcher mat = pat.matcher(temp);
                if (mat.find()) {
                    pat = Pattern.compile("(.+?)\\s\\(.*\\)");
                    mat = pat.matcher(temp);
                    if (mat.find()) {
                        str.setPT(mat.group(1));
                        outputList.set(i, str);
                    }
                    break;
                }
            }
            str.setPT(str.getPT().replaceAll("Расх.\\sматлы.+?\\)", "Все Расходные материалы").replaceAll("Звуковые карты.+", "Все Звуковые карты"));
            outputList.set(i, str);
            System.out.println(i + " -> " + str.getPT() + " " + str.getLink());
            i++;
        }
        return outputList;
    }

    public String DownloadContentPTURL(List lst) throws XmlPullParserException, IOException, SQLException {
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        String inputLine = "";
        boolean tbool = false, abool = false;
        String allString = "";
        String outputString = "";
        List<PTLinks> outputList = lst;
        int k = 0;
        for (Iterator iterat = outputList.iterator(); iterat.hasNext();) {
            Pattern pattern = Pattern.compile("НИКС");
            Matcher match = pattern.matcher(outputList.get(k).getPT());
            if (match.find()) {
                continue;
            }
            GetMethod getMethod = new GetMethod("http://www.nix.ru/price/" + outputList.get(k).getLink());
            try {
                int getResult = client.executeMethod(getMethod);
                InputStream result = getMethod.getResponseBodyAsStream();
                InputStreamReader isr = new InputStreamReader(result, "WINDOWS-1251");
                BufferedReader in = new BufferedReader(isr);
                while ((inputLine = in.readLine()) != null) {
                    allString += inputLine;
                }
                String re = "<a\\shref='(/autocatalog.*)'>этот\\sраздел\\sв\\sархиве\\sописаний</a>";
                Pattern p = Pattern.compile(re);
                Matcher m = p.matcher(allString);
                if (m.find()) {
                    outputString = "http://www.nix.ru" + m.group(1);
                }
                in.close();
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                getMethod.releaseConnection();
            }
            allString = "";
            getMethod = new GetMethod(outputString);
            // getMethod = new GetMethod("http://www.nix.ru/autocatalog/cc/computers_acer.html");
            try {
                int getResult = client.executeMethod(getMethod);
                InputStream result = getMethod.getResponseBodyAsStream();
                InputStreamReader isr = new InputStreamReader(result, "WINDOWS-1251");
                BufferedReader in = new BufferedReader(isr);
                while ((inputLine = in.readLine()) != null) {
                    allString += inputLine;
                }

                String re = "width='100%'\\sid='ruler'.*?</table>";
                Pattern p = Pattern.compile(re);
                Matcher m = p.matcher(allString);
                outputString = "";
                if (m.find()) {
                    outputString = "<?xml version=\"1.0\" encoding=\"WINDOWS-1251\"?>" +
                            "<table " +
                            m.group();
                    outputString = outputString.replaceAll("(&nbsp;)|(&lt;)|(&gt;)", " ");
                    outputString = outputString.replaceAll("&quot;", "inch ");
                    outputString = outputString.replaceAll("\\s+", " ");
                    outputString = outputString.replaceAll("<br>", " ");
                    outputString = outputString.replaceAll("&", "and");
                }
                in.close();
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                getMethod.releaseConnection();
            }


            //   FileUtils.writeStringToFile(new File("C://777.xml"), outputString);

            List<String> PTList = new ArrayList<String>();
            XmlPullParserFactory factory = factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(outputString));
            PTLinks ptl = new PTLinks();
            List<PTLinks> PTLinklist = new ArrayList<PTLinks>();
            int eventType = xpp.getEventType();
            String pt = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("a")) {
                        if (xpp.getAttributeCount() > 1 && xpp.getAttributeValue(2).equals("Посмотреть описание")) {
                            ptl = new PTLinks();
                            ptl.setLink(xpp.getAttributeValue(1));
                            abool = true;
                        }
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    if (abool) {
                        ptl.setPT(xpp.getText());
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (abool && xpp.getName().equals("a")) {
                        abool = false;
                        PTLinklist.add(ptl);
                    }
                }
                eventType = xpp.next();
            }

            int i = 0;
            Pattern pat = Pattern.compile("(.)(.*)");
            Matcher mat;
            for (Iterator it = outputList.iterator(); it.hasNext();) {
                PTLinks str = (PTLinks) it.next();
                str.setPT(str.getPT().replaceAll("Все|Вся", "").trim());
                mat = pat.matcher(str.getPT());
                if (mat.find()) {
                    //  System.out.println(i + " -> " + mat.group(1).toUpperCase() + mat.group(2));
                    str.setPT(mat.group(1).toUpperCase() + mat.group(2));
                    outputList.set(i, str);
                }
                i++;
            }
            List<String> strList = new ArrayList<String>();


            i = 0;
            for (Iterator it = PTLinklist.iterator(); it.hasNext();) {
                PTLinks str = (PTLinks) it.next();
//            strList.add(i + " -> " + str.getPT().replaceAll("NEW", "").trim() + "----->>>>" + str.getLink());
//            System.out.println(i + " -> " + outputList.get(3).getPT() + "----->>>> http://www.nix.ru" + str.getLink());
                Nixlinks nixlink = new Nixlinks();
                nixlink.setProductType(outputList.get(k).getPT());
                nixlink.setProductUrl("http://www.nix.ru" + str.getLink());
                FactoryDAO.getInstance().getNixlinksDAO().addNixlink(nixlink);
                i++;
            }
            k++;
        }
        // FileUtils.writeLines(new File("C://777.xml"), strList);
//        XStream xstream = new XStream();
//        xstream.alias("link", String.class);
//        xstream.alias("Url", List.class);
//
//        String xml = xstream.toXML(strList);
//        FileUtils.writeStringToFile(new File("C://7777.xml"), xml);
        return outputString;
    }

    public void DownloadContentCard() throws XmlPullParserException, IOException, SQLException {
        List<Nixlinks> nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(1);
        int i = 1;
        for (Iterator it = nixlist.iterator(); it.hasNext();) {
            Nixlinks str = (Nixlinks) it.next();
            System.out.println(i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
            DownloadContent(str.getProductUrl(), str.getProductType(), "c://" + i + ".xml");
            i++;
        }
    }
}
