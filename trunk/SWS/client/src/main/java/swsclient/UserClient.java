package swsclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

public class UserClient {

    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private static WebServiceTemplate webServiceTemplate = (WebServiceTemplate) applicationContext.getBean("webServiceTemplate");

    public static void main(String[] args) {
        User user = new User();
        user.setLogin("Login 1936");
        System.out.println(((User) webServiceTemplate.marshalSendAndReceive(user)).getName());
    }

}
