package fe;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class FeXportNew extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private HttpClient client = new HttpClient();
    private String cookieString = "";
    private String ArtID = "";
    private static boolean bool = true;

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

    private String ArticleID(String art) {
        String url = "http://cf.value4it.com/cf/admin/article_status.jsp?FACTORY_ID=137&ARTICLE_ID=$" + art;
        String inputLine = "";
        String allString = "";
        String aID = "";
        GetMethod getMethod = new GetMethod(url);

        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result);
            BufferedReader in = new BufferedReader(isr);
            String re = ".*" + art + "</td><td>(.*)</td><td>(.*)</td><td>(\\d*)</td><td>(\\d*)</td></tr></table>.*";
            Pattern p = Pattern.compile(re);

            while ((inputLine = in.readLine()) != null) {
                allString += inputLine;
            }
            Matcher m = p.matcher(allString);
            if (m.matches()) {
                aID = m.group(4);
            }



            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return aID;
    }

    private boolean ArticleVerification(String art) {
        String url = "http://cf.value4it.com/admin/itshop/checkArticle.jsp";
        String inputLine = "";
        boolean aID = true;
        PostMethod getMethod = new PostMethod(url);
        NameValuePair article = new NameValuePair("ARTICLE", art);
        getMethod.setRequestBody(new NameValuePair[]{article});

        try {
            int getResult = client.executeMethod(getMethod);
            InputStream result = getMethod.getResponseBodyAsStream();
            InputStreamReader isr = new InputStreamReader(result);
            BufferedReader in = new BufferedReader(isr);
            String re = ".*Product article does not exist.*";
            Pattern p = Pattern.compile(re);

            while ((inputLine = in.readLine()) != null) {
                Matcher m = p.matcher(inputLine);
                if (m.matches()) {
                    aID = false;
                }

            }

            in.close();
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            getMethod.releaseConnection();
        }
        return aID;
    }

    private String Export(String artID) {
//        String url = "http://cf.value4it.com/cf/admin/export_product.jsp";
//        try {
//            PostMethod getMethod = new PostMethod(url);
//            NameValuePair post_url = new NameValuePair("referer", "");
//            NameValuePair factory = new NameValuePair("FACTORY_ID", "137");
//            NameValuePair action = new NameValuePair("ACTION", "EXPORT");
//            NameValuePair pn_rpp = new NameValuePair("PN_RPP", "100");
//            NameValuePair id = new NameValuePair("ID_" + artID, artID);
//            NameValuePair langs = new NameValuePair("LANGS", "");
//            NameValuePair lang1 = new NameValuePair("LANG", "bg");
//            NameValuePair lang2 = new NameValuePair("LANG", "hr");
//            NameValuePair lang3 = new NameValuePair("LANG", "en");
//            NameValuePair lang4 = new NameValuePair("LANG", "pl");
//            NameValuePair lang5 = new NameValuePair("LANG", "ru");
//            NameValuePair lang6 = new NameValuePair("LANG", "sl");
//            getMethod.setRequestBody(new NameValuePair[]{post_url, factory, action, id, langs, lang1, lang2, lang3, lang4, lang5, lang6});
//            int getResult = client.executeMethod(getMethod);
//            getMethod.releaseConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return "Passed";

    }

    private String ExportAll(String[] artID) {
        String st_url = "http://cf.value4it.com/cf/admin/export_product.jsp";
        PostMethod method = new PostMethod(st_url);
        for (int k = 0; k < artID.length; k++) {
            method.setParameter("ID_" + artID[k], artID[k]);
        }
        method.setParameter("referer", "");
        method.setParameter("FACTORY_ID", "137");
        method.setParameter("ACTION", "EXPORT");
        method.setParameter("PN_RPP", "100");
        method.setParameter("LANGS", "");
        method.setParameter("LANG", "bg");
        method.setParameter("LANG", "hr");
        method.setParameter("LANG", "en");
        method.setParameter("LANG", "sl");
        method.setParameter("LANG", "ru");
        method.setParameter("LANG", "pl");

        try {
            int returnCode = client.executeMethod(method);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }
        return "";
    }

    private String ExportMarketing(String artID) {
//        String url = "http://cf.value4it.com/cf/admin/articles_admin.jsp";
//        try {
//            PostMethod getMethod = new PostMethod(url);
//            NameValuePair post_url = new NameValuePair("POST_ACTION", "updateMarketing");
//            NameValuePair id = new NameValuePair("ID_" + artID, artID);
//            NameValuePair target = new NameValuePair("TARGET_" + artID, artID);
//            NameValuePair source = new NameValuePair("SOURCE", "");
//            NameValuePair owner = new NameValuePair("NEW_OWNER_ID", "70919085040801266");
//            getMethod.setRequestBody(new NameValuePair[]{post_url, id, target, source, owner});
//            int getResult = client.executeMethod(getMethod);
//            getMethod.releaseConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "Passed";
    }

    private String ExportMarketingAll(String[] artID) {
        String st_url = "http://cf.value4it.com/cf/admin/articles_admin.jsp";
        PostMethod method = new PostMethod(st_url);
        for (int k = 0; k < artID.length; k++) {
            method.setParameter("TARGET_" + artID[k], artID[k]);
            method.setParameter("ID_" + artID[k], artID[k]);
        }
        method.setParameter("POST_ACTION", "updateMarketing");
        method.setParameter("SOURCE", "");
        method.setParameter("NEW_OWNER_ID", "70919085040801266");

        try {
            int returnCode = client.executeMethod(method);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            method.releaseConnection();
        }
        return "";
    }

    private static String[] strengthenSentence(String sentence) {
        String retval = null;
        String[] tokens = null;
        String splitPattern = ",";
        if (!sentence.equals("")) {
            tokens = sentence.split(splitPattern);
            bool = true;
        } else {
            bool = false;
        }
        return tokens;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ServletOutputStream out = res.getOutputStream();
        res.setCharacterEncoding("Cp1251");
        res.setContentType("text/html");
        out.println(login());
        String name = req.getParameter("programmaticTextArea").trim();
        String name1 = req.getParameter("g1").trim();
        String str = req.getParameter("sss").trim();
        String s3 = req.getParameter("aaa").trim();
        String[] art = strengthenSentence(str);

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Fast Export</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=windows-1251'>");
        out.println("<meta http-equiv='X-UA-Compatible' content='IE=EmulateIE7' /> ");
        out.println("<style type='text/css'>@import 'dojo/dojo/resources/dojo.css';@import 'css/dijitTests.css';</style>");
        out.println("<link id='themeStyles' rel='stylesheet' href='dojo/dijit/themes/tundra/tundra.css'>");
        out.println("<script type='text/javascript' src='dojo/dojo/dojo.js'djConfig='isDebug: false, parseOnLoad: true'></script>");
        out.println("<script type='text/javascript' src='script.js'></script>");
        out.println("</head>");
        out.println("<body class='tundra' bgcolor ='black' >");
        out.println("<center>");
        out.println("<form id='form1' action='FeXport.jsp' name='example' method='post' >");
        out.println("<fieldset> ");
        out.println("<legend align=center><b>Export</b></legend> ");
        out.println("<table border=0 width=100%>");
        out.println("<tr><td valign = middle width=10% align=center>");
        out.println("<span>Input Form:</span></td><td width=65%><textarea value='ddd' id='texta' name='programmaticTextArea'  style='width:100%; height:300px'>");
        out.println("</textarea></td><td width=25% align=center><fieldset><table><tr><td><input type='radio' name='g1' id='g1rb2' value='ArticleID' dojoType='dijit.form.RadioButton' checked>");
        out.println("<label for='g1rb2'><b>ArticleID</b>&nbsp;(Fast)</label>");
        out.println("</td></tr><tr><td><input type='radio' name='g1' id='g1rb1' value='Article' dojoType='dijit.form.RadioButton'>");
        out.println("<label for='g1rb1'><b>Article</b>&nbsp;(Slow)</label></td></tr></table> </fieldset> </td></tr></table>");
        out.println("<input id='realSubmitButton' type='submit' name='save' value='Save' style='display:none'>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"sbm('true')\">&lt;&lt;&lt; Export by Product &gt;&gt;&gt</button>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"sbm('false')\">&lt;&lt;&lt; &nbsp;Export Marketing &nbsp;&gt;&gt;&gt</button>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"ClrCache()\">&lt;&lt;&lt; &nbsp;Clear Cache&nbsp;&gt;&gt;&gt</button>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"eXpStat()\">&lt;&lt;&lt; &nbsp;Export Statistics&nbsp;&gt;&gt;&gt</button>");
        out.println("</fieldset>");
        out.println("<input name='aaa' id='hvalue2' value='Export_Marketing' style='display:none'></input>");
        out.println("<input name='sss' id='hvalue' value='' style='display:none'></input>");
        out.println("<input name='ddd' id='hvalue1' value='qqq' style='display:none'></input>");
        out.println("</form>");
        out.println("<br><br><br>");
//        <input name="language" id="cb1" value="All" dojoType="dijit.form.CheckBox">
//        <label for="cb1">ru/en language only...</label>
//
        if (bool) {
            if (name1.equals("Article")) {
                out.println("<fieldset><legend align=center><b>Export Statistics</b></legend><br><table bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=98%>");
                out.println("<tr bgcolor = #2d4491 align=center><td><font color=white>" + name1 + "</font></td><td><font color=white>Exist</font></td><td><font color=white>ArticleID</font></td><td><font color=white>Request Action</font></td><td><font color=white>Request Status</font></td></tr>");
                for (int i = 0; i < art.length; i++) {
                    if (ArticleVerification((art[i])) && !art[i].equals("")) {
                        //ArticleID(art[i]);
                        ArtID = ArticleID(art[i]);
                        out.println((new StringBuilder()).append("<tr bgcolor = #cfcdcd><td style='padding-left:4px'>").append(art[i]).append("</td><td style='padding-left:4px'>Yes</td><td style='padding-left:4px'>").append(ArtID).append("</td><td style='padding-left:4px'>").toString());
                        if (s3.equals("Export")) {
                            out.println("Export");
                        } else {
                            out.println("Export Marketing");
                        }
                        out.println("</td><td style='padding-left:4px'>");
                        if (s3.equals("Export_Marketing")) {
                            out.println(ExportMarketing(ArtID));
                        } else {
                            out.println(Export(ArtID));
                        }
                        out.println("</td></tr>");
                        continue;
                    }
                    if (!art[i].equals("")) {
                        out.println((new StringBuilder()).append("<tr bgcolor = #cfcdcd><td style='padding-left:4px'>").append(art[i]).append("</td><td style='padding-left:4px'><font color=red>No</font></td><td style='padding-left:4px'><font color=red>-</font></td></td><td style='padding-left:4px'><font color=red>-</font></td></td><td style='padding-left:4px'><font color=red>-</font></td></td></tr>").toString());
                    }
                }

                out.println("</table><br></fieldset>");

            } else {
                out.println("<fieldset><legend align=center><b>Export Statistics</b></legend><br><table bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=98%>");
                out.println((new StringBuilder()).append("<tr bgcolor = #2d4491 align=center><td><font color=white>").append(name1).append("</font></td><td><font color=white>Request Action</font></td><td><font color=white>Request Status</font></td></tr>").toString());
                for (int j = 0; j < art.length; j++) {
                    ArtID = art[j];
                    if (ArtID.equals("")) {
                        continue;
                    }
                    out.println((new StringBuilder()).append("<tr bgcolor = #cfcdcd><td style='padding-left:4px'>").append(art[j]).append("</td><td style='padding-left:4px'>").toString());
                    if (s3.equals("Export_Marketing")) {
                        out.println("Export Marketing");
                    } else {
                        out.println("Export");
                    }
                    out.println("</td><td style='padding-left:4px'>");
                    if (s3.equals("Export_Marketing")) {
                        out.println(ExportMarketing(ArtID));
                    } else {
                        out.println(Export(ArtID));
                    }
                    out.println("</td></tr>");
                }

                out.println("</table><br></fieldset>");
                if (s3.equals("Export_Marketing")) {
                            ExportMarketingAll(art);
                        } else {
                            ExportAll(art);
                        }
            }
        }
        out.println("</body>");
        out.println("</html>");

        LogOut();



    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        response.setCharacterEncoding("Cp1251");
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Fast Export</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=windows-1251'>");
        out.println("<meta http-equiv='X-UA-Compatible' content='IE=EmulateIE7' /> ");
        out.println("<style type='text/css'>@import 'dojo/dojo/resources/dojo.css';@import 'css/dijitTests.css';</style>");
        out.println("<link id='themeStyles' rel='stylesheet' href='dojo/dijit/themes/tundra/tundra.css'>");
        out.println("<script type='text/javascript' src='dojo/dojo/dojo.js'djConfig='isDebug: false, parseOnLoad: true'></script>");
        out.println("<script type='text/javascript' src='script.js'></script>");
        out.println("</head>");
        out.println("<body class='tundra' bgcolor ='black' >");
        out.println("<center>");
        out.println("<form id='form1' action='FeXport.jsp' name='example' method='post' >");
        out.println("<fieldset> ");
        out.println("<legend align=center><b>Export</b></legend> ");
        out.println("<table border=0 width=100%>");
        out.println("<tr><td valign = middle width=10% align=center>");
        out.println("<span>Input Form:</span></td><td width=65%><textarea value='ddd' id='texta' name='programmaticTextArea'  style='width:100%; height:300px'>");
        out.println("</textarea></td><td width=25% align=center><fieldset><table><tr><td><input type='radio' name='g1' id='g1rb2' value='ArticleID' dojoType='dijit.form.RadioButton' checked>");
        out.println("<label for='g1rb2'><b>ArticleID</b>&nbsp;(Fast)</label>");
        out.println("</td></tr><tr><td><input type='radio' name='g1' id='g1rb1' value='Article' dojoType='dijit.form.RadioButton'>");
        out.println("<label for='g1rb1'><b>Article</b>&nbsp;(Slow)</label></td></tr>");
        out.println("<tr><td><input name='language' id='cb1' value='All' dojoType='dijit.form.CheckBox'><label for='cb1'>ru/en language only...</label></td></tr></table></fieldset></td></tr></table>");
        out.println("<input id='realSubmitButton' type='submit' name='save' value='Save' style='display:none'>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"sbm('true')\">&lt;&lt;&lt; Export by Product &gt;&gt;&gt</button>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"sbm('false')\">&lt;&lt;&lt; &nbsp;Export Marketing &nbsp;&gt;&gt;&gt</button>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"ClrCache()\">&lt;&lt;&lt; &nbsp;Clear Cache&nbsp;&gt;&gt;&gt</button>");
        out.println("<button dojoType='dijit.form.Button'onClick=\"eXpStat()\">&lt;&lt;&lt; &nbsp;Export Statistics&nbsp;&gt;&gt;&gt</button>");
        out.println("</fieldset>");
        out.println("<input name='aaa' id='hvalue2' value='Export_Marketing' style='display:none'></input>");
        out.println("<input name='sss' id='hvalue' value='' style='display:none'></input>");
        out.println("<input name='ddd' id='hvalue1' value='qqq' style='display:none'></input>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
