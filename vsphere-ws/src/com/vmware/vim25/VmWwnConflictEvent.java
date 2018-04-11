
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmWwnConflictEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmWwnConflictEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="conflictedVms" type="{urn:vim25}VmEventArgument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="conflictedHosts" type="{urn:vim25}HostEventArgument" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wwn" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmWwnConflictEvent", propOrder = {
    "conflictedVms",
    "conflictedHosts",
    "wwn"
})
public class VmWwnConflictEvent
    extends VmEvent
{

    protected List<VmEventArgument> conflictedVms;
    protected List<HostEventArgument> conflictedHosts;
    protected long wwn;

    /**
     * Gets the value of the conflictedVms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conflictedVms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConflictedVms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VmEventArgument }
     * 
     * 
     */
    public List<VmEventArgument> getConflictedVms() {
        if (conflictedVms == null) {
            conflictedVms = new ArrayList<VmEventArgument>();
        }
        return this.conflictedVms;
    }

    /**
     * Gets the value of the conflictedHosts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the conflictedHosts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConflictedHosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostEventArgument }
     * 
     * 
     */
    public List<HostEventArgument> getConflictedHosts() {
        if (conflictedHosts == null) {
            conflictedHosts = new ArrayList<HostEventArgument>();
        }
        return this.conflictedHosts;
    }

    /**
     * Gets the value of the wwn property.
     * 
     */
    public long getWwn() {
        return wwn;
    }

    /**
     * Sets the value of the wwn property.
     * 
     */
    public void setWwn(long value) {
        this.wwn = value;
    }

}
