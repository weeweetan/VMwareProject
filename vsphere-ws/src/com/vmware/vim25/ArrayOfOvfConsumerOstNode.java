
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfOvfConsumerOstNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfOvfConsumerOstNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OvfConsumerOstNode" type="{urn:vim25}OvfConsumerOstNode" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfOvfConsumerOstNode", propOrder = {
    "ovfConsumerOstNode"
})
public class ArrayOfOvfConsumerOstNode {

    @XmlElement(name = "OvfConsumerOstNode")
    protected List<OvfConsumerOstNode> ovfConsumerOstNode;

    /**
     * Gets the value of the ovfConsumerOstNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ovfConsumerOstNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOvfConsumerOstNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OvfConsumerOstNode }
     * 
     * 
     */
    public List<OvfConsumerOstNode> getOvfConsumerOstNode() {
        if (ovfConsumerOstNode == null) {
            ovfConsumerOstNode = new ArrayList<OvfConsumerOstNode>();
        }
        return this.ovfConsumerOstNode;
    }

}
