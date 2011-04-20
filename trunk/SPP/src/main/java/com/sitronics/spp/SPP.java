package com.sitronics.spp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitronics.spp.model.BatchTypes;
import com.sitronics.spp.model.publicationrecords.Publication;
import com.sitronics.spp.model.type.ImageProcessingOptions;
import com.sitronics.spp.model.type.PageSizeCheckingOptions;
import com.sitronics.spp.model.type.SeparationOptions;
import com.sitronics.spp.model.type.Type;
import com.sitronics.spp.model.type.exportoptions.*;
import com.sitronics.spp.model.type.registrationparameters.RegParam;
import com.sitronics.spp.service.FileService;
import com.sitronics.spp.service.XmlService;

import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.Option;

/**
 * @author Andrey Popov creates on 11.04.11 (15:25)
 */
public class SPP {

    private static FileService fileService;
    private static XmlService xmlService;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spp-config.xml");

    private static void printUsage() {
        System.err.println(
                "Usage: java -jar SPP.jar {-i, --inFolder} a_inFolder {-o, --outFolder} a_outFolder {-e, --fileExtension} a_extension \n" +
                        "Example: java -jar SPP.jar -i C://testFolder -o C://testOutputFolder -e .fcbat");
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
            //Достаем файловый сервис из контекста...
            fileService = (FileService) context.getBean("fileService");

            //Копируем пакетные файлы...
            fileService.copy(inFolder, outFolder, fileExtension);

            //Достаем xml сервис из контекста...
            xmlService = (XmlService) context.getBean("xmlService");

            //Достаем базовые параметры типов из контекста...
            SeparationOptions separationOptions = (SeparationOptions) context.getBean("separationOptions");
            ImageProcessingOptions imageProcessingOptions = (ImageProcessingOptions) context.getBean("imageProcessingOptions");
            PageSizeCheckingOptions pageSizeCheckingOptions = (PageSizeCheckingOptions) context.getBean("pageSizeCheckingOptions");
            Map<String, String> additionList = (Map<String, String>) context.getBean("additionList");
            Map<String, String> regionList = (Map<String, String>) context.getBean("regionList");
            Map<String, Integer> regionCodeList = (Map<String, Integer>) context.getBean("regionCodeList");
            List<String> packagesList = (List<String>) context.getBean("packagesList");
            ImageSavingOptions imageSavingOptions = (ImageSavingOptions) context.getBean("imageSavingOptions");
            RegParam regParamPackageID = (RegParam) context.getBean("regParamPackageID");
            RegParam regParamRegion = (RegParam) context.getBean("regParamRegion");
            ToFlexiCapture toFlexiCapture = (ToFlexiCapture) context.getBean("toFlexiCapture");
            ToFolder toFolder = (ToFolder) context.getBean("toFolder");
            ToFTP toFTP = (ToFTP) context.getBean("toFTP");
            ToRecognitionServer toRecognitionServer = (ToRecognitionServer) context.getBean("toRecognitionServer");
            Integer defaultBatchTypeID = (Integer) context.getBean("defaultBatchTypeID");
            Publication publication = (Publication) context.getBean("publication");
            Type type = (Type) context.getBean("type");
            String tag = (String) context.getBean("tag");

            //Буфер для формирования имени типа...
            StringBuilder builder = new StringBuilder();

            //Коллекции параметров типов...
            List<RegParam> regParams;
            List<ExportOptionBase> exportOptions;
            List<Type> types = new ArrayList<Type>();
            List<Publication> publications = new ArrayList<Publication>();

            //Объект содержащий все типы документов...
            BatchTypes batchTypes = new BatchTypes();

            //Бежим по коллекции типов пакетов...
            for (String pack : packagesList) {
                //Бежим по регионам...
                for (Map.Entry<String, String> entry : additionList.entrySet()) {
                    //Клонируем тип из базового...
                    type = (Type) type.clone();

                    type.setUID(UUID.randomUUID().toString());

                    //Собираем имя типа, аля 'Гарантийное_письмо_контрагента_МРДВ_Иркутская область'...
                    builder.append(pack).append("_").append(entry.getValue()).append("_").append(entry.getKey());

                    type.setName(builder.toString());

                    //Клонируем регистрационный параметр из базового...
                    regParamRegion = (RegParam) regParamRegion.clone();
                    regParamRegion.setValue(regionList.get(entry.getKey()));

                    regParams = new ArrayList<RegParam>();
                    regParams.add(regParamPackageID);
                    regParams.add(regParamRegion);

                    type.setRegistrationParameters(regParams);

                    //Клонируем экспортную опцию ToFlexiCapture из базового...
                    toFlexiCapture = (ToFlexiCapture) toFlexiCapture.clone();
                    toFlexiCapture.setBatchName(builder.toString());
                    toFlexiCapture.setBatchTypeID(regionCodeList.get(builder.toString()));

                    //Если в коллекции кодов регионов нету данных, выставляем дефолтный код ...
                    if (regionCodeList.get(builder.toString()) == null || regionCodeList.get(builder.toString()).equals("")) {
                        toFlexiCapture.setBatchTypeID(defaultBatchTypeID);
                    }

                    //Собираем экспортные опции...
                    exportOptions = new ArrayList<ExportOptionBase>();
                    exportOptions.add(toFolder);
                    exportOptions.add(toFTP);
                    exportOptions.add(toFlexiCapture);
                    exportOptions.add(toRecognitionServer);

                    type.setExportOptions(exportOptions);

                    types.add(type);

                    //Опустошаем буфер имени типа...
                    builder.setLength(0);
                }
            }
            //Добавляем базовую публикацию...
            publications.add(publication);

            //Собираем все типы...
            batchTypes.setPublicationRecords(publications);
            batchTypes.setTypes(types);
            batchTypes.setTag(tag);

            //Маршалим объект типов и суем его в файл...
            IOUtils.write(xmlService.marshal(batchTypes), new FileOutputStream(outFolder.replaceFirst("/$", "") + "/BatchTypes.xml"));

        }
    }
}
