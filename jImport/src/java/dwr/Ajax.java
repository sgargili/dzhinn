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
import java.util.LinkedList;
import org.directwebremoting.Browser;
//import org.directwebremoting.
import Pojo.ChatLogs;
import Pojo.Users;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.ui.dwr.Util;
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
                while (messages.size() > 30) {
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

    public String exportByProducts(String products, boolean ruEnBool) {
        ValuePro vp = new ValuePro();
        products = products.trim().replaceAll("(\\n)+|(\\r\\n)+|(\\n\\r)+", "|||");
        return vp.exportByProducts(products, ruEnBool);
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
}
