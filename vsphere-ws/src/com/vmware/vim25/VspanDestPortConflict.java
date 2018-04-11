
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VspanDestPortConflict complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VspanDestPortConflict">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsFault">
 *       &lt;sequence>
 *         &lt;element name="vspanSessionKey1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vspanSessionKey2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VspanDestPortConflict", propOrder = {
    "vspanSessionKey1",
    "vspanSessionKey2",
    "portKey"
})
public class VspanDestPortConflict
    extends DvsFault
{

    @XmlElement(required = true)
    protected String vspanSessionKey1;
    @XmlElement(required = true)
    protected String vspanSessionKey2;
    @XmlElement(required = true)
    protected String portKey;

    /**
     * Gets the value of the vspanSessionKey1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVspanSessionKey1() {
        return vspanSessionKey1;
    }

    /**
     * Sets the value of the vspanSessionKey1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVspanSessionKey1(String value) {
        this.vspanSessionKey1 = value;
    }

    /**
     * Gets the value of the vspanSessionKey2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVspanSessionKey2() {
        return vspanSessionKey2;
    }

    /**
     * Sets the value of the vspanSessionKey2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVspanSessionKey2(String value) {
        this.vspanSessionKey2 = value;
    }

    /**
     * Gets the value of the portKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortKey() {
        return portKey;
    }

    /**
     * Sets the value of the portKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortKey(String value) {
        this.portKey = value;
    }

}
