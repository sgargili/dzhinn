/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing;

import processing.split.StrSepCom;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.util.Iterator;
import java.util.List;
import processing.split.StrSepNR;

/**
 *
 * @author Admin4DB2
 */
public class Export {

    public String Res(String Request) throws Exception {

        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.alias("product", ExportData.class);

        Request = Request.replaceAll("[\\[\\]]", "");

        ExportData sclassIn = (ExportData) xstream.fromXML(Request);

        String DataType = sclassIn.getDataType().trim();
        String Language = sclassIn.getLanguage().trim();
        String Status = sclassIn.getStatus().trim();
        String Data = sclassIn.getSubmitString().trim();
        String Submit = sclassIn.getReqMethod().trim();
        ArrayDuplDel ddd = new ArrayDuplDel();
        String[] Articles = ddd.ArrayDuplDel(StrSepNR.SplitString(Data));
        //String[] Articles = StrSepNR.SplitString(Data);
        String[] Languages = StrSepCom.SplitString(Language);
        String[] Statuses = StrSepCom.SplitString(Status);

        ExportProcess qqq = new ExportProcess();
        List newstr = qqq.getArticlesData2(Articles);
        String output = "<table bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=100%>";
        output += "<tr bgcolor = #2d4491 align=center><td><font color=white>№</font></td><td><font color=white>" + DataType + "</font></td><td><font color=white>ArticleID</font></td><td><font color=white>Request Action</font></td><td><font color=white>Request Status</font></td></tr>";
        Iterator itr = newstr.iterator();
        int j = 1;
        while (itr.hasNext()) {
            DataBean str = (DataBean) itr.next();
            output += "<tr bgcolor = #cfcdcd align=center><td style='padding-left:4px'>" + j + "</td><td style='padding-left:4px'>" + str.getArticle() + "</td><td style='padding-left:4px'>" + str.getArticle_Id() + "</td><td style='padding-left:4px'>" + Submit + "</td><td style='padding-left:4px'>" + str.getStatus() + "</td></tr>";
            j++;
        }
        output += "</table>";
        return output;
    }
}
