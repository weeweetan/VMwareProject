
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="category" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="eventInfo" type="{urn:vim25}EventDescriptionEventDetail" maxOccurs="unbounded"/>
 *         &lt;element name="enumeratedTypes" type="{urn:vim25}EnumDescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventDescription", propOrder = {
    "category",
    "eventInfo",
    "enumeratedTypes"
})
public class EventDescription
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<ElementDescription> category;
    @XmlElement(required = true)
    protected List<EventDescriptionEventDetail> eventInfo;
    protected List<EnumDescription> enumeratedTypes;

    /**
     * Gets the value of the category property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the category property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getCategory() {
        if (category == null) {
            category = new ArrayList<ElementDescription>();
        }
        return this.category;
    }

    /**
     * Gets the value of the eventInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventDescriptionEventDetail }
     * 
     * 
     */
    public List<EventDescriptionEventDetail> getEventInfo() {
        if (eventInfo == null) {
            eventInfo = new ArrayList<EventDescriptionEventDetail>();
        }
        return this.eventInfo;
    }

    /**
     * Gets the value of the enumeratedTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumeratedTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumeratedTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnumDescription }
     * 
     * 
     */
    public List<EnumDescription> getEnumeratedTypes() {
        if (enumeratedTypes == null) {
            enumeratedTypes = new ArrayList<EnumDescription>();
        }
        return this.enumeratedTypes;
    }

}
