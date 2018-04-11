
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfHostSystemSwapConfigurationSystemSwapOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfHostSystemSwapConfigurationSystemSwapOption">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HostSystemSwapConfigurationSystemSwapOption" type="{urn:vim25}HostSystemSwapConfigurationSystemSwapOption" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfHostSystemSwapConfigurationSystemSwapOption", propOrder = {
    "hostSystemSwapConfigurationSystemSwapOption"
})
public class ArrayOfHostSystemSwapConfigurationSystemSwapOption {

    @XmlElement(name = "HostSystemSwapConfigurationSystemSwapOption")
    protected List<HostSystemSwapConfigurationSystemSwapOption> hostSystemSwapConfigurationSystemSwapOption;

    /**
     * Gets the value of the hostSystemSwapConfigurationSystemSwapOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostSystemSwapConfigurationSystemSwapOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostSystemSwapConfigurationSystemSwapOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostSystemSwapConfigurationSystemSwapOption }
     * 
     * 
     */
    public List<HostSystemSwapConfigurationSystemSwapOption> getHostSystemSwapConfigurationSystemSwapOption() {
        if (hostSystemSwapConfigurationSystemSwapOption == null) {
            hostSystemSwapConfigurationSystemSwapOption = new ArrayList<HostSystemSwapConfigurationSystemSwapOption>();
        }
        return this.hostSystemSwapConfigurationSystemSwapOption;
    }

}
