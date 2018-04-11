
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostAutoStartManagerConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostAutoStartManagerConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="defaults" type="{urn:vim25}AutoStartDefaults" minOccurs="0"/>
 *         &lt;element name="powerInfo" type="{urn:vim25}AutoStartPowerInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostAutoStartManagerConfig", propOrder = {
    "defaults",
    "powerInfo"
})
public class HostAutoStartManagerConfig
    extends DynamicData
{

    protected AutoStartDefaults defaults;
    protected List<AutoStartPowerInfo> powerInfo;

    /**
     * Gets the value of the defaults property.
     * 
     * @return
     *     possible object is
     *     {@link AutoStartDefaults }
     *     
     */
    public AutoStartDefaults getDefaults() {
        return defaults;
    }

    /**
     * Sets the value of the defaults property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoStartDefaults }
     *     
     */
    public void setDefaults(AutoStartDefaults value) {
        this.defaults = value;
    }

    /**
     * Gets the value of the powerInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the powerInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPowerInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AutoStartPowerInfo }
     * 
     * 
     */
    public List<AutoStartPowerInfo> getPowerInfo() {
        if (powerInfo == null) {
            powerInfo = new ArrayList<AutoStartPowerInfo>();
        }
        return this.powerInfo;
    }

}
