
package mypackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
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

    private final static QName _DataType_QNAME = new QName("", "DataType");
    private final static QName _LifeCycleActions_QNAME = new QName("", "LifeCycleActions");
    private final static QName _ChoiceType_QNAME = new QName("", "ChoiceType");
    private final static QName _SecurityProxyType_QNAME = new QName("", "SecurityProxyType");
    private final static QName _LocalizedText_QNAME = new QName("", "LocalizedText");
    private final static QName _LifeCyclePolicies_QNAME = new QName("", "LifeCyclePolicies");
    private final static QName _ModificationAccessRequired_QNAME = new QName("", "ModificationAccessRequired");
    private final static QName _Cardinality_QNAME = new QName("", "Cardinality");
    private final static QName _IsValueRequired_QNAME = new QName("", "IsValueRequired");
    private final static QName _DateLastModified_QNAME = new QName("", "DateLastModified");
    private final static QName _AuditSuccess_QNAME = new QName("", "AuditSuccess");
    private final static QName _PropertyDefaultBoolean_QNAME = new QName("", "PropertyDefaultBoolean");
    private final static QName _UsesLongColumn_QNAME = new QName("", "UsesLongColumn");
    private final static QName _ExternalReplicaIdentities_QNAME = new QName("", "ExternalReplicaIdentities");
    private final static QName _ObjectId_QNAME = new QName("", "ObjectId");
    private final static QName _PropertyMinimumInteger32_QNAME = new QName("", "PropertyMinimumInteger32");
    private final static QName _IsNameProperty_QNAME = new QName("", "IsNameProperty");
    private final static QName _SymbolicName_QNAME = new QName("", "SymbolicName");
    private final static QName _MaximumLengthString_QNAME = new QName("", "MaximumLengthString");
    private final static QName _DateCreated_QNAME = new QName("", "DateCreated");
    private final static QName _MaximumLengthBinary_QNAME = new QName("", "MaximumLengthBinary");
    private final static QName _CopyToReservation_QNAME = new QName("", "CopyToReservation");
    private final static QName _PropertyDefaultDateTime_QNAME = new QName("", "PropertyDefaultDateTime");
    private final static QName _ChoiceIntegerValue_QNAME = new QName("", "ChoiceIntegerValue");
    private final static QName _PropertyDefaultInteger32_QNAME = new QName("", "PropertyDefaultInteger32");
    private final static QName _AliasIds_QNAME = new QName("", "AliasIds");
    private final static QName _PropertyDefaultId_QNAME = new QName("", "PropertyDefaultId");
    private final static QName _PropertyDisplayCategory_QNAME = new QName("", "PropertyDisplayCategory");
    private final static QName _PrimaryId_QNAME = new QName("", "PrimaryId");
    private final static QName _Id_QNAME = new QName("", "Id");
    private final static QName _AllowsForeignObject_QNAME = new QName("", "AllowsForeignObject");
    private final static QName _LocaleName_QNAME = new QName("", "LocaleName");
    private final static QName _MarkingSet_QNAME = new QName("", "MarkingSet");
    private final static QName _PropertyMaximumInteger32_QNAME = new QName("", "PropertyMaximumInteger32");
    private final static QName _AllowsInstances_QNAME = new QName("", "AllowsInstances");
    private final static QName _IsHidden_QNAME = new QName("", "IsHidden");
    private final static QName _PersistenceType_QNAME = new QName("", "PersistenceType");
    private final static QName _LastModifier_QNAME = new QName("", "LastModifier");
    private final static QName _PropertyMinimumDateTime_QNAME = new QName("", "PropertyMinimumDateTime");
    private final static QName _DeletionAction_QNAME = new QName("", "DeletionAction");
    private final static QName _TargetAccessRequired_QNAME = new QName("", "TargetAccessRequired");
    private final static QName _ReplicationGroup_QNAME = new QName("", "ReplicationGroup");
    private final static QName _ReflectivePropertyId_QNAME = new QName("", "ReflectivePropertyId");
    private final static QName _IncludeSubclassesRequested_QNAME = new QName("", "IncludeSubclassesRequested");
    private final static QName _PropertyDefaultString_QNAME = new QName("", "PropertyDefaultString");
    private final static QName _ExternalAliases_QNAME = new QName("", "ExternalAliases");
    private final static QName _RequiresUniqueElements_QNAME = new QName("", "RequiresUniqueElements");
    private final static QName _ObjectStateRecordingLevel_QNAME = new QName("", "ObjectStateRecordingLevel");
    private final static QName _ClassId_QNAME = new QName("", "ClassId");
    private final static QName _DescriptiveText_QNAME = new QName("", "DescriptiveText");
    private final static QName _Creator_QNAME = new QName("", "Creator");
    private final static QName _PropertyDefaultBinary_QNAME = new QName("", "PropertyDefaultBinary");
    private final static QName _PropertyMaximumDateTime_QNAME = new QName("", "PropertyMaximumDateTime");
    private final static QName _Settability_QNAME = new QName("", "Settability");
    private final static QName _DisplayName_QNAME = new QName("", "DisplayName");
    private final static QName _AuditFailure_QNAME = new QName("", "AuditFailure");
    private final static QName _Name_QNAME = new QName("", "Name");
    private final static QName _ChoiceStringValue_QNAME = new QName("", "ChoiceStringValue");
    private final static QName _IsCBREnabled_QNAME = new QName("", "IsCBREnabled");
    private final static QName _ObjectType_QNAME = new QName("", "ObjectType");
    private final static QName _RequiredClassId_QNAME = new QName("", "RequiredClassId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PropertyTemplateObjectProperties }
     * 
     */
    public PropertyTemplateObjectProperties createPropertyTemplateObjectProperties() {
        return new PropertyTemplateObjectProperties();
    }

    /**
     * Create an instance of {@link PropertyDefinitionDateTime }
     * 
     */
    public PropertyDefinitionDateTime createPropertyDefinitionDateTime() {
        return new PropertyDefinitionDateTime();
    }

    /**
     * Create an instance of {@link PropertyTemplateBoolean }
     * 
     */
    public PropertyTemplateBoolean createPropertyTemplateBoolean() {
        return new PropertyTemplateBoolean();
    }

    /**
     * Create an instance of {@link DocumentClassDefinitionProperties }
     * 
     */
    public DocumentClassDefinitionProperties createDocumentClassDefinitionProperties() {
        return new DocumentClassDefinitionProperties();
    }

    /**
     * Create an instance of {@link PropertyDefinitionString }
     * 
     */
    public PropertyDefinitionString createPropertyDefinitionString() {
        return new PropertyDefinitionString();
    }

    /**
     * Create an instance of {@link PropertyDefinitionBinary }
     * 
     */
    public PropertyDefinitionBinary createPropertyDefinitionBinary() {
        return new PropertyDefinitionBinary();
    }

    /**
     * Create an instance of {@link PropertyTemplateDateTime }
     * 
     */
    public PropertyTemplateDateTime createPropertyTemplateDateTime() {
        return new PropertyTemplateDateTime();
    }

    /**
     * Create an instance of {@link ChoiceList }
     * 
     */
    public ChoiceList createChoiceList() {
        return new ChoiceList();
    }

    /**
     * Create an instance of {@link ChoiceLists }
     * 
     */
    public ChoiceLists createChoiceLists() {
        return new ChoiceLists();
    }

    /**
     * Create an instance of {@link PropertyTemplateIdProperties }
     * 
     */
    public PropertyTemplateIdProperties createPropertyTemplateIdProperties() {
        return new PropertyTemplateIdProperties();
    }

    /**
     * Create an instance of {@link AuditDefinition }
     * 
     */
    public AuditDefinition createAuditDefinition() {
        return new AuditDefinition();
    }

    /**
     * Create an instance of {@link PropertyTemplateString }
     * 
     */
    public PropertyTemplateString createPropertyTemplateString() {
        return new PropertyTemplateString();
    }

    /**
     * Create an instance of {@link PropertyDefinitionInteger32 }
     * 
     */
    public PropertyDefinitionInteger32 createPropertyDefinitionInteger32() {
        return new PropertyDefinitionInteger32();
    }

    /**
     * Create an instance of {@link LocalizedString }
     * 
     */
    public LocalizedString createLocalizedString() {
        return new LocalizedString();
    }

    /**
     * Create an instance of {@link PropertyTemplateBinaryProperties }
     * 
     */
    public PropertyTemplateBinaryProperties createPropertyTemplateBinaryProperties() {
        return new PropertyTemplateBinaryProperties();
    }

    /**
     * Create an instance of {@link PropertyTemplateBooleanProperties }
     * 
     */
    public PropertyTemplateBooleanProperties createPropertyTemplateBooleanProperties() {
        return new PropertyTemplateBooleanProperties();
    }

    /**
     * Create an instance of {@link DisplayNames }
     * 
     */
    public DisplayNames createDisplayNames() {
        return new DisplayNames();
    }

    /**
     * Create an instance of {@link PropertyTemplateInteger32 }
     * 
     */
    public PropertyTemplateInteger32 createPropertyTemplateInteger32() {
        return new PropertyTemplateInteger32();
    }

    /**
     * Create an instance of {@link AuditDefinitions }
     * 
     */
    public AuditDefinitions createAuditDefinitions() {
        return new AuditDefinitions();
    }

    /**
     * Create an instance of {@link PropertyTemplateStringProperties }
     * 
     */
    public PropertyTemplateStringProperties createPropertyTemplateStringProperties() {
        return new PropertyTemplateStringProperties();
    }

    /**
     * Create an instance of {@link PropertyTemplateInteger32Properties }
     * 
     */
    public PropertyTemplateInteger32Properties createPropertyTemplateInteger32Properties() {
        return new PropertyTemplateInteger32Properties();
    }

    /**
     * Create an instance of {@link ChoiceListProperties }
     * 
     */
    public ChoiceListProperties createChoiceListProperties() {
        return new ChoiceListProperties();
    }

    /**
     * Create an instance of {@link PropertyDefaultObject }
     * 
     */
    public PropertyDefaultObject createPropertyDefaultObject() {
        return new PropertyDefaultObject();
    }

    /**
     * Create an instance of {@link Choice }
     * 
     */
    public Choice createChoice() {
        return new Choice();
    }

    /**
     * Create an instance of {@link PropertyDefinitionObject }
     * 
     */
    public PropertyDefinitionObject createPropertyDefinitionObject() {
        return new PropertyDefinitionObject();
    }

    /**
     * Create an instance of {@link PropertyDefinitionBoolean }
     * 
     */
    public PropertyDefinitionBoolean createPropertyDefinitionBoolean() {
        return new PropertyDefinitionBoolean();
    }

    /**
     * Create an instance of {@link PropertyTemplates }
     * 
     */
    public PropertyTemplates createPropertyTemplates() {
        return new PropertyTemplates();
    }

    /**
     * Create an instance of {@link EventClass }
     * 
     */
    public EventClass createEventClass() {
        return new EventClass();
    }

    /**
     * Create an instance of {@link PropertyTemplateObject }
     * 
     */
    public PropertyTemplateObject createPropertyTemplateObject() {
        return new PropertyTemplateObject();
    }

    /**
     * Create an instance of {@link ExportedObjects }
     * 
     */
    public ExportedObjects createExportedObjects() {
        return new ExportedObjects();
    }

    /**
     * Create an instance of {@link DescriptiveTexts }
     * 
     */
    public DescriptiveTexts createDescriptiveTexts() {
        return new DescriptiveTexts();
    }

    /**
     * Create an instance of {@link ChoiceValues }
     * 
     */
    public ChoiceValues createChoiceValues() {
        return new ChoiceValues();
    }

    /**
     * Create an instance of {@link PropertyDefinitions }
     * 
     */
    public PropertyDefinitions createPropertyDefinitions() {
        return new PropertyDefinitions();
    }

    /**
     * Create an instance of {@link ObjectRef }
     * 
     */
    public ObjectRef createObjectRef() {
        return new ObjectRef();
    }

    /**
     * Create an instance of {@link PropertyTemplateBinary }
     * 
     */
    public PropertyTemplateBinary createPropertyTemplateBinary() {
        return new PropertyTemplateBinary();
    }

    /**
     * Create an instance of {@link ClassDefinitions }
     * 
     */
    public ClassDefinitions createClassDefinitions() {
        return new ClassDefinitions();
    }

    /**
     * Create an instance of {@link SuperclassDefinition }
     * 
     */
    public SuperclassDefinition createSuperclassDefinition() {
        return new SuperclassDefinition();
    }

    /**
     * Create an instance of {@link PropertyTemplateDateTimeProperties }
     * 
     */
    public PropertyTemplateDateTimeProperties createPropertyTemplateDateTimeProperties() {
        return new PropertyTemplateDateTimeProperties();
    }

    /**
     * Create an instance of {@link DocumentClassDefinition }
     * 
     */
    public DocumentClassDefinition createDocumentClassDefinition() {
        return new DocumentClassDefinition();
    }

    /**
     * Create an instance of {@link PropertyTemplateId }
     * 
     */
    public PropertyTemplateId createPropertyTemplateId() {
        return new PropertyTemplateId();
    }

    /**
     * Create an instance of {@link PropertyDefinitionId }
     * 
     */
    public PropertyDefinitionId createPropertyDefinitionId() {
        return new PropertyDefinitionId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DataType")
    public JAXBElement<Byte> createDataType(Byte value) {
        return new JAXBElement<Byte>(_DataType_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LifeCycleActions")
    public JAXBElement<String> createLifeCycleActions(String value) {
        return new JAXBElement<String>(_LifeCycleActions_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ChoiceType")
    public JAXBElement<Byte> createChoiceType(Byte value) {
        return new JAXBElement<Byte>(_ChoiceType_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SecurityProxyType")
    public JAXBElement<String> createSecurityProxyType(String value) {
        return new JAXBElement<String>(_SecurityProxyType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LocalizedText")
    public JAXBElement<String> createLocalizedText(String value) {
        return new JAXBElement<String>(_LocalizedText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LifeCyclePolicies")
    public JAXBElement<String> createLifeCyclePolicies(String value) {
        return new JAXBElement<String>(_LifeCyclePolicies_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ModificationAccessRequired")
    public JAXBElement<String> createModificationAccessRequired(String value) {
        return new JAXBElement<String>(_ModificationAccessRequired_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Cardinality")
    public JAXBElement<Byte> createCardinality(Byte value) {
        return new JAXBElement<Byte>(_Cardinality_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsValueRequired")
    public JAXBElement<String> createIsValueRequired(String value) {
        return new JAXBElement<String>(_IsValueRequired_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DateLastModified")
    public JAXBElement<XMLGregorianCalendar> createDateLastModified(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateLastModified_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AuditSuccess")
    public JAXBElement<Byte> createAuditSuccess(Byte value) {
        return new JAXBElement<Byte>(_AuditSuccess_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyDefaultBoolean")
    public JAXBElement<String> createPropertyDefaultBoolean(String value) {
        return new JAXBElement<String>(_PropertyDefaultBoolean_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UsesLongColumn")
    public JAXBElement<Byte> createUsesLongColumn(Byte value) {
        return new JAXBElement<Byte>(_UsesLongColumn_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExternalReplicaIdentities")
    public JAXBElement<String> createExternalReplicaIdentities(String value) {
        return new JAXBElement<String>(_ExternalReplicaIdentities_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ObjectId")
    public JAXBElement<String> createObjectId(String value) {
        return new JAXBElement<String>(_ObjectId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyMinimumInteger32")
    public JAXBElement<String> createPropertyMinimumInteger32(String value) {
        return new JAXBElement<String>(_PropertyMinimumInteger32_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsNameProperty")
    public JAXBElement<Byte> createIsNameProperty(Byte value) {
        return new JAXBElement<Byte>(_IsNameProperty_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SymbolicName")
    public JAXBElement<String> createSymbolicName(String value) {
        return new JAXBElement<String>(_SymbolicName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MaximumLengthString")
    public JAXBElement<String> createMaximumLengthString(String value) {
        return new JAXBElement<String>(_MaximumLengthString_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DateCreated")
    public JAXBElement<XMLGregorianCalendar> createDateCreated(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateCreated_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MaximumLengthBinary")
    public JAXBElement<String> createMaximumLengthBinary(String value) {
        return new JAXBElement<String>(_MaximumLengthBinary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CopyToReservation")
    public JAXBElement<Byte> createCopyToReservation(Byte value) {
        return new JAXBElement<Byte>(_CopyToReservation_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyDefaultDateTime")
    public JAXBElement<String> createPropertyDefaultDateTime(String value) {
        return new JAXBElement<String>(_PropertyDefaultDateTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ChoiceIntegerValue")
    public JAXBElement<String> createChoiceIntegerValue(String value) {
        return new JAXBElement<String>(_ChoiceIntegerValue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyDefaultInteger32")
    public JAXBElement<String> createPropertyDefaultInteger32(String value) {
        return new JAXBElement<String>(_PropertyDefaultInteger32_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AliasIds")
    public JAXBElement<String> createAliasIds(String value) {
        return new JAXBElement<String>(_AliasIds_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyDefaultId")
    public JAXBElement<String> createPropertyDefaultId(String value) {
        return new JAXBElement<String>(_PropertyDefaultId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyDisplayCategory")
    public JAXBElement<String> createPropertyDisplayCategory(String value) {
        return new JAXBElement<String>(_PropertyDisplayCategory_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PrimaryId")
    public JAXBElement<String> createPrimaryId(String value) {
        return new JAXBElement<String>(_PrimaryId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AllowsForeignObject")
    public JAXBElement<String> createAllowsForeignObject(String value) {
        return new JAXBElement<String>(_AllowsForeignObject_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LocaleName")
    public JAXBElement<String> createLocaleName(String value) {
        return new JAXBElement<String>(_LocaleName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MarkingSet")
    public JAXBElement<String> createMarkingSet(String value) {
        return new JAXBElement<String>(_MarkingSet_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyMaximumInteger32")
    public JAXBElement<String> createPropertyMaximumInteger32(String value) {
        return new JAXBElement<String>(_PropertyMaximumInteger32_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AllowsInstances")
    public JAXBElement<Byte> createAllowsInstances(Byte value) {
        return new JAXBElement<Byte>(_AllowsInstances_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsHidden")
    public JAXBElement<String> createIsHidden(String value) {
        return new JAXBElement<String>(_IsHidden_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PersistenceType")
    public JAXBElement<Byte> createPersistenceType(Byte value) {
        return new JAXBElement<Byte>(_PersistenceType_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LastModifier")
    public JAXBElement<String> createLastModifier(String value) {
        return new JAXBElement<String>(_LastModifier_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyMinimumDateTime")
    public JAXBElement<String> createPropertyMinimumDateTime(String value) {
        return new JAXBElement<String>(_PropertyMinimumDateTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DeletionAction")
    public JAXBElement<String> createDeletionAction(String value) {
        return new JAXBElement<String>(_DeletionAction_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TargetAccessRequired")
    public JAXBElement<String> createTargetAccessRequired(String value) {
        return new JAXBElement<String>(_TargetAccessRequired_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ReplicationGroup")
    public JAXBElement<String> createReplicationGroup(String value) {
        return new JAXBElement<String>(_ReplicationGroup_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ReflectivePropertyId")
    public JAXBElement<String> createReflectivePropertyId(String value) {
        return new JAXBElement<String>(_ReflectivePropertyId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IncludeSubclassesRequested")
    public JAXBElement<Byte> createIncludeSubclassesRequested(Byte value) {
        return new JAXBElement<Byte>(_IncludeSubclassesRequested_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyDefaultString")
    public JAXBElement<String> createPropertyDefaultString(String value) {
        return new JAXBElement<String>(_PropertyDefaultString_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExternalAliases")
    public JAXBElement<String> createExternalAliases(String value) {
        return new JAXBElement<String>(_ExternalAliases_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RequiresUniqueElements")
    public JAXBElement<String> createRequiresUniqueElements(String value) {
        return new JAXBElement<String>(_RequiresUniqueElements_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ObjectStateRecordingLevel")
    public JAXBElement<Byte> createObjectStateRecordingLevel(Byte value) {
        return new JAXBElement<Byte>(_ObjectStateRecordingLevel_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClassId")
    public JAXBElement<String> createClassId(String value) {
        return new JAXBElement<String>(_ClassId_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DescriptiveText")
    public JAXBElement<String> createDescriptiveText(String value) {
        return new JAXBElement<String>(_DescriptiveText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Creator")
    public JAXBElement<String> createCreator(String value) {
        return new JAXBElement<String>(_Creator_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyDefaultBinary")
    public JAXBElement<String> createPropertyDefaultBinary(String value) {
        return new JAXBElement<String>(_PropertyDefaultBinary_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "PropertyMaximumDateTime")
    public JAXBElement<String> createPropertyMaximumDateTime(String value) {
        return new JAXBElement<String>(_PropertyMaximumDateTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Settability")
    public JAXBElement<Byte> createSettability(Byte value) {
        return new JAXBElement<Byte>(_Settability_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DisplayName")
    public JAXBElement<String> createDisplayName(String value) {
        return new JAXBElement<String>(_DisplayName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AuditFailure")
    public JAXBElement<Byte> createAuditFailure(Byte value) {
        return new JAXBElement<Byte>(_AuditFailure_QNAME, Byte.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ChoiceStringValue")
    public JAXBElement<String> createChoiceStringValue(String value) {
        return new JAXBElement<String>(_ChoiceStringValue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "IsCBREnabled")
    public JAXBElement<String> createIsCBREnabled(String value) {
        return new JAXBElement<String>(_IsCBREnabled_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ObjectType")
    public JAXBElement<Short> createObjectType(Short value) {
        return new JAXBElement<Short>(_ObjectType_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "RequiredClassId")
    public JAXBElement<String> createRequiredClassId(String value) {
        return new JAXBElement<String>(_RequiredClassId_QNAME, String.class, null, value);
    }

}
