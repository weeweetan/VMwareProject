
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VspanPortMoveFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VspanPortMoveFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsFault">
 *       &lt;sequence>
 *         &lt;element name="srcPortgroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="destPortgroupName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "VspanPortMoveFault", propOrder = {
    "srcPortgroupName",
    "destPortgroupName",
    "portKey"
})
public class VspanPortMoveFault
    extends DvsFault
{

    @XmlElement(required = true)
    protected String srcPortgroupName;
    @XmlElement(required = true)
    protected String destPortgroupName;
    @XmlElement(required = true)
    protected String portKey;

    /**
     * Gets the value of the srcPortgroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcPortgroupName() {
        return srcPortgroupName;
    }

    /**
     * Sets the value of the srcPortgroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcPortgroupName(String value) {
        this.srcPortgroupName = value;
    }

    /**
     * Gets the value of the destPortgroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestPortgroupName() {
        return destPortgroupName;
    }

    /**
     * Sets the value of the destPortgroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestPortgroupName(String value) {
        this.destPortgroupName = value;
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
