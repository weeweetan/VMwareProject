
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WaitOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WaitOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="maxWaitSeconds" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxObjectUpdates" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaitOptions", propOrder = {
    "maxWaitSeconds",
    "maxObjectUpdates"
})
public class WaitOptions
    extends DynamicData
{

    protected Integer maxWaitSeconds;
    protected Integer maxObjectUpdates;

    /**
     * Gets the value of the maxWaitSeconds property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxWaitSeconds() {
        return maxWaitSeconds;
    }

    /**
     * Sets the value of the maxWaitSeconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxWaitSeconds(Integer value) {
        this.maxWaitSeconds = value;
    }

    /**
     * Gets the value of the maxObjectUpdates property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxObjectUpdates() {
        return maxObjectUpdates;
    }

    /**
     * Sets the value of the maxObjectUpdates property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxObjectUpdates(Integer value) {
        this.maxObjectUpdates = value;
    }

}
