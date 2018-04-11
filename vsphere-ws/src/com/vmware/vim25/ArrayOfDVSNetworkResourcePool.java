
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDVSNetworkResourcePool complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDVSNetworkResourcePool">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DVSNetworkResourcePool" type="{urn:vim25}DVSNetworkResourcePool" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDVSNetworkResourcePool", propOrder = {
    "dvsNetworkResourcePool"
})
public class ArrayOfDVSNetworkResourcePool {

    @XmlElement(name = "DVSNetworkResourcePool")
    protected List<DVSNetworkResourcePool> dvsNetworkResourcePool;

    /**
     * Gets the value of the dvsNetworkResourcePool property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvsNetworkResourcePool property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDVSNetworkResourcePool().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVSNetworkResourcePool }
     * 
     * 
     */
    public List<DVSNetworkResourcePool> getDVSNetworkResourcePool() {
        if (dvsNetworkResourcePool == null) {
            dvsNetworkResourcePool = new ArrayList<DVSNetworkResourcePool>();
        }
        return this.dvsNetworkResourcePool;
    }

}
