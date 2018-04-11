
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MismatchedVMotionNetworkNames complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MismatchedVMotionNetworkNames">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MigrationFault">
 *       &lt;sequence>
 *         &lt;element name="sourceNetwork" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="destNetwork" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MismatchedVMotionNetworkNames", propOrder = {
    "sourceNetwork",
    "destNetwork"
})
public class MismatchedVMotionNetworkNames
    extends MigrationFault
{

    @XmlElement(required = true)
    protected String sourceNetwork;
    @XmlElement(required = true)
    protected String destNetwork;

    /**
     * Gets the value of the sourceNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceNetwork() {
        return sourceNetwork;
    }

    /**
     * Sets the value of the sourceNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceNetwork(String value) {
        this.sourceNetwork = value;
    }

    /**
     * Gets the value of the destNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestNetwork() {
        return destNetwork;
    }

    /**
     * Sets the value of the destNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestNetwork(String value) {
        this.destNetwork = value;
    }

}
