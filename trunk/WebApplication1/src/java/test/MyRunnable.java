/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author APopov
 */
import DAO.FactoryDAO;
import Pojo.Nixdata;
import Pojo.Nixlinks;
import Proxy.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class MyRunnable implements Runnable {

    // private HttpClient client = new HttpClient();
    private String fullName;
    private String manufacturer;
    private String article;
    private String groupe;
    private String attribute;
    private String attributeValue;
    static int bayan = 0;

    private String DownloadContent(String url, String pt, String filename) throws IOException, XmlPullParserException, SQLException {
        HttpClient client = new HttpClient();
        client.getHostConfiguration().setProxy("127.0.0.1", 8118);
        String inputLine = "";
        String allString = "";
        String outputString = "";
        GetMethod getMethod = null;
        try {
            getMethod = new GetMethod(url);
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
        // FileUtils.writeStringToFile(new File(filename), outputString);
//        fullName = "";
//        article = "";
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(new StringReader(outputString));
        Nixdata ptl;
        List<Nixdata> nixdataList = new ArrayList<Nixdata>();
        boolean gbool = false, abool = false, vbool = false;
        try {
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
                        ptl.setGroupe(pt + " - " + groupe);
                        ptl.setAttribute(attribute);
                        ptl.setAttributeValue(attributeValue);
                        nixdataList.add(ptl);
                    }
                }
                eventType = xpp.next();


            }
        } catch (XmlPullParserException e) {
            ptl = new Nixdata();
            ptl.setFullName("Что то упало в парсере, смотри вот тут: " + e.getMessage());
            ptl.setManufacturer(e.getMessage());
            ptl.setArticle(article);

            nixdataList.add(ptl);
        } catch (Exception e) {
            ptl = new Nixdata();
            ptl.setFullName("Что то упало в парсере, смотри вот тут: " + e.getMessage());
            ptl.setManufacturer(e.getMessage());
            ptl.setArticle(article);

            nixdataList.add(ptl);
        }
        manufacturer = "";
        for (Iterator it = nixdataList.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            try {
                if (ndt.getAttribute().equals("Производитель")) {
                    manufacturer = ndt.getAttributeValue();
                    break;
                }
            } catch (Exception e) {
            }
        }
        int i = 0;
        for (Iterator it = nixdataList.iterator(); it.hasNext();) {
            Nixdata ndt = (Nixdata) it.next();
            try {
                ndt.setManufacturer(manufacturer);
                nixdataList.set(i, ndt);
                FactoryDAO.getInstance().getNixdataDAO().addNixdata(nixdataList.get(i));
                i++;
            } catch (Exception e) {
            }
        }


        return outputString;
    }

    private void sss(String str) {
        System.out.println(str);
    }

    public String getName() {
        return Thread.currentThread().getName();
    }

    public void run() {

        // System.out.println(getName());
        if (getName().equals("1")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(0, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //   System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 1 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "1");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("2")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(5486, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //   System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 2 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "2");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }
        } else if (getName().equals("3")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(10971, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 3 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "3");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("4")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(16456, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 4 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "4");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("5")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(24941, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 5 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "5");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("6")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(27426, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 6 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "6");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("7")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(32911, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 7 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "7");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("8")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(38396, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 8 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "8");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("9")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(43881, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 9 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "9");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("10")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryDAO.getInstance().getNixlinksDAO().getAllNixlink(49336, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;
            //
            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 10 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent(str.getProductUrl(), str.getProductType(), "10");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 10) {
                    bayan = 0;
                    try {
                        ip.setChange();
                         System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        }
    }
}
