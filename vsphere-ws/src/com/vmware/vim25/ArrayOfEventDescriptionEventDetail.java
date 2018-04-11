
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEventDescriptionEventDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEventDescriptionEventDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EventDescriptionEventDetail" type="{urn:vim25}EventDescriptionEventDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEventDescriptionEventDetail", propOrder = {
    "eventDescriptionEventDetail"
})
public class ArrayOfEventDescriptionEventDetail {

    @XmlElement(name = "EventDescriptionEventDetail")
    protected List<EventDescriptionEventDetail> eventDescriptionEventDetail;

    /**
     * Gets the value of the eventDescriptionEventDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventDescriptionEventDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventDescriptionEventDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventDescriptionEventDetail }
     * 
     * 
     */
    public List<EventDescriptionEventDetail> getEventDescriptionEventDetail() {
        if (eventDescriptionEventDetail == null) {
            eventDescriptionEventDetail = new ArrayList<EventDescriptionEventDetail>();
        }
        return this.eventDescriptionEventDetail;
    }

}
