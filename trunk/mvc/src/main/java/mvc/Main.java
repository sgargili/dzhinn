package mvc;

import mvc.dto.DataRequest;
import mvc.dto.DataResponce;
import mvc.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Andrey Popov
 * Date: 20.12.10
 * Time: 10:31
 */
public class Main {
    //    private static ApplicationContext context =  new ClassPathXmlApplicationContext("mvc-servlet.xml");
////    @Autowired
//    private static DataService dataService;
    private static Map<String, String> mapEscapeContentName = new HashMap<String, String>();

    protected static String escapeContentName(String contentName) {
        if (mapEscapeContentName == null || contentName == null) return contentName;
        for (String key : mapEscapeContentName.keySet()) {
            contentName = contentName.replaceAll(key, mapEscapeContentName.get(key));
        }
        return contentName;
    }

    public static void main(String[] args) {
//        Jaxb2Marshaller marshaller = (Jaxb2Marshaller) context.getBean("xmlMarshaller");
//        dataService  =  (DataService) context.getBean("dataService");
//        Result result = new StreamResult(System.out);
//        DataRequest dataRequest = new DataRequest();
//        dataRequest.setRequestType(0);
//        dataRequest.setArticle("N00104079026");
//        DataResponce dataResponce = dataService.getDataResponce(dataRequest);
//        marshaller.marshal(dataResponce, result);
        mapEscapeContentName.put("/", ",");
        String str = "Приказ о выплате премии / вознаграждения руководящим работникам";
        System.out.println(escapeContentName(str));

    }
}
