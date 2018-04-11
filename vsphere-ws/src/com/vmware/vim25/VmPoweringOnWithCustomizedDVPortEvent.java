
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmPoweringOnWithCustomizedDVPortEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmPoweringOnWithCustomizedDVPortEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VmEvent">
 *       &lt;sequence>
 *         &lt;element name="vnic" type="{urn:vim25}VnicPortArgument" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmPoweringOnWithCustomizedDVPortEvent", propOrder = {
    "vnic"
})
public class VmPoweringOnWithCustomizedDVPortEvent
    extends VmEvent
{

    @XmlElement(required = true)
    protected List<VnicPortArgument> vnic;

    /**
     * Gets the value of the vnic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vnic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVnic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VnicPortArgument }
     * 
     * 
     */
    public List<VnicPortArgument> getVnic() {
        if (vnic == null) {
            vnic = new ArrayList<VnicPortArgument>();
        }
        return this.vnic;
    }

}
