
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPatchManagerStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostPatchManagerStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="applicable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="integrity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="installed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="installState" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prerequisitePatch" type="{urn:vim25}HostPatchManagerStatusPrerequisitePatch" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="restartRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="reconnectRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmOffRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="supersededPatchIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostPatchManagerStatus", propOrder = {
    "id",
    "applicable",
    "reason",
    "integrity",
    "installed",
    "installState",
    "prerequisitePatch",
    "restartRequired",
    "reconnectRequired",
    "vmOffRequired",
    "supersededPatchIds"
})
public class HostPatchManagerStatus
    extends DynamicData
{

    @XmlElement(required = true)
    protected String id;
    protected boolean applicable;
    protected List<String> reason;
    protected String integrity;
    protected boolean installed;
    protected List<String> installState;
    protected List<HostPatchManagerStatusPrerequisitePatch> prerequisitePatch;
    protected boolean restartRequired;
    protected boolean reconnectRequired;
    protected boolean vmOffRequired;
    protected List<String> supersededPatchIds;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the applicable property.
     * 
     */
    public boolean isApplicable() {
        return applicable;
    }

    /**
     * Sets the value of the applicable property.
     * 
     */
    public void setApplicable(boolean value) {
        this.applicable = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReason() {
        if (reason == null) {
            reason = new ArrayList<String>();
        }
        return this.reason;
    }

    /**
     * Gets the value of the integrity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntegrity() {
        return integrity;
    }

    /**
     * Sets the value of the integrity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntegrity(String value) {
        this.integrity = value;
    }

    /**
     * Gets the value of the installed property.
     * 
     */
    public boolean isInstalled() {
        return installed;
    }

    /**
     * Sets the value of the installed property.
     * 
     */
    public void setInstalled(boolean value) {
        this.installed = value;
    }

    /**
     * Gets the value of the installState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the installState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstallState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInstallState() {
        if (installState == null) {
            installState = new ArrayList<String>();
        }
        return this.installState;
    }

    /**
     * Gets the value of the prerequisitePatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prerequisitePatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrerequisitePatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPatchManagerStatusPrerequisitePatch }
     * 
     * 
     */
    public List<HostPatchManagerStatusPrerequisitePatch> getPrerequisitePatch() {
        if (prerequisitePatch == null) {
            prerequisitePatch = new ArrayList<HostPatchManagerStatusPrerequisitePatch>();
        }
        return this.prerequisitePatch;
    }

    /**
     * Gets the value of the restartRequired property.
     * 
     */
    public boolean isRestartRequired() {
        return restartRequired;
    }

    /**
     * Sets the value of the restartRequired property.
     * 
     */
    public void setRestartRequired(boolean value) {
        this.restartRequired = value;
    }

    /**
     * Gets the value of the reconnectRequired property.
     * 
     */
    public boolean isReconnectRequired() {
        return reconnectRequired;
    }

    /**
     * Sets the value of the reconnectRequired property.
     * 
     */
    public void setReconnectRequired(boolean value) {
        this.reconnectRequired = value;
    }

    /**
     * Gets the value of the vmOffRequired property.
     * 
     */
    public boolean isVmOffRequired() {
        return vmOffRequired;
    }

    /**
     * Sets the value of the vmOffRequired property.
     * 
     */
    public void setVmOffRequired(boolean value) {
        this.vmOffRequired = value;
    }

    /**
     * Gets the value of the supersededPatchIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supersededPatchIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupersededPatchIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupersededPatchIds() {
        if (supersededPatchIds == null) {
            supersededPatchIds = new ArrayList<String>();
        }
        return this.supersededPatchIds;
    }

}
