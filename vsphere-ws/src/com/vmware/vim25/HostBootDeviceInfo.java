
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostBootDeviceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostBootDeviceInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="bootDevices" type="{urn:vim25}HostBootDevice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="currentBootDeviceKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostBootDeviceInfo", propOrder = {
    "bootDevices",
    "currentBootDeviceKey"
})
public class HostBootDeviceInfo
    extends DynamicData
{

    protected List<HostBootDevice> bootDevices;
    protected String currentBootDeviceKey;

    /**
     * Gets the value of the bootDevices property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bootDevices property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBootDevices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostBootDevice }
     * 
     * 
     */
    public List<HostBootDevice> getBootDevices() {
        if (bootDevices == null) {
            bootDevices = new ArrayList<HostBootDevice>();
        }
        return this.bootDevices;
    }

    /**
     * Gets the value of the currentBootDeviceKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentBootDeviceKey() {
        return currentBootDeviceKey;
    }

    /**
     * Sets the value of the currentBootDeviceKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentBootDeviceKey(String value) {
        this.currentBootDeviceKey = value;
    }

}
