/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tempfile;

import factories.FactoryDAO4Grabli;
import service.OutputDataXML;

/**
 *
 * @author APOPOV
 */
public class QQQ {

    public static void main(String[] args) {
//    System.out.println(FactoryDAO4Grabli.getInstance().getOutputDataDAO().getOutputDataByGroupeByAttributeByNativeSQL("Mobile PC - Processor", "CPU").size());
//    OutputDataXML xml = new OutputDataXML();
//        System.out.println(xml.getOutputDataByAttributeAfter("1353", "Video Card - Video Output", "2285", "Stream Processors Quantity", 2+""));

//        System.out.println(((Object[])FactoryDAO4Grabli.getInstance().getRegexpDAO().getRegexpsByAttributeByGroupeByNativeSQL(1353, 2285).get(0))[4]);
        System.out.println(FactoryDAO4Grabli.getInstance().getOutputDataDAO().getSessiosnIdByArticleByNativeSQL("%").size());

    }
}
