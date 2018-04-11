
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InventoryHasStandardAloneHosts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InventoryHasStandardAloneHosts">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}NotEnoughLicenses">
 *       &lt;sequence>
 *         &lt;element name="hosts" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryHasStandardAloneHosts", propOrder = {
    "hosts"
})
public class InventoryHasStandardAloneHosts
    extends NotEnoughLicenses
{

    @XmlElement(required = true)
    protected List<String> hosts;

    /**
     * Gets the value of the hosts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hosts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHosts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getHosts() {
        if (hosts == null) {
            hosts = new ArrayList<String>();
        }
        return this.hosts;
    }

}
