
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEventAlarmExpressionComparison complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEventAlarmExpressionComparison">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EventAlarmExpressionComparison" type="{urn:vim25}EventAlarmExpressionComparison" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEventAlarmExpressionComparison", propOrder = {
    "eventAlarmExpressionComparison"
})
public class ArrayOfEventAlarmExpressionComparison {

    @XmlElement(name = "EventAlarmExpressionComparison")
    protected List<EventAlarmExpressionComparison> eventAlarmExpressionComparison;

    /**
     * Gets the value of the eventAlarmExpressionComparison property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventAlarmExpressionComparison property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventAlarmExpressionComparison().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventAlarmExpressionComparison }
     * 
     * 
     */
    public List<EventAlarmExpressionComparison> getEventAlarmExpressionComparison() {
        if (eventAlarmExpressionComparison == null) {
            eventAlarmExpressionComparison = new ArrayList<EventAlarmExpressionComparison>();
        }
        return this.eventAlarmExpressionComparison;
    }

}
