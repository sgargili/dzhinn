
package com.sitronics.filenet.imports.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sitronics.filenet.imports.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Name_QNAME = new QName("", "Name");
    private final static QName _Required_QNAME = new QName("", "Required");
    private final static QName _FileName_QNAME = new QName("", "FileName");
    private final static QName _Id_QNAME = new QName("", "Id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sitronics.filenet.imports.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExportDescriptor }
     * 
     */
    public ExportDescriptor createExportDescriptor() {
        return new ExportDescriptor();
    }

    /**
     * Create an instance of {@link ImportData }
     * 
     */
    public ImportData createImportData() {
        return new ImportData();
    }

    /**
     * Create an instance of {@link SourceObjectStore }
     * 
     */
    public SourceObjectStore createSourceObjectStore() {
        return new SourceObjectStore();
    }

    /**
     * Create an instance of {@link ContentLocation }
     * 
     */
    public ContentLocation createContentLocation() {
        return new ContentLocation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Required")
    public JAXBElement<Boolean> createRequired(Boolean value) {
        return new JAXBElement<Boolean>(_Required_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FileName")
    public JAXBElement<String> createFileName(String value) {
        return new JAXBElement<String>(_FileName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

}
