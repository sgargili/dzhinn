package com.example.dwr.simple;
import com.example.dwr.simple.*;
import java.util.regex.*;

import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.json.*;


public class DemoN {
public static boolean ArticleVerification(String art) throws Exception {
return true;
}
public static String Export(String ArtID) throws Exception {


return "Passed";

}
public static String [] strengthenSentence(String sentence) throws Exception {
    String retval = null;
    String[] tokens = null;
    String splitPattern = ",";
    if(!sentence.equals("")){
    tokens = sentence.split(splitPattern);
    
    } else{
    
    }
    return tokens;
  }
public static String ArticleID( String art) throws Exception {
return "123456789";
}

public String Ret (String name) throws Exception
    {

      XStream xstream = new XStream(new JettisonMappedXmlDriver()); // require XPP3 library

      xstream.alias("product",  qSend.class);

	  String xml = "{\"product\":{\"datatype\":\"ArticleID\",\"language\":\"All\",\"status\":\"Done\",\"newnew\":\"1,2,3,4,5,6,7\",\"submit\":\"Export\"}}";
String xmlnew = null;

 String re = "(.*)\\[(.*)\\](.*)";
					Pattern p = Pattern.compile(re);
					Matcher m = p.matcher(name);
						if(m.matches())
							{
								xmlnew = m.group(1)+m.group(2)+m.group(3);
							}
							

      // Deserialize

      qSend sclassIn = (qSend) xstream.fromXML(xml);
	  String temp = "|||       "+name+"       |||    dataType -> "+sclassIn.getType()+" language -> "+sclassIn.getLang()+" status -> "+sclassIn.getStat()+" data -> "+sclassIn.getNew()+" submit -> "+sclassIn.getSub();
	  String out = null;
	  String DataType = sclassIn.getType().trim();
	  String Lang = sclassIn.getLang().trim();
	  String Status = sclassIn.getStat().trim();
	  String Data = sclassIn.getNew().trim();
	  String Submit = sclassIn.getSub().trim();
	  String [] art = strengthenSentence(Data);
	  String ArtID = null;

	  if(DataType.equals("Artic1e")){
	out = ("<table bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=98%>");
	out += ("<tr bgcolor = #2d4491 align=center><td><font color=white>"+DataType+"</font></td><td><font color=white>Exist</font></td><td><font color=white>ArticleID</font></td><td><font color=white>Request Action</font></td><td><font color=white>Request Status</font></td></tr>");
	for (int i=0;i<art.length;i++) {
		if (ArticleVerification(art[i]))
		{ArtID = ArticleID(art[i]);
	out+=("<tr bgcolor = #cfcdcd><td style='padding-left:4px'>" + art[i]+"</td><td style='padding-left:4px'>Yes</td><td style='padding-left:4px'>" + ArtID +"</td><td style='padding-left:4px'>");
	out+=("Export");
	out+=("</td><td style='padding-left:4px'>");
	out+=(Export(ArtID));
	out+=("</td></tr>");
	} else{
	out+=("<tr bgcolor = #cfcdcd><td style='padding-left:4px'>" + art[i]+"</td><td style='padding-left:4px'><font color=red>No</font></td><td style='padding-left:4px'><font color=red>-</font></td></td><td style='padding-left:4px'><font color=red>-</font></td></td><td style='padding-left:4px'><font color=red>-</font></td></td></tr>");
	}}
	out+=("</table>");
	
		}
	else{
	
	out=("<table bgcolor=black align=center cellspacing='1' cellpadding='1' border=0 width=98%>");
	out+=("<tr bgcolor = #2d4491 align=center><td><font color=white>" + DataType +"</font></td><td><font color=white>Request Action</font></td><td><font color=white>Request Status</font></td></tr>");
	for (int i=0;i<art.length;i++) {
	out+=("<tr bgcolor = #cfcdcd><td style='padding-left:4px'>" + art[i]+"</td><td style='padding-left:4px'>");
	out+=("Export");
	out+=("</td><td style='padding-left:4px'>");
	out+=(Export(ArtID));
	out+=("</td></tr>");
	}
	out+=("</table>");
	}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  return out;
	 //return name;
	    //    System.out.println(xml);


      //System.out.println("dataType ---->>>> " + sclassIn.getsubmit());

      //System.out.println("sclassOut.intfield == sclassIn.intfield: " + (sclassOut.getIntfield() == sclassIn.getIntfield()));

      //System.out.println("sclassOut.doublefield == sclassIn.doublefield: " + (sclassOut.getDoublefield() == sclassIn.getDoublefield()));

   }

}
