
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsPodConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsPodConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ioLoadBalanceEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="defaultVmBehavior" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loadBalanceInterval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="defaultIntraVmAffinity" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="spaceLoadBalanceConfig" type="{urn:vim25}StorageDrsSpaceLoadBalanceConfig" minOccurs="0"/>
 *         &lt;element name="ioLoadBalanceConfig" type="{urn:vim25}StorageDrsIoLoadBalanceConfig" minOccurs="0"/>
 *         &lt;element name="rule" type="{urn:vim25}ClusterRuleSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="option" type="{urn:vim25}StorageDrsOptionSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsPodConfigSpec", propOrder = {
    "enabled",
    "ioLoadBalanceEnabled",
    "defaultVmBehavior",
    "loadBalanceInterval",
    "defaultIntraVmAffinity",
    "spaceLoadBalanceConfig",
    "ioLoadBalanceConfig",
    "rule",
    "option"
})
public class StorageDrsPodConfigSpec
    extends DynamicData
{

    protected Boolean enabled;
    protected Boolean ioLoadBalanceEnabled;
    protected String defaultVmBehavior;
    protected Integer loadBalanceInterval;
    protected Boolean defaultIntraVmAffinity;
    protected StorageDrsSpaceLoadBalanceConfig spaceLoadBalanceConfig;
    protected StorageDrsIoLoadBalanceConfig ioLoadBalanceConfig;
    protected List<ClusterRuleSpec> rule;
    protected List<StorageDrsOptionSpec> option;

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
     * Gets the value of the ioLoadBalanceEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIoLoadBalanceEnabled() {
        return ioLoadBalanceEnabled;
    }

    /**
     * Sets the value of the ioLoadBalanceEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIoLoadBalanceEnabled(Boolean value) {
        this.ioLoadBalanceEnabled = value;
    }

    /**
     * Gets the value of the defaultVmBehavior property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultVmBehavior() {
        return defaultVmBehavior;
    }

    /**
     * Sets the value of the defaultVmBehavior property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultVmBehavior(String value) {
        this.defaultVmBehavior = value;
    }

    /**
     * Gets the value of the loadBalanceInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLoadBalanceInterval() {
        return loadBalanceInterval;
    }

    /**
     * Sets the value of the loadBalanceInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLoadBalanceInterval(Integer value) {
        this.loadBalanceInterval = value;
    }

    /**
     * Gets the value of the defaultIntraVmAffinity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDefaultIntraVmAffinity() {
        return defaultIntraVmAffinity;
    }

    /**
     * Sets the value of the defaultIntraVmAffinity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefaultIntraVmAffinity(Boolean value) {
        this.defaultIntraVmAffinity = value;
    }

    /**
     * Gets the value of the spaceLoadBalanceConfig property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDrsSpaceLoadBalanceConfig }
     *     
     */
    public StorageDrsSpaceLoadBalanceConfig getSpaceLoadBalanceConfig() {
        return spaceLoadBalanceConfig;
    }

    /**
     * Sets the value of the spaceLoadBalanceConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDrsSpaceLoadBalanceConfig }
     *     
     */
    public void setSpaceLoadBalanceConfig(StorageDrsSpaceLoadBalanceConfig value) {
        this.spaceLoadBalanceConfig = value;
    }

    /**
     * Gets the value of the ioLoadBalanceConfig property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDrsIoLoadBalanceConfig }
     *     
     */
    public StorageDrsIoLoadBalanceConfig getIoLoadBalanceConfig() {
        return ioLoadBalanceConfig;
    }

    /**
     * Sets the value of the ioLoadBalanceConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDrsIoLoadBalanceConfig }
     *     
     */
    public void setIoLoadBalanceConfig(StorageDrsIoLoadBalanceConfig value) {
        this.ioLoadBalanceConfig = value;
    }

    /**
     * Gets the value of the rule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterRuleSpec }
     * 
     * 
     */
    public List<ClusterRuleSpec> getRule() {
        if (rule == null) {
            rule = new ArrayList<ClusterRuleSpec>();
        }
        return this.rule;
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
     * {@link StorageDrsOptionSpec }
     * 
     * 
     */
    public List<StorageDrsOptionSpec> getOption() {
        if (option == null) {
            option = new ArrayList<StorageDrsOptionSpec>();
        }
        return this.option;
    }

}
