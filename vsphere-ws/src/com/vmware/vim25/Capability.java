
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Capability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Capability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="provisioningSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="multiHostSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userShellAccessSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="supportedEVCMode" type="{urn:vim25}EVCMode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="networkBackupAndRestoreSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Capability", propOrder = {
    "provisioningSupported",
    "multiHostSupported",
    "userShellAccessSupported",
    "supportedEVCMode",
    "networkBackupAndRestoreSupported"
})
public class Capability
    extends DynamicData
{

    protected boolean provisioningSupported;
    protected boolean multiHostSupported;
    protected boolean userShellAccessSupported;
    protected List<EVCMode> supportedEVCMode;
    protected Boolean networkBackupAndRestoreSupported;

    /**
     * Gets the value of the provisioningSupported property.
     * 
     */
    public boolean isProvisioningSupported() {
        return provisioningSupported;
    }

    /**
     * Sets the value of the provisioningSupported property.
     * 
     */
    public void setProvisioningSupported(boolean value) {
        this.provisioningSupported = value;
    }

    /**
     * Gets the value of the multiHostSupported property.
     * 
     */
    public boolean isMultiHostSupported() {
        return multiHostSupported;
    }

    /**
     * Sets the value of the multiHostSupported property.
     * 
     */
    public void setMultiHostSupported(boolean value) {
        this.multiHostSupported = value;
    }

    /**
     * Gets the value of the userShellAccessSupported property.
     * 
     */
    public boolean isUserShellAccessSupported() {
        return userShellAccessSupported;
    }

    /**
     * Sets the value of the userShellAccessSupported property.
     * 
     */
    public void setUserShellAccessSupported(boolean value) {
        this.userShellAccessSupported = value;
    }

    /**
     * Gets the value of the supportedEVCMode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedEVCMode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedEVCMode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EVCMode }
     * 
     * 
     */
    public List<EVCMode> getSupportedEVCMode() {
        if (supportedEVCMode == null) {
            supportedEVCMode = new ArrayList<EVCMode>();
        }
        return this.supportedEVCMode;
    }

    /**
     * Gets the value of the networkBackupAndRestoreSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNetworkBackupAndRestoreSupported() {
        return networkBackupAndRestoreSupported;
    }

    /**
     * Sets the value of the networkBackupAndRestoreSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNetworkBackupAndRestoreSupported(Boolean value) {
        this.networkBackupAndRestoreSupported = value;
    }

}
