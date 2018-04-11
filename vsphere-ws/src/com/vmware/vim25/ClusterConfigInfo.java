
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="dasConfig" type="{urn:vim25}ClusterDasConfigInfo"/>
 *         &lt;element name="dasVmConfig" type="{urn:vim25}ClusterDasVmConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="drsConfig" type="{urn:vim25}ClusterDrsConfigInfo"/>
 *         &lt;element name="drsVmConfig" type="{urn:vim25}ClusterDrsVmConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rule" type="{urn:vim25}ClusterRuleInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterConfigInfo", propOrder = {
    "dasConfig",
    "dasVmConfig",
    "drsConfig",
    "drsVmConfig",
    "rule"
})
public class ClusterConfigInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected ClusterDasConfigInfo dasConfig;
    protected List<ClusterDasVmConfigInfo> dasVmConfig;
    @XmlElement(required = true)
    protected ClusterDrsConfigInfo drsConfig;
    protected List<ClusterDrsVmConfigInfo> drsVmConfig;
    protected List<ClusterRuleInfo> rule;

    /**
     * Gets the value of the dasConfig property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDasConfigInfo }
     *     
     */
    public ClusterDasConfigInfo getDasConfig() {
        return dasConfig;
    }

    /**
     * Sets the value of the dasConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDasConfigInfo }
     *     
     */
    public void setDasConfig(ClusterDasConfigInfo value) {
        this.dasConfig = value;
    }

    /**
     * Gets the value of the dasVmConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dasVmConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDasVmConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDasVmConfigInfo }
     * 
     * 
     */
    public List<ClusterDasVmConfigInfo> getDasVmConfig() {
        if (dasVmConfig == null) {
            dasVmConfig = new ArrayList<ClusterDasVmConfigInfo>();
        }
        return this.dasVmConfig;
    }

    /**
     * Gets the value of the drsConfig property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDrsConfigInfo }
     *     
     */
    public ClusterDrsConfigInfo getDrsConfig() {
        return drsConfig;
    }

    /**
     * Sets the value of the drsConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDrsConfigInfo }
     *     
     */
    public void setDrsConfig(ClusterDrsConfigInfo value) {
        this.drsConfig = value;
    }

    /**
     * Gets the value of the drsVmConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drsVmConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrsVmConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDrsVmConfigInfo }
     * 
     * 
     */
    public List<ClusterDrsVmConfigInfo> getDrsVmConfig() {
        if (drsVmConfig == null) {
            drsVmConfig = new ArrayList<ClusterDrsVmConfigInfo>();
        }
        return this.drsVmConfig;
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
     * {@link ClusterRuleInfo }
     * 
     * 
     */
    public List<ClusterRuleInfo> getRule() {
        if (rule == null) {
            rule = new ArrayList<ClusterRuleInfo>();
        }
        return this.rule;
    }

}
