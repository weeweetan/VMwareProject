
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostVmciAccessManagerAccessSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostVmciAccessManagerAccessSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostVmciAccessManagerAccessSpec" type="{urn:vim25}HostVmciAccessManagerAccessSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostVmciAccessManagerAccessSpec", propOrder = {
    "hostVmciAccessManagerAccessSpec"
})
public class ArrayOfHostVmciAccessManagerAccessSpec {

    @XmlElement(name = "HostVmciAccessManagerAccessSpec")
    protected List<HostVmciAccessManagerAccessSpec> hostVmciAccessManagerAccessSpec;

    /**
     * Gets the value of the hostVmciAccessManagerAccessSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostVmciAccessManagerAccessSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostVmciAccessManagerAccessSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVmciAccessManagerAccessSpec }
     * 
     * 
     */
    public List<HostVmciAccessManagerAccessSpec> getHostVmciAccessManagerAccessSpec() {
        if (hostVmciAccessManagerAccessSpec == null) {
            hostVmciAccessManagerAccessSpec = new ArrayList<HostVmciAccessManagerAccessSpec>();
        }
        return this.hostVmciAccessManagerAccessSpec;
    }

}
