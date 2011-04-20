package com.sitronics.spp;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitronics.spp.service.FileService;
import com.sitronics.spp.service.XmlService;

import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.Option;

/**
 * @author Andrey Popov creates on 11.04.11 (15:25)
 */
public class SPP {

    private static void printUsage() {
        System.err.println();
        System.err.println("Usage: java -jar SPP-1.0.jar {-i, --inFolder} a_inFolder {-o, --outFolder} a_outFolder {-e, --fileExtension} a_extension");
        System.err.println("Example: java -jar SPP-1.0.jar -i C://testFolder -o C://testOutputFolder -e .fcbat");
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        CmdLineParser parser = new CmdLineParser();
        Option inFolderOption = parser.addStringOption('i', "inFolder");
        Option outFolderOption = parser.addStringOption('o', "outFolder");
        Option extensionOption = parser.addStringOption('e', "fileExtension");

        try {
            parser.parse(args);
        } catch (CmdLineParser.OptionException e) {
            System.err.println(e.getMessage());
            printUsage();
            System.exit(0);
        }

        String inFolder = (String) parser.getOptionValue(inFolderOption);
        String outFolder = (String) parser.getOptionValue(outFolderOption);
        String fileExtension = (String) parser.getOptionValue(extensionOption);

        if (inFolder == null || outFolder == null || fileExtension == null) {
            printUsage();
        } else {
            ApplicationContext context = new ClassPathXmlApplicationContext("spp-config.xml");

            //Достаем файловый сервис из контекста...
            FileService fileService = (FileService) context.getBean("fileService");

            //Достаем xml сервис из контекста...
            XmlService xmlService = (XmlService) context.getBean("xmlService");

            //Копируем пакетные файлы...
            fileService.copy(inFolder, outFolder, fileExtension);

            //Создаем Xml файл...
            xmlService.createXml(outFolder);

            System.out.println();
            System.out.println("Job is Done! See content in: " + outFolder);
        }
    }
}
