/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package xml;

import factories.FactoryHTML2XML;

/**
 *
 * @author Apopov
 */
public class NewClass {
    public static void main(String[] args) {
        Html2Xml xml = FactoryHTML2XML.getInstance().getHtml2Xml();
//        File file = new File("<html>");
        xml.convertHtml2Xml("<html>Hello");
    }
}
