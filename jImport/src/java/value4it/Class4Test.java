/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package value4it;

import Pojo.ValueArticle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author Apopov
 */
public class Class4Test {

    public static void main(String[] args) throws XmlPullParserException, UnsupportedEncodingException, IOException {
        ValuePro vp = new ValuePro();
        String[] str = new String[3];
        str[0] = "111122233333344444445566";
        str[1] = "asasassssasasasasa";
        str[2] = "035K01222";
        List lst = vp.getArtclesIdByArticles(str);
        ValueArticle temp;
        for (Iterator it = lst.iterator(); it.hasNext();) {
            temp = (ValueArticle) it.next();
            System.out.println(temp.getArticle() + " -> " + temp.getArticleId()+" -> "+vp.isArticle(temp.getArticle()));
        }
        System.out.println(vp.buildResponse(lst, "Export"));
    }
}