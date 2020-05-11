
package com.example.genericaccessormodule.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenericAccessorModuleResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GenericAccessorModuleResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="queryStatus" type="{http://genericaccessormodule.example.com/Common}QueryStatusType"/>
 *         &lt;element name="record" type="{http://genericaccessormodule.example.com/Common}RecordType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericAccessorModuleResponseType", propOrder = {
    "queryStatus",
    "record"
})
public class GenericAccessorModuleResponseType {

    @XmlElement(required = true)
    protected QueryStatusType queryStatus;
    protected List<RecordType> record;

    /**
     * Gets the value of the queryStatus property.
     * 
     * @return
     *     possible object is
     *     {@link QueryStatusType }
     *     
     */
    public QueryStatusType getQueryStatus() {
        return queryStatus;
    }

    /**
     * Sets the value of the queryStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryStatusType }
     *     
     */
    public void setQueryStatus(QueryStatusType value) {
        this.queryStatus = value;
    }

    /**
     * Gets the value of the record property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the record property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordType }
     * 
     * 
     */
    public List<RecordType> getRecord() {
        if (record == null) {
            record = new ArrayList<RecordType>();
        }
        return this.record;
    }

}
