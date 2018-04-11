
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostPatchManagerStatusPrerequisitePatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostPatchManagerStatusPrerequisitePatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostPatchManagerStatusPrerequisitePatch" type="{urn:vim25}HostPatchManagerStatusPrerequisitePatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostPatchManagerStatusPrerequisitePatch", propOrder = {
    "hostPatchManagerStatusPrerequisitePatch"
})
public class ArrayOfHostPatchManagerStatusPrerequisitePatch {

    @XmlElement(name = "HostPatchManagerStatusPrerequisitePatch")
    protected List<HostPatchManagerStatusPrerequisitePatch> hostPatchManagerStatusPrerequisitePatch;

    /**
     * Gets the value of the hostPatchManagerStatusPrerequisitePatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostPatchManagerStatusPrerequisitePatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostPatchManagerStatusPrerequisitePatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPatchManagerStatusPrerequisitePatch }
     * 
     * 
     */
    public List<HostPatchManagerStatusPrerequisitePatch> getHostPatchManagerStatusPrerequisitePatch() {
        if (hostPatchManagerStatusPrerequisitePatch == null) {
            hostPatchManagerStatusPrerequisitePatch = new ArrayList<HostPatchManagerStatusPrerequisitePatch>();
        }
        return this.hostPatchManagerStatusPrerequisitePatch;
    }

}
