package example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class GreetingServiceClient {

    public static void main(String[] args) {

        Resource config = new ClassPathResource("example/beans.xml");
        BeanFactory factory = new XmlBeanFactory(config);
        GreetingService bean = (GreetingService) factory.getBean("greetingService");
        System.out.println(bean.greet("Andrey"));
    }
}
