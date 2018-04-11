
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterVmHostRuleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterVmHostRuleInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterRuleInfo">
 *       &lt;sequence>
 *         &lt;element name="vmGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="affineHostGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="antiAffineHostGroupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterVmHostRuleInfo", propOrder = {
    "vmGroupName",
    "affineHostGroupName",
    "antiAffineHostGroupName"
})
public class ClusterVmHostRuleInfo
    extends ClusterRuleInfo
{

    protected String vmGroupName;
    protected String affineHostGroupName;
    protected String antiAffineHostGroupName;

    /**
     * Gets the value of the vmGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmGroupName() {
        return vmGroupName;
    }

    /**
     * Sets the value of the vmGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmGroupName(String value) {
        this.vmGroupName = value;
    }

    /**
     * Gets the value of the affineHostGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffineHostGroupName() {
        return affineHostGroupName;
    }

    /**
     * Sets the value of the affineHostGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffineHostGroupName(String value) {
        this.affineHostGroupName = value;
    }

    /**
     * Gets the value of the antiAffineHostGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntiAffineHostGroupName() {
        return antiAffineHostGroupName;
    }

    /**
     * Sets the value of the antiAffineHostGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntiAffineHostGroupName(String value) {
        this.antiAffineHostGroupName = value;
    }

}
