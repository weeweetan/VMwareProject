
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CpuIncompatible complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CpuIncompatible">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualHardwareCompatibilityIssue">
 *       &lt;sequence>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="registerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="registerBits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desiredBits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="host" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CpuIncompatible", propOrder = {
    "level",
    "registerName",
    "registerBits",
    "desiredBits",
    "host"
})
@XmlSeeAlso({
    FaultToleranceCpuIncompatible.class,
    CpuCompatibilityUnknown.class,
    CpuIncompatible81EDX.class,
    CpuIncompatible1ECX.class
})
public class CpuIncompatible
    extends VirtualHardwareCompatibilityIssue
{

    protected int level;
    @XmlElement(required = true)
    protected String registerName;
    protected String registerBits;
    protected String desiredBits;
    protected ManagedObjectReference host;

    /**
     * Gets the value of the level property.
     * 
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     */
    public void setLevel(int value) {
        this.level = value;
    }

    /**
     * Gets the value of the registerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterName() {
        return registerName;
    }

    /**
     * Sets the value of the registerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterName(String value) {
        this.registerName = value;
    }

    /**
     * Gets the value of the registerBits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterBits() {
        return registerBits;
    }

    /**
     * Sets the value of the registerBits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterBits(String value) {
        this.registerBits = value;
    }

    /**
     * Gets the value of the desiredBits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesiredBits() {
        return desiredBits;
    }

    /**
     * Sets the value of the desiredBits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesiredBits(String value) {
        this.desiredBits = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setHost(ManagedObjectReference value) {
        this.host = value;
    }

}
