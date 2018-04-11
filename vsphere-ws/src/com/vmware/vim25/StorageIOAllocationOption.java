
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageIOAllocationOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageIOAllocationOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="limitOption" type="{urn:vim25}LongOption"/>
 *         &lt;element name="sharesOption" type="{urn:vim25}SharesOption"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageIOAllocationOption", propOrder = {
    "limitOption",
    "sharesOption"
})
public class StorageIOAllocationOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected LongOption limitOption;
    @XmlElement(required = true)
    protected SharesOption sharesOption;

    /**
     * Gets the value of the limitOption property.
     * 
     * @return
     *     possible object is
     *     {@link LongOption }
     *     
     */
    public LongOption getLimitOption() {
        return limitOption;
    }

    /**
     * Sets the value of the limitOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link LongOption }
     *     
     */
    public void setLimitOption(LongOption value) {
        this.limitOption = value;
    }

    /**
     * Gets the value of the sharesOption property.
     * 
     * @return
     *     possible object is
     *     {@link SharesOption }
     *     
     */
    public SharesOption getSharesOption() {
        return sharesOption;
    }

    /**
     * Sets the value of the sharesOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link SharesOption }
     *     
     */
    public void setSharesOption(SharesOption value) {
        this.sharesOption = value;
    }

}
