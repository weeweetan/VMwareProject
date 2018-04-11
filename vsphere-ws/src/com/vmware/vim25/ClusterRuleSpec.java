
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterRuleSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterRuleSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ArrayUpdateSpec">
 *       &lt;sequence>
 *         &lt;element name="info" type="{urn:vim25}ClusterRuleInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterRuleSpec", propOrder = {
    "info"
})
public class ClusterRuleSpec
    extends ArrayUpdateSpec
{

    protected ClusterRuleInfo info;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterRuleInfo }
     *     
     */
    public ClusterRuleInfo getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterRuleInfo }
     *     
     */
    public void setInfo(ClusterRuleInfo value) {
        this.info = value;
    }

}
