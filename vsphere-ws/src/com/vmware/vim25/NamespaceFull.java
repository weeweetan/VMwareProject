
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NamespaceFull complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NamespaceFull">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentMaxSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="requiredSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NamespaceFull", propOrder = {
    "name",
    "currentMaxSize",
    "requiredSize"
})
public class NamespaceFull
    extends VimFault
{

    @XmlElement(required = true)
    protected String name;
    protected long currentMaxSize;
    protected Long requiredSize;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the currentMaxSize property.
     * 
     */
    public long getCurrentMaxSize() {
        return currentMaxSize;
    }

    /**
     * Sets the value of the currentMaxSize property.
     * 
     */
    public void setCurrentMaxSize(long value) {
        this.currentMaxSize = value;
    }

    /**
     * Gets the value of the requiredSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRequiredSize() {
        return requiredSize;
    }

    /**
     * Sets the value of the requiredSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRequiredSize(Long value) {
        this.requiredSize = value;
    }

}
