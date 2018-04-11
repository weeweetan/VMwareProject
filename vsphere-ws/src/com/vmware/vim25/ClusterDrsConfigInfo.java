
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDrsConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterDrsConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enableVmBehaviorOverrides" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="defaultVmBehavior" type="{urn:vim25}DrsBehavior" minOccurs="0"/>
 *         &lt;element name="vmotionRate" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="option" type="{urn:vim25}OptionValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterDrsConfigInfo", propOrder = {
    "enabled",
    "enableVmBehaviorOverrides",
    "defaultVmBehavior",
    "vmotionRate",
    "option"
})
public class ClusterDrsConfigInfo
    extends DynamicData
{

    protected Boolean enabled;
    protected Boolean enableVmBehaviorOverrides;
    protected DrsBehavior defaultVmBehavior;
    protected Integer vmotionRate;
    protected List<OptionValue> option;

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the enableVmBehaviorOverrides property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableVmBehaviorOverrides() {
        return enableVmBehaviorOverrides;
    }

    /**
     * Sets the value of the enableVmBehaviorOverrides property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableVmBehaviorOverrides(Boolean value) {
        this.enableVmBehaviorOverrides = value;
    }

    /**
     * Gets the value of the defaultVmBehavior property.
     * 
     * @return
     *     possible object is
     *     {@link DrsBehavior }
     *     
     */
    public DrsBehavior getDefaultVmBehavior() {
        return defaultVmBehavior;
    }

    /**
     * Sets the value of the defaultVmBehavior property.
     * 
     * @param value
     *     allowed object is
     *     {@link DrsBehavior }
     *     
     */
    public void setDefaultVmBehavior(DrsBehavior value) {
        this.defaultVmBehavior = value;
    }

    /**
     * Gets the value of the vmotionRate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVmotionRate() {
        return vmotionRate;
    }

    /**
     * Sets the value of the vmotionRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVmotionRate(Integer value) {
        this.vmotionRate = value;
    }

    /**
     * Gets the value of the option property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the option property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionValue }
     * 
     * 
     */
    public List<OptionValue> getOption() {
        if (option == null) {
            option = new ArrayList<OptionValue>();
        }
        return this.option;
    }

}
