/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dwr;

/**
 *
 * @author Admin4DB2
 */
public class Message {

    private long id = System.currentTimeMillis();
    private String text;

    public Message(String newtext) {
        text = newtext;
        if (text.length() > 256) {
            text = text.substring(0, 256);
        }
        text = text.replace('<', '[');
        text = text.replace('&', '_');
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the message id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the message itself
     */
    public String getText() {
        return text;
    }
}
