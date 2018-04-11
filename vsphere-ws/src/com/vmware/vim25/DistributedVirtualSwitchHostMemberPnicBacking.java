
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchHostMemberPnicBacking complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualSwitchHostMemberPnicBacking">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DistributedVirtualSwitchHostMemberBacking">
 *       &lt;sequence>
 *         &lt;element name="pnicSpec" type="{urn:vim25}DistributedVirtualSwitchHostMemberPnicSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualSwitchHostMemberPnicBacking", propOrder = {
    "pnicSpec"
})
public class DistributedVirtualSwitchHostMemberPnicBacking
    extends DistributedVirtualSwitchHostMemberBacking
{

    protected List<DistributedVirtualSwitchHostMemberPnicSpec> pnicSpec;

    /**
     * Gets the value of the pnicSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pnicSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPnicSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DistributedVirtualSwitchHostMemberPnicSpec }
     * 
     * 
     */
    public List<DistributedVirtualSwitchHostMemberPnicSpec> getPnicSpec() {
        if (pnicSpec == null) {
            pnicSpec = new ArrayList<DistributedVirtualSwitchHostMemberPnicSpec>();
        }
        return this.pnicSpec;
    }

}
