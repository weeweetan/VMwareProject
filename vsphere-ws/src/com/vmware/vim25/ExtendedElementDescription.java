
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtendedElementDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtendedElementDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ElementDescription">
 *       &lt;sequence>
 *         &lt;element name="messageCatalogKeyPrefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageArg" type="{urn:vim25}KeyAnyValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtendedElementDescription", propOrder = {
    "messageCatalogKeyPrefix",
    "messageArg"
})
public class ExtendedElementDescription
    extends ElementDescription
{

    @XmlElement(required = true)
    protected String messageCatalogKeyPrefix;
    protected List<KeyAnyValue> messageArg;

    /**
     * Gets the value of the messageCatalogKeyPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageCatalogKeyPrefix() {
        return messageCatalogKeyPrefix;
    }

    /**
     * Sets the value of the messageCatalogKeyPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageCatalogKeyPrefix(String value) {
        this.messageCatalogKeyPrefix = value;
    }

    /**
     * Gets the value of the messageArg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageArg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageArg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyAnyValue }
     * 
     * 
     */
    public List<KeyAnyValue> getMessageArg() {
        if (messageArg == null) {
            messageArg = new ArrayList<KeyAnyValue>();
        }
        return this.messageArg;
    }

}
