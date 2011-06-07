package com.sitronics.spp.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import com.sitronics.spp.model.BatchTypes;
import com.sitronics.spp.model.publicationrecords.Publication;
import com.sitronics.spp.model.type.ImageProcessingOptions;
import com.sitronics.spp.model.type.PageSizeCheckingOptions;
import com.sitronics.spp.model.type.SeparationOptions;
import com.sitronics.spp.model.type.Type;
import com.sitronics.spp.model.type.exportoptions.*;
import com.sitronics.spp.model.type.registrationparameters.RegParam;
import com.sitronics.spp.service.XmlService;

/**
 * @author Andrey Popov creates on 11.04.11 (16:02)
 */
@Service("xmlService")
public class XmlServiceImpl implements XmlService {
    Logger logger = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Autowired(required = false)
    private Jaxb2Marshaller jaxb2Marshaller;

    //Достаем базовые параметры типов из контекста...
    @Autowired
    @Qualifier("separationOptions")
    private SeparationOptions separationOptions;
    @Autowired
    private ImageProcessingOptions imageProcessingOptions;
    @Autowired
    private PageSizeCheckingOptions pageSizeCheckingOptions;
    @Resource
    private Map<String, String> additionList;
    @Resource
    private Map<String, String> regionList;
    @Resource
    private Map<String, Integer> regionCodeList;
    @Resource
    private Map<String, String> packagesList;
    @Autowired
    private ImageSavingOptions imageSavingOptions;
    @Autowired
    @Qualifier("regParamPackageID")
    private RegParam regParamPackageID;
    @Autowired
    @Qualifier("regParamOperator")
    private RegParam regParamOperator;
    @Autowired
    @Qualifier("regParamDocScanDate")
    private RegParam regParamDocScanDate;
    @Autowired
    @Qualifier("regParamRegion")
    private RegParam regParamRegion;
    @Autowired
    @Qualifier("regParamProject")
    private RegParam regParamProject;
    @Autowired
    private ToFlexiCapture toFlexiCapture;
    @Autowired
    private ToFolder toFolder;
    @Autowired
    private ToFTP toFTP;
    @Autowired
    private ToRecognitionServer toRecognitionServer;
    @Autowired
    private Integer defaultBatchTypeID;
    @Autowired
    private Publication publication;
    @Autowired
    private Type type;
    @Autowired
    @Qualifier("tag")
    private String tag;
    @Autowired
    @Qualifier("defaultEncoding")
    private String defaultEncoding;

    private String marshal(BatchTypes batchTypes) {
        if (jaxb2Marshaller == null) {
            logger.debug("Jaxb2Marshaller is null... Please set Jaxb2Marshaller in context with name jaxb2Marshaller for more flexible.");
            logger.debug("Create Jaxb2Marshaller by default for {}...", BatchTypes.class);
            jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setClassesToBeBound(BatchTypes.class);
        }
        final StringWriter out = new StringWriter();
        jaxb2Marshaller.marshal(batchTypes, new StreamResult(out));
        return out.getBuffer().toString();
    }

    private BatchTypes unmarshal(String xmlData) {
        if (jaxb2Marshaller == null) {
            logger.debug("Jaxb2Marshaller is null... Please set Jaxb2Marshaller in context with name jaxb2Marshaller for more flexible.");
            logger.debug("Create Jaxb2Marshaller by default for {}...", BatchTypes.class);
            jaxb2Marshaller = new Jaxb2Marshaller();
            jaxb2Marshaller.setClassesToBeBound(BatchTypes.class);
        }
        BatchTypes batchTypes = new BatchTypes();
        jaxb2Marshaller.unmarshal(new StreamSource(new StringReader(xmlData)));
        return batchTypes;
    }

    @Override
    public void createXml(String outputFolder) {

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
        for (Map.Entry<String, String> pack : packagesList.entrySet()) {
            //Бежим по регионам...
            for (Map.Entry<String, String> entry : additionList.entrySet()) {
                //Клонируем тип из базового...
                type = (Type) type.clone();

                type.setUID(UUID.randomUUID().toString());

                //Собираем имя типа, аля 'Гарантийное_письмо_контрагента_МРДВ_Иркутская область'...
                builder.append(pack.getKey()).append("_").append(entry.getValue()).append("_").append(entry.getKey());

                type.setName(builder.toString());

                //Клонируем регистрационный параметр из базового...
                regParamRegion = (RegParam) regParamRegion.clone();
                regParamRegion.setValue(regionList.get(entry.getKey()));

                //Клонируем регистрационный параметр из базового...
                regParamProject = (RegParam) regParamProject.clone();
                regParamProject.setValue(pack.getValue());

                regParams = new ArrayList<RegParam>();
                regParams.add(regParamPackageID);
                regParams.add(regParamRegion);
                regParams.add(regParamProject);
                regParams.add(regParamOperator);
                regParams.add(regParamDocScanDate);

                type.setRegistrationParameters(regParams);

                //Клонируем экспортную опцию ToFlexiCapture из базового...
                toFlexiCapture = (ToFlexiCapture) toFlexiCapture.clone();
                toFlexiCapture.setBatchName(builder.toString());
                toFlexiCapture.setBatchTypeID(regionCodeList.get(builder.toString()));

                //Если в коллекции кодов регионов нету данных, выставляем дефолтный код ...
                if (regionCodeList.get(builder.toString()) == null || regionCodeList.get(builder.toString()).equals("")) {
                    toFlexiCapture.setBatchTypeID(defaultBatchTypeID);
                    logger.debug("This region {} is not found... Used default BatchTypeID: {} ", builder.toString(), defaultBatchTypeID);
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

        try {
            //Маршалим объект типов и суем его в файл...
            IOUtils.write(marshal(batchTypes), new FileOutputStream(outputFolder.replaceFirst("/$", "") + "/BatchTypes.xml"), defaultEncoding);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
