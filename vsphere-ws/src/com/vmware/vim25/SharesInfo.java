
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SharesInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SharesInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="shares" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="level" type="{urn:vim25}SharesLevel"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SharesInfo", propOrder = {
    "shares",
    "level"
})
public class SharesInfo
    extends DynamicData
{

    protected int shares;
    @XmlElement(required = true)
    protected SharesLevel level;

    /**
     * Gets the value of the shares property.
     * 
     */
    public int getShares() {
        return shares;
    }

    /**
     * Sets the value of the shares property.
     * 
     */
    public void setShares(int value) {
        this.shares = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link SharesLevel }
     *     
     */
    public SharesLevel getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link SharesLevel }
     *     
     */
    public void setLevel(SharesLevel value) {
        this.level = value;
    }

}
