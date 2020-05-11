
package org.example.genericaccessormodule.genericinterface;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.example.genericaccessormodule.common.GenericAccessorModuleRequestType;
import com.example.genericaccessormodule.common.GenericAccessorModuleResponseType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.genericaccessormodule.genericinterface package. 
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

    private final static QName _RetrieveInformation_QNAME = new QName("http://genericaccessormodule.example.org/GenericInterface/", "RetrieveInformation");
    private final static QName _RetrieveInformationResponse_QNAME = new QName("http://genericaccessormodule.example.org/GenericInterface/", "RetrieveInformationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.genericaccessormodule.genericinterface
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericAccessorModuleRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://genericaccessormodule.example.org/GenericInterface/", name = "RetrieveInformation")
    public JAXBElement<GenericAccessorModuleRequestType> createRetrieveInformation(GenericAccessorModuleRequestType value) {
        return new JAXBElement<GenericAccessorModuleRequestType>(_RetrieveInformation_QNAME, GenericAccessorModuleRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericAccessorModuleResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://genericaccessormodule.example.org/GenericInterface/", name = "RetrieveInformationResponse")
    public JAXBElement<GenericAccessorModuleResponseType> createRetrieveInformationResponse(GenericAccessorModuleResponseType value) {
        return new JAXBElement<GenericAccessorModuleResponseType>(_RetrieveInformationResponse_QNAME, GenericAccessorModuleResponseType.class, null, value);
    }

}
