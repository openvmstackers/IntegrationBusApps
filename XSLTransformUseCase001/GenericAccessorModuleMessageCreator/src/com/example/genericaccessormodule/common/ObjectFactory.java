
package com.example.genericaccessormodule.common;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.genericaccessormodule.common package. 
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

    private final static QName _StatusEnumeration_QNAME = new QName("http://genericaccessormodule.example.com/Common", "StatusEnumeration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.genericaccessormodule.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenericAccessorModuleRequestType }
     * 
     */
    public GenericAccessorModuleRequestType createGenericAccessorModuleRequestType() {
        return new GenericAccessorModuleRequestType();
    }

    /**
     * Create an instance of {@link GenericAccessorModuleResponseType }
     * 
     */
    public GenericAccessorModuleResponseType createGenericAccessorModuleResponseType() {
        return new GenericAccessorModuleResponseType();
    }

    /**
     * Create an instance of {@link ColumnType }
     * 
     */
    public ColumnType createColumnType() {
        return new ColumnType();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link RecordType }
     * 
     */
    public RecordType createRecordType() {
        return new RecordType();
    }

    /**
     * Create an instance of {@link QueryStatusType }
     * 
     */
    public QueryStatusType createQueryStatusType() {
        return new QueryStatusType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://genericaccessormodule.example.com/Common", name = "StatusEnumeration")
    public JAXBElement<String> createStatusEnumeration(String value) {
        return new JAXBElement<String>(_StatusEnumeration_QNAME, String.class, null, value);
    }

}
