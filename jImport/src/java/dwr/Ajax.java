/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dwr;

/**
 *
 * @author APopov
 */
import XML.XmlPro;
import java.util.LinkedList;
import org.directwebremoting.Browser;
import org.directwebremoting.ui.dwr.Util;

/**
 * @author Joe Walker [joe at getahead dot ltd dot uk]
 */
public class Ajax {

    /**
     * @param text The new message text to add
     */
    XmlPro xmlp = new XmlPro();

    public void addMessage(String text) {
        // Make sure we have a list of the list 10 messages
        if (text != null && text.trim().length() > 0) {
            messages.addFirst(new Message(text));
            while (messages.size() > 10) {
                messages.removeLast();
            }
        }

        // Clear the input box in the browser that kicked off this page only
        Util.setValue("text", "");

        // For all the browsers on the current page:
        Browser.withCurrentPage(new Runnable() {

            public void run() {
                // Clear the list and add in the new set of messages
                Util.removeAllOptions("xxxsss");
                Util.addOptions("xxxsss", messages, "text");
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
}