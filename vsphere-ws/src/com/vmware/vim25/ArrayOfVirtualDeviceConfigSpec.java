
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVirtualDeviceConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVirtualDeviceConfigSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VirtualDeviceConfigSpec" type="{urn:vim25}VirtualDeviceConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVirtualDeviceConfigSpec", propOrder = {
    "virtualDeviceConfigSpec"
})
public class ArrayOfVirtualDeviceConfigSpec {

    @XmlElement(name = "VirtualDeviceConfigSpec")
    protected List<VirtualDeviceConfigSpec> virtualDeviceConfigSpec;

    /**
     * Gets the value of the virtualDeviceConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualDeviceConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualDeviceConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualDeviceConfigSpec }
     * 
     * 
     */
    public List<VirtualDeviceConfigSpec> getVirtualDeviceConfigSpec() {
        if (virtualDeviceConfigSpec == null) {
            virtualDeviceConfigSpec = new ArrayList<VirtualDeviceConfigSpec>();
        }
        return this.virtualDeviceConfigSpec;
    }

}
