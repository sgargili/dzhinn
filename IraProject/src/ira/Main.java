package ira;

import ira.httpclient.FactoryHttpData;
import ira.xml.FactoryHtml2Xml;
import org.xmlpull.v1.XmlPullParser;


/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 26.10.2010
 * Time: 22:32:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {



    public static void main(final String[] args) throws Exception {

        /*Data data = new Data();
        data.setArticle("Article1");
        data.setAttribute("Product Type");
        data.setValue("Mobile PC");
        FactoryDao fd = FactoryDao.getInstance();
       // fd.getDataDao().saveData(data);
        System.out.println(fd.getDataDao().getAllData().size());*/

        FactoryHtml2Xml fXml =  FactoryHtml2Xml.getInstance();
        XmlPullParser xml = fXml.getHttpData2Xpp().getXpp("http://www.nix.ru");
        System.out.println(xml.getInputEncoding());
    }
}
