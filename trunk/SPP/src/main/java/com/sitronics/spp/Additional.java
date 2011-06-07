package com.sitronics.spp;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Andrey Popov creates on 07.06.11 (11:22)
 */
public class Additional {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spp-config.xml");

        Map<String, String> additionList = (Map<String, String>) context.getBean("additionList");
        List<String> packagesList = (List<String>) context.getBean("packagesList");
        int i = 1;

        for (Map.Entry<String, String> entry : additionList.entrySet()) {
            for (String pack : packagesList) {
                System.out.println("<entry key=\"" + pack + "_" + entry.getValue() + "_" + entry.getKey() + "\" value=\"" + i++ + "\"/>");
            }
        }
    }
}
//Общий пакет_МРДВ_Благовещенск (Амурская область)
