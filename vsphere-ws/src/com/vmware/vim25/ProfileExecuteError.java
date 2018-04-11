
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileExecuteError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileExecuteError">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="path" type="{urn:vim25}ProfilePropertyPath" minOccurs="0"/>
 *         &lt;element name="message" type="{urn:vim25}LocalizableMessage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileExecuteError", propOrder = {
    "path",
    "message"
})
public class ProfileExecuteError
    extends DynamicData
{

    protected ProfilePropertyPath path;
    @XmlElement(required = true)
    protected LocalizableMessage message;

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link ProfilePropertyPath }
     *     
     */
    public ProfilePropertyPath getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfilePropertyPath }
     *     
     */
    public void setPath(ProfilePropertyPath value) {
        this.path = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizableMessage }
     *     
     */
    public LocalizableMessage getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizableMessage }
     *     
     */
    public void setMessage(LocalizableMessage value) {
        this.message = value;
    }

}
