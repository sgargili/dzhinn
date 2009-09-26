package processing;
//http://213.53.57.39/cfInfoWS/cfcode.exml?article=222
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
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
 * @author PAV
 */
public class ExportProcess {

//    public ExportProcess(String[] www) {
//        this.getArticlesData (www);
//    }
    private HttpClient client = new HttpClient();

    private String login() {
        String st_url = "http://cf.value4it.com/login/authorize2.jsp";
        PostMethod method = new PostMethod(st_url);
        method.setParameter("USERNAME", "apopov");
        method.setParameter("PASSWORD", "Andrey1602");
        method.setParameter("btlogin", "SIGN-IN");

        try {
            int returnCode = client.executeMethod(method);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }
        return "";
    }

    private void LogOut() {
        String url = "http://cf.value4it.com/login/logout.jsp";
        GetMethod getMethod = new GetMethod(url);
        try {
            int getResult = client.executeMethod(getMethod);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
    }

    public List getArticlesData(String[] art) {
        String url = "http://213.53.57.39/cfInfoWS/cfcode.exml?article=";
        String inputLine = "";
        String allString = "";
        String allString2 = "";
        String[] Output = new String[art.length];
        List<DataBean> list = new ArrayList<DataBean>();

        for (int j = 0; j < art.length; j++) {
            url += art[j] + ";";
        }

        GetMethod getMethod = new GetMethod(url);

        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result);
            BufferedReader in = new BufferedReader(isr);

            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            for (int k = 0; k < art.length; k++) {
                String re = "id='(\\d*)'\\sclasscat_id='(\\d*)'\\scode='" + art[k] + "'.*?status='(.*?)'";
                Pattern p = Pattern.compile(re);
                Matcher m = p.matcher(allString);
                if (m.find() && !art[k].equals("")) {
                    list.add(new DataBean(art[k], m.group(1), m.group(3)));
                } else {
                    if (!art[k].equals("")) {
                        list.add(new DataBean(art[k], "-", "-"));
                    }
                }
            }


            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return list;
    }

    public List getArticlesData2(String[] art) throws XmlPullParserException, IOException {
        String url = "http://213.53.57.39/cfInfoWS/cfcode.exml?article=";
        String inputLine = "";
        String allString = "";
        String allString2 = "";
        String[] Output = new String[art.length];
        List<DataBean> list = new ArrayList<DataBean>();

        for (int j = 0; j < art.length; j++) {
            url += art[j] + ";";
        }

        GetMethod getMethod = new GetMethod(url);

        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result);
            BufferedReader in = new BufferedReader(isr);

            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
//            for (int k = 0; k < art.length; k++) {
//                String re = "id='(\\d*)'\\sclasscat_id='(\\d*)'\\scode='" + art[k] + "'.*?status='(.*?)'";
//                Pattern p = Pattern.compile(re);
//                Matcher m = p.matcher(allString);
//                if (m.find() && !art[k].equals("")) {
//                    list.add(new DataBean(art[k], m.group(1), m.group(3)));
//                } else {
//                    if (!art[k].equals("")) {
//                        list.add(new DataBean(art[k], "-", "-"));
//                    }
//                }
//            }


            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(allString));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if ((eventType == XmlPullParser.START_TAG) && xpp.getName().equals("article")) {
                    list.add(new DataBean(xpp.getAttributeValue(2), xpp.getAttributeValue(0), xpp.getAttributeValue(6)));
//                    System.out.println("Всего атрибутов у тега article= " + xpp.getAttributeCount());
//                    System.out.println("id = " + xpp.getAttributeValue(0));
//                    System.out.println("classcat_id = " + xpp.getAttributeValue(1));
//                    System.out.println("code = " + xpp.getAttributeValue(2));
//                    System.out.println("full_name = " + xpp.getAttributeValue(4));
                } else {
                    //list.add(new DataBean("-", "-", "-"));
                }
                eventType = xpp.next();
            }

            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return list;
    }
}
