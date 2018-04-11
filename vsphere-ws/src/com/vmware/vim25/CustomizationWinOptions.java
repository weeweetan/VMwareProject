
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationWinOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationWinOptions">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}CustomizationOptions">
 *       &lt;sequence>
 *         &lt;element name="changeSID" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deleteAccounts" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reboot" type="{urn:vim25}CustomizationSysprepRebootOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationWinOptions", propOrder = {
    "changeSID",
    "deleteAccounts",
    "reboot"
})
public class CustomizationWinOptions
    extends CustomizationOptions
{

    protected boolean changeSID;
    protected boolean deleteAccounts;
    protected CustomizationSysprepRebootOption reboot;

    /**
     * Gets the value of the changeSID property.
     * 
     */
    public boolean isChangeSID() {
        return changeSID;
    }

    /**
     * Sets the value of the changeSID property.
     * 
     */
    public void setChangeSID(boolean value) {
        this.changeSID = value;
    }

    /**
     * Gets the value of the deleteAccounts property.
     * 
     */
    public boolean isDeleteAccounts() {
        return deleteAccounts;
    }

    /**
     * Sets the value of the deleteAccounts property.
     * 
     */
    public void setDeleteAccounts(boolean value) {
        this.deleteAccounts = value;
    }

    /**
     * Gets the value of the reboot property.
     * 
     * @return
     *     possible object is
     *     {@link CustomizationSysprepRebootOption }
     *     
     */
    public CustomizationSysprepRebootOption getReboot() {
        return reboot;
    }

    /**
     * Sets the value of the reboot property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomizationSysprepRebootOption }
     *     
     */
    public void setReboot(CustomizationSysprepRebootOption value) {
        this.reboot = value;
    }

}
