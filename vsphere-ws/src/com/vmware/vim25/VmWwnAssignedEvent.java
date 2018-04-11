
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmWwnAssignedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmWwnAssignedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="nodeWwns" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *         &lt;element name="portWwns" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmWwnAssignedEvent", propOrder = {
    "nodeWwns",
    "portWwns"
})
public class VmWwnAssignedEvent
    extends VmEvent
{

    @XmlElement(type = Long.class)
    protected List<Long> nodeWwns;
    @XmlElement(type = Long.class)
    protected List<Long> portWwns;

    /**
     * Gets the value of the nodeWwns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nodeWwns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNodeWwns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getNodeWwns() {
        if (nodeWwns == null) {
            nodeWwns = new ArrayList<Long>();
        }
        return this.nodeWwns;
    }

    /**
     * Gets the value of the portWwns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portWwns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortWwns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getPortWwns() {
        if (portWwns == null) {
            portWwns = new ArrayList<Long>();
        }
        return this.portWwns;
    }

}
