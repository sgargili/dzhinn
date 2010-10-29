/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ira.xml;

import org.w3c.dom.Document;

/**
 *
 * @author APopov
 */
public interface HttpData2Dom {

    public Document getDom(String url);

    public Document getDom(String url, boolean useProxy);

    public Document getDom(String url, String inputEncoding);

    public Document getDom(String url, String inputEncoding, boolean useProxy);

    public Document getDom(String url, String inputEncoding, String outputEncoding);

    public Document getDom(String url, String inputEncoding, String outputEncoding, boolean useProxy);
}
