
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareUplinkPortOrderPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareUplinkPortOrderPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InheritablePolicy">
 *       &lt;sequence>
 *         &lt;element name="activeUplinkPort" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="standbyUplinkPort" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareUplinkPortOrderPolicy", propOrder = {
    "activeUplinkPort",
    "standbyUplinkPort"
})
public class VMwareUplinkPortOrderPolicy
    extends InheritablePolicy
{

    protected List<String> activeUplinkPort;
    protected List<String> standbyUplinkPort;

    /**
     * Gets the value of the activeUplinkPort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeUplinkPort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveUplinkPort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActiveUplinkPort() {
        if (activeUplinkPort == null) {
            activeUplinkPort = new ArrayList<String>();
        }
        return this.activeUplinkPort;
    }

    /**
     * Gets the value of the standbyUplinkPort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standbyUplinkPort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandbyUplinkPort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getStandbyUplinkPort() {
        if (standbyUplinkPort == null) {
            standbyUplinkPort = new ArrayList<String>();
        }
        return this.standbyUplinkPort;
    }

}
