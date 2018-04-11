
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostNumaNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostNumaNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostNumaNode" type="{urn:vim25}HostNumaNode" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostNumaNode", propOrder = {
    "hostNumaNode"
})
public class ArrayOfHostNumaNode {

    @XmlElement(name = "HostNumaNode")
    protected List<HostNumaNode> hostNumaNode;

    /**
     * Gets the value of the hostNumaNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostNumaNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostNumaNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostNumaNode }
     * 
     * 
     */
    public List<HostNumaNode> getHostNumaNode() {
        if (hostNumaNode == null) {
            hostNumaNode = new ArrayList<HostNumaNode>();
        }
        return this.hostNumaNode;
    }

}
