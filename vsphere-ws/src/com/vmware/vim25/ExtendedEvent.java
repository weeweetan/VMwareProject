
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtendedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}GeneralEvent">
 *       &lt;sequence>
 *         &lt;element name="eventTypeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="managedObject" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="data" type="{urn:vim25}ExtendedEventPair" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedEvent", propOrder = {
    "eventTypeId",
    "managedObject",
    "data"
})
public class ExtendedEvent
    extends GeneralEvent
{

    @XmlElement(required = true)
    protected String eventTypeId;
    @XmlElement(required = true)
    protected ManagedObjectReference managedObject;
    protected List<ExtendedEventPair> data;

    /**
     * Gets the value of the eventTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventTypeId() {
        return eventTypeId;
    }

    /**
     * Sets the value of the eventTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventTypeId(String value) {
        this.eventTypeId = value;
    }

    /**
     * Gets the value of the managedObject property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getManagedObject() {
        return managedObject;
    }

    /**
     * Sets the value of the managedObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setManagedObject(ManagedObjectReference value) {
        this.managedObject = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the data property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtendedEventPair }
     * 
     * 
     */
    public List<ExtendedEventPair> getData() {
        if (data == null) {
            data = new ArrayList<ExtendedEventPair>();
        }
        return this.data;
    }

}
