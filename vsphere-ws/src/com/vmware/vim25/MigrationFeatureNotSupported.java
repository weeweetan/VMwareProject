
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MigrationFeatureNotSupported complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MigrationFeatureNotSupported">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MigrationFault">
 *       &lt;sequence>
 *         &lt;element name="atSourceHost" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="failedHostName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="failedHost" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MigrationFeatureNotSupported", propOrder = {
    "atSourceHost",
    "failedHostName",
    "failedHost"
})
@XmlSeeAlso({
    IndependentDiskVMotionNotSupported.class,
    StorageVMotionNotSupported.class,
    UnsharedSwapVMotionNotSupported.class,
    FullStorageVMotionNotSupported.class,
    NonHomeRDMVMotionNotSupported.class
})
public class MigrationFeatureNotSupported
    extends MigrationFault
{

    protected boolean atSourceHost;
    @XmlElement(required = true)
    protected String failedHostName;
    @XmlElement(required = true)
    protected ManagedObjectReference failedHost;

    /**
     * Gets the value of the atSourceHost property.
     * 
     */
    public boolean isAtSourceHost() {
        return atSourceHost;
    }

    /**
     * Sets the value of the atSourceHost property.
     * 
     */
    public void setAtSourceHost(boolean value) {
        this.atSourceHost = value;
    }

    /**
     * Gets the value of the failedHostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailedHostName() {
        return failedHostName;
    }

    /**
     * Sets the value of the failedHostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailedHostName(String value) {
        this.failedHostName = value;
    }

    /**
     * Gets the value of the failedHost property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getFailedHost() {
        return failedHost;
    }

    /**
     * Sets the value of the failedHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setFailedHost(ManagedObjectReference value) {
        this.failedHost = value;
    }

}
