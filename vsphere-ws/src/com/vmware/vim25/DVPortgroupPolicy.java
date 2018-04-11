
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVPortgroupPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVPortgroupPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="blockOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="shapingOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vendorConfigOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="livePortMovingAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="portConfigResetAtDisconnect" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="networkResourcePoolOverrideAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVPortgroupPolicy", propOrder = {
    "blockOverrideAllowed",
    "shapingOverrideAllowed",
    "vendorConfigOverrideAllowed",
    "livePortMovingAllowed",
    "portConfigResetAtDisconnect",
    "networkResourcePoolOverrideAllowed"
})
@XmlSeeAlso({
    VMwareDVSPortgroupPolicy.class
})
public class DVPortgroupPolicy
    extends DynamicData
{

    protected boolean blockOverrideAllowed;
    protected boolean shapingOverrideAllowed;
    protected boolean vendorConfigOverrideAllowed;
    protected boolean livePortMovingAllowed;
    protected boolean portConfigResetAtDisconnect;
    protected Boolean networkResourcePoolOverrideAllowed;

    /**
     * Gets the value of the blockOverrideAllowed property.
     * 
     */
    public boolean isBlockOverrideAllowed() {
        return blockOverrideAllowed;
    }

    /**
     * Sets the value of the blockOverrideAllowed property.
     * 
     */
    public void setBlockOverrideAllowed(boolean value) {
        this.blockOverrideAllowed = value;
    }

    /**
     * Gets the value of the shapingOverrideAllowed property.
     * 
     */
    public boolean isShapingOverrideAllowed() {
        return shapingOverrideAllowed;
    }

    /**
     * Sets the value of the shapingOverrideAllowed property.
     * 
     */
    public void setShapingOverrideAllowed(boolean value) {
        this.shapingOverrideAllowed = value;
    }

    /**
     * Gets the value of the vendorConfigOverrideAllowed property.
     * 
     */
    public boolean isVendorConfigOverrideAllowed() {
        return vendorConfigOverrideAllowed;
    }

    /**
     * Sets the value of the vendorConfigOverrideAllowed property.
     * 
     */
    public void setVendorConfigOverrideAllowed(boolean value) {
        this.vendorConfigOverrideAllowed = value;
    }

    /**
     * Gets the value of the livePortMovingAllowed property.
     * 
     */
    public boolean isLivePortMovingAllowed() {
        return livePortMovingAllowed;
    }

    /**
     * Sets the value of the livePortMovingAllowed property.
     * 
     */
    public void setLivePortMovingAllowed(boolean value) {
        this.livePortMovingAllowed = value;
    }

    /**
     * Gets the value of the portConfigResetAtDisconnect property.
     * 
     */
    public boolean isPortConfigResetAtDisconnect() {
        return portConfigResetAtDisconnect;
    }

    /**
     * Sets the value of the portConfigResetAtDisconnect property.
     * 
     */
    public void setPortConfigResetAtDisconnect(boolean value) {
        this.portConfigResetAtDisconnect = value;
    }

    /**
     * Gets the value of the networkResourcePoolOverrideAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNetworkResourcePoolOverrideAllowed() {
        return networkResourcePoolOverrideAllowed;
    }

    /**
     * Sets the value of the networkResourcePoolOverrideAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetworkResourcePoolOverrideAllowed(Boolean value) {
        this.networkResourcePoolOverrideAllowed = value;
    }

}
