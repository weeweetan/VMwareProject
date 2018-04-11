
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSFeatureCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSFeatureCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DVSFeatureCapability">
 *       &lt;sequence>
 *         &lt;element name="vspanSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="lldpSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ipfixSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="vspanCapability" type="{urn:vim25}VMwareDVSVspanCapability" minOccurs="0"/>
 *         &lt;element name="lacpCapability" type="{urn:vim25}VMwareDvsLacpCapability" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareDVSFeatureCapability", propOrder = {
    "vspanSupported",
    "lldpSupported",
    "ipfixSupported",
    "vspanCapability",
    "lacpCapability"
})
public class VMwareDVSFeatureCapability
    extends DVSFeatureCapability
{

    protected Boolean vspanSupported;
    protected Boolean lldpSupported;
    protected Boolean ipfixSupported;
    protected VMwareDVSVspanCapability vspanCapability;
    protected VMwareDvsLacpCapability lacpCapability;

    /**
     * Gets the value of the vspanSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVspanSupported() {
        return vspanSupported;
    }

    /**
     * Sets the value of the vspanSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVspanSupported(Boolean value) {
        this.vspanSupported = value;
    }

    /**
     * Gets the value of the lldpSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLldpSupported() {
        return lldpSupported;
    }

    /**
     * Sets the value of the lldpSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLldpSupported(Boolean value) {
        this.lldpSupported = value;
    }

    /**
     * Gets the value of the ipfixSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIpfixSupported() {
        return ipfixSupported;
    }

    /**
     * Sets the value of the ipfixSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIpfixSupported(Boolean value) {
        this.ipfixSupported = value;
    }

    /**
     * Gets the value of the vspanCapability property.
     * 
     * @return
     *     possible object is
     *     {@link VMwareDVSVspanCapability }
     *     
     */
    public VMwareDVSVspanCapability getVspanCapability() {
        return vspanCapability;
    }

    /**
     * Sets the value of the vspanCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link VMwareDVSVspanCapability }
     *     
     */
    public void setVspanCapability(VMwareDVSVspanCapability value) {
        this.vspanCapability = value;
    }

    /**
     * Gets the value of the lacpCapability property.
     * 
     * @return
     *     possible object is
     *     {@link VMwareDvsLacpCapability }
     *     
     */
    public VMwareDvsLacpCapability getLacpCapability() {
        return lacpCapability;
    }

    /**
     * Sets the value of the lacpCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link VMwareDvsLacpCapability }
     *     
     */
    public void setLacpCapability(VMwareDvsLacpCapability value) {
        this.lacpCapability = value;
    }

}
