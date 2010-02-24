/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dwr;

/**
 *
 * @author APopov
 */
import DAO.FactoryDAO;
import XML.XmlPro;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import org.directwebremoting.Browser;
//import org.directwebremoting.
import Pojo.ChatLogs;
import Pojo.IpCount;
import Pojo.Users;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.ui.dwr.Util;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.io.FileTransfer;
import value4it.MatchingData;
import value4it.ValuePro;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Ajax {

    /**
     * @param text The new message text to add
     */
    XmlPro xmlp = new XmlPro();
    ChatLogs chLog;
    String[] strMas;
    Users user;
    int j;
    private static Map<String, IpCount> ipMap = new HashMap();
    IpCount ipCount = new IpCount();
    int count;

    public void test() {
        //ipCount.setCountAll(10);
        ScriptSession ss;
        ScriptBuffer script;
        for (int t = 0; t < 10; t++) {
            //count = t;
            //ipCount.setCount(count);
            //ipMap.put(WebContextFactory.get().getHttpServletRequest().getRemoteAddr(), ipCount);
            ss = WebContextFactory.get().getScriptSession();
            script = new ScriptBuffer();
            try {
                script.appendScript("update(");
                script.appendData(9);
                script.appendScript(",");
                script.appendData(t);
                script.appendScript(");");
                ss.addScript(script);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
        // ipCount.setCount(0);
        //ipCount.setCountAll(0);
        //ipMap.put(WebContextFactory.get().getHttpServletRequest().getRemoteAddr(), ipCount);
    }

    public void addMessage(String text) {
        String ip = WebContextFactory.get().getHttpServletRequest().getRemoteAddr();
        if (!text.equals("Введите ник...: ")) {
            // Make sure we have a list of the list 30 messages
            try {
                strMas = text.split(":\\s");
                chLog = new ChatLogs(ip, strMas[0], strMas[1]);
                FactoryDAO.getInstance().getChatLogsDAO().addChatLogs(chLog);
                user = FactoryDAO.getInstance().getUsersDAO().getUserByIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                if (user != null) {
                    if (!user.getNick().equals(strMas[0])) {
                        user.setNick(strMas[0]);
                        FactoryDAO.getInstance().getUsersDAO().addUser(user);
                    }
                } else {
                    user = new Users();
                    user.setIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
                    user.setNick(strMas[0]);
                    FactoryDAO.getInstance().getUsersDAO().addUser(user);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (text != null && text.trim().length() > 0) {
                messages.addLast(new Message(text));
                while (messages.size() > 37) {
                    messages.removeFirst();
                }
            }

            // Clear the input box in the browser that kicked off this page only
            //Util.setValue("text", "");

            // For all the browsers on the current page:
            Browser.withCurrentPage(new Runnable() {

                public void run() {
                    // Clear the list and add in the new set of messages
                    Util.removeAllOptions("chat_id_ul");
                    Util.addOptions("chat_id_ul", messages, "text");
                    // ScriptSessions.addFunctionCall("updateMessage");
                }
            });
        }
    }

    public void updateMessage() {
        Browser.withCurrentPage(new Runnable() {

            public void run() {
                // Clear the list and add in the new set of messages
                Util.removeAllOptions("chat_id_ul");
                Util.addOptions("chat_id_ul", messages, "text");
            }
        });
    }

    public String updateNick() {
        Users userName = null;
        String output = "Введите ник...";
        try {
            userName = new Users();
            userName = FactoryDAO.getInstance().getUsersDAO().getUserByIp(WebContextFactory.get().getHttpServletRequest().getRemoteAddr());
            output = userName.getNick();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        userName = null;
        return output;
    }

    public void setCount(int l) {
        j = l;
    }

    public int getCount() {
        j = ipMap.get(WebContextFactory.get().getHttpServletRequest().getRemoteAddr()).getCount();
        return j;
    }

    public int getCountAll() {
        return ipMap.get(WebContextFactory.get().getHttpServletRequest().getRemoteAddr()).getCountAll();
    }
    /**
     * The current set of messages
     */
    private final LinkedList<Message> messages = new LinkedList<Message>();

    public void ImportTree() {
        xmlp.xmlCategoriesExport();
    }

    public void ImportAllProducts(boolean autoname, boolean description) {
        xmlp.xmlPcSyncProducts(autoname, description);
    }

    public void ImportProductsByArticles(String articles, boolean autoname, boolean description) {
    }

    public boolean checkTreeStatus() {
        return xmlp.checkTreeStatus();
    }

    public boolean checkProductsStatus() {
        return xmlp.checkProductsStatus();
    }

    public String exportByProducts(String products, String langs) {
        ValuePro vp = new ValuePro();
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        return vp.exportByProducts(products, WebContextFactory.get().getHttpServletRequest().getRemoteAddr(), langs);
    }

    public String exportMarketing(String products) {
        ValuePro vp = new ValuePro();
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        return vp.exportMarketing(products);
    }

    public String clearCache() {
        ValuePro vp = new ValuePro();
        return vp.clearCache();
    }

    public String changeStatus(String products, String status) {
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        ValuePro vp = new ValuePro();
        return vp.changeStatus(products, status);
    }

    public String changeOwner(String products, String owner) {
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        ValuePro vp = new ValuePro();
        return vp.changeOwner(products, owner);
    }

    public String addLink(String links) {
        links = links.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        ValuePro vp = new ValuePro();
        return vp.addLink(links);
    }

    public String clearSession() {
        ValuePro vp = new ValuePro();
        return vp.clearSession();
    }

    public FileTransfer matchData(InputStream uploadFile, String fileName) throws Exception {
        Pattern p = Pattern.compile("(\\.csv)|(\\.xlsx)|(\\.xls)");
        Matcher m = p.matcher(fileName);
        if (!m.find()) {
            return null;
        }
        FileUtils.writeStringToFile(new File("C://newFile"), convertStreamToString(uploadFile));
        MatchingData match = new MatchingData();

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        p = Pattern.compile("\\.csv");
        m = p.matcher(fileName);
        if (m.find()) {
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.csv", "$2");
            buffer.write(FileUtils.readFileToByteArray(match.matchData(uploadFile, fileName, MatchingData.CSV)));
        } else {
            fileName = fileName.replaceAll("(.*\\\\)?(.+)\\.xlsx", "$2");
            buffer.write(FileUtils.readFileToByteArray(match.matchData(uploadFile, fileName, MatchingData.EXCEL)));
        }

        return new FileTransfer(fileName, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", buffer.toByteArray());
    }

    private String convertStreamToString(InputStream is) throws UnsupportedEncodingException, IOException{
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "WINDOWS-1251"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        } else {
            return "";
        }
    }
}
