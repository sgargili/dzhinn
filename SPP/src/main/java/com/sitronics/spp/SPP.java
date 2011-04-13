package com.sitronics.spp;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitronics.spp.service.FileService;

import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.Option;

/**
 * @author Andrey Popov creates on 11.04.11 (15:25)
 */
public class SPP {

    private static FileService fileService;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spp-config.xml");

    private static void printUsage() {
        System.err.println(
                "Usage: java -jar SPP.jar {-i, --inFolder} a_inFolder {-o, --outFolder} a_outFolder {-e, --fileExtension} a_extension");
    }

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
            fileService = (FileService) context.getBean("fileService");
            fileService.copy(inFolder, outFolder, fileExtension);
        }
    }
}
