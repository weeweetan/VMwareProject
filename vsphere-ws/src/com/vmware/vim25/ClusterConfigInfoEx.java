
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterConfigInfoEx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterConfigInfoEx">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ComputeResourceConfigInfo">
 *       &lt;sequence>
 *         &lt;element name="dasConfig" type="{urn:vim25}ClusterDasConfigInfo"/>
 *         &lt;element name="dasVmConfig" type="{urn:vim25}ClusterDasVmConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="drsConfig" type="{urn:vim25}ClusterDrsConfigInfo"/>
 *         &lt;element name="drsVmConfig" type="{urn:vim25}ClusterDrsVmConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="rule" type="{urn:vim25}ClusterRuleInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dpmConfigInfo" type="{urn:vim25}ClusterDpmConfigInfo" minOccurs="0"/>
 *         &lt;element name="dpmHostConfig" type="{urn:vim25}ClusterDpmHostConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="group" type="{urn:vim25}ClusterGroupInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterConfigInfoEx", propOrder = {
    "dasConfig",
    "dasVmConfig",
    "drsConfig",
    "drsVmConfig",
    "rule",
    "dpmConfigInfo",
    "dpmHostConfig",
    "group"
})
public class ClusterConfigInfoEx
    extends ComputeResourceConfigInfo
{

    @XmlElement(required = true)
    protected ClusterDasConfigInfo dasConfig;
    protected List<ClusterDasVmConfigInfo> dasVmConfig;
    @XmlElement(required = true)
    protected ClusterDrsConfigInfo drsConfig;
    protected List<ClusterDrsVmConfigInfo> drsVmConfig;
    protected List<ClusterRuleInfo> rule;
    protected ClusterDpmConfigInfo dpmConfigInfo;
    protected List<ClusterDpmHostConfigInfo> dpmHostConfig;
    protected List<ClusterGroupInfo> group;

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

    /**
     * Gets the value of the dpmConfigInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDpmConfigInfo }
     *     
     */
    public ClusterDpmConfigInfo getDpmConfigInfo() {
        return dpmConfigInfo;
    }

    /**
     * Sets the value of the dpmConfigInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDpmConfigInfo }
     *     
     */
    public void setDpmConfigInfo(ClusterDpmConfigInfo value) {
        this.dpmConfigInfo = value;
    }

    /**
     * Gets the value of the dpmHostConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dpmHostConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDpmHostConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDpmHostConfigInfo }
     * 
     * 
     */
    public List<ClusterDpmHostConfigInfo> getDpmHostConfig() {
        if (dpmHostConfig == null) {
            dpmHostConfig = new ArrayList<ClusterDpmHostConfigInfo>();
        }
        return this.dpmHostConfig;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterGroupInfo }
     * 
     * 
     */
    public List<ClusterGroupInfo> getGroup() {
        if (group == null) {
            group = new ArrayList<ClusterGroupInfo>();
        }
        return this.group;
    }

}
