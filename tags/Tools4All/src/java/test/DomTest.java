/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import factories.FactoryDAO4Grabli;
import factories.FactoryHTTPData2XmlParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import pojo.Attribute;
import pojo.ParentRelateElement;
import pojo.ProductType;
import xml.HttpData2Dom;

/**
 *
 * @author APopov
 */
public class DomTest {

    static FactoryDAO4Grabli fd;
    static List<ParentRelateElement> prsP;
    static List<ParentRelateElement> prsR;
    static List<Attribute> atrs;
    static ParentRelateElement pr = new ParentRelateElement();
    static List<String> attributes = new ArrayList();
    static List<Node> nodes = new ArrayList();
    static byte b;

    public static void main(String[] arg) {
        HttpData2Dom dom = FactoryHTTPData2XmlParser.getInstance().getHttpData2Dom();
        Document doc = dom.getDom("http://192.168.1.177/pro.jsp", "WINDOWS-1251", "WINDOWS-1251");

        fd = FactoryDAO4Grabli.getInstance();
        prsP = fd.getParentRelateElementDAO().getAllParentRelateElementsByType(ParentRelateElement.PARENT);
        prsR = fd.getParentRelateElementDAO().getAllParentRelateElementsByType(ParentRelateElement.RELATE);
        ProductType pt = new ProductType();
        Attribute atr;
        pt.setProductTypeId(8);
        atrs = fd.getAttributeDAO().getAttributesOnlyByProductType(pt);
        Iterator it = atrs.iterator();
        String[] mass;
        while (it.hasNext()) {
            atr = (Attribute) it.next();
            mass = atr.getAttributeAlternative().split(",");
            for (int i = 0; i < mass.length; i++) {
                if (!mass[i].trim().equals("") && mass[i].trim() != null) {
                    attributes.add(mass[i].trim());
                }
            }

        }
//        Iterator iter = attributes.iterator();
//        String str;
//        int w = 1;
//        while (iter.hasNext()) {
//            str = (String) iter.next();
//            System.out.println(w++ + " - " + str);
//        }

        visit(doc, 0);
        System.out.println(nodes.size());
        NodeList nodess = nodes.get(2).getParentNode().getParentNode().getChildNodes();
        for (int k = 0; k < nodes.size(); k++) {
            System.out.println(nodess.item(k).getTextContent());
        }

    }

    public static void visit(Node node, int level) {
        b = 1;
        pr.setParentRelateElementType(b);
        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            pr.setParentRelateElementName(nl.item(i).getParentNode().getNodeName());
            if ((attributes.contains(nl.item(i).getTextContent())) &&
                    (prsR.contains(pr))) {
                System.out.println("Тег: [" + nl.item(i).getTextContent() + "] Parrent Node: [" + nl.item(i).getParentNode().getNodeName() + "]");
                nodes.add(node);
            }
            //System.out.println("[" + nl.item(i).getNodeValue() + "]");
            //System.out.println(nl.item(i).getNodeName());
            visit(nl.item(i), level + 1);
        }

    }
}
