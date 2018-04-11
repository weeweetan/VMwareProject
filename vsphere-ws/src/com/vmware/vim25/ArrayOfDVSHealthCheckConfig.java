
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDVSHealthCheckConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDVSHealthCheckConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DVSHealthCheckConfig" type="{urn:vim25}DVSHealthCheckConfig" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDVSHealthCheckConfig", propOrder = {
    "dvsHealthCheckConfig"
})
public class ArrayOfDVSHealthCheckConfig {

    @XmlElement(name = "DVSHealthCheckConfig")
    protected List<DVSHealthCheckConfig> dvsHealthCheckConfig;

    /**
     * Gets the value of the dvsHealthCheckConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dvsHealthCheckConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDVSHealthCheckConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVSHealthCheckConfig }
     * 
     * 
     */
    public List<DVSHealthCheckConfig> getDVSHealthCheckConfig() {
        if (dvsHealthCheckConfig == null) {
            dvsHealthCheckConfig = new ArrayList<DVSHealthCheckConfig>();
        }
        return this.dvsHealthCheckConfig;
    }

}
