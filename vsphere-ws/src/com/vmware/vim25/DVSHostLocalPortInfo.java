
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSHostLocalPortInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSHostLocalPortInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="switchUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="setting" type="{urn:vim25}DVPortSetting"/>
 *         &lt;element name="vnic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSHostLocalPortInfo", propOrder = {
    "switchUuid",
    "portKey",
    "setting",
    "vnic"
})
public class DVSHostLocalPortInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String switchUuid;
    @XmlElement(required = true)
    protected String portKey;
    @XmlElement(required = true)
    protected DVPortSetting setting;
    @XmlElement(required = true)
    protected String vnic;

    /**
     * Gets the value of the switchUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchUuid() {
        return switchUuid;
    }

    /**
     * Sets the value of the switchUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchUuid(String value) {
        this.switchUuid = value;
    }

    /**
     * Gets the value of the portKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortKey() {
        return portKey;
    }

    /**
     * Sets the value of the portKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortKey(String value) {
        this.portKey = value;
    }

    /**
     * Gets the value of the setting property.
     * 
     * @return
     *     possible object is
     *     {@link DVPortSetting }
     *     
     */
    public DVPortSetting getSetting() {
        return setting;
    }

    /**
     * Sets the value of the setting property.
     * 
     * @param value
     *     allowed object is
     *     {@link DVPortSetting }
     *     
     */
    public void setSetting(DVPortSetting value) {
        this.setting = value;
    }

    /**
     * Gets the value of the vnic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVnic() {
        return vnic;
    }

    /**
     * Sets the value of the vnic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVnic(String value) {
        this.vnic = value;
    }

}
