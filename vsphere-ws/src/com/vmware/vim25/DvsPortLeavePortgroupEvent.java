
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsPortLeavePortgroupEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsPortLeavePortgroupEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsEvent">
 *       &lt;sequence>
 *         &lt;element name="portKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portgroupKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portgroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsPortLeavePortgroupEvent", propOrder = {
    "portKey",
    "portgroupKey",
    "portgroupName"
})
public class DvsPortLeavePortgroupEvent
    extends DvsEvent
{

    @XmlElement(required = true)
    protected String portKey;
    @XmlElement(required = true)
    protected String portgroupKey;
    @XmlElement(required = true)
    protected String portgroupName;

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

    /**
     * Gets the value of the portgroupKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroupKey() {
        return portgroupKey;
    }

    /**
     * Sets the value of the portgroupKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroupKey(String value) {
        this.portgroupKey = value;
    }

    /**
     * Gets the value of the portgroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortgroupName() {
        return portgroupName;
    }

    /**
     * Sets the value of the portgroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortgroupName(String value) {
        this.portgroupName = value;
    }

}
