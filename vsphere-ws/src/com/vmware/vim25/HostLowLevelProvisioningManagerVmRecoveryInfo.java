
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostLowLevelProvisioningManagerVmRecoveryInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostLowLevelProvisioningManagerVmRecoveryInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="biosUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceUUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ftInfo" type="{urn:vim25}FaultToleranceConfigInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostLowLevelProvisioningManagerVmRecoveryInfo", propOrder = {
    "version",
    "biosUUID",
    "instanceUUID",
    "ftInfo"
})
public class HostLowLevelProvisioningManagerVmRecoveryInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String version;
    @XmlElement(required = true)
    protected String biosUUID;
    @XmlElement(required = true)
    protected String instanceUUID;
    protected FaultToleranceConfigInfo ftInfo;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the biosUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiosUUID() {
        return biosUUID;
    }

    /**
     * Sets the value of the biosUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiosUUID(String value) {
        this.biosUUID = value;
    }

    /**
     * Gets the value of the instanceUUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceUUID() {
        return instanceUUID;
    }

    /**
     * Sets the value of the instanceUUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceUUID(String value) {
        this.instanceUUID = value;
    }

    /**
     * Gets the value of the ftInfo property.
     * 
     * @return
     *     possible object is
     *     {@link FaultToleranceConfigInfo }
     *     
     */
    public FaultToleranceConfigInfo getFtInfo() {
        return ftInfo;
    }

    /**
     * Sets the value of the ftInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FaultToleranceConfigInfo }
     *     
     */
    public void setFtInfo(FaultToleranceConfigInfo value) {
        this.ftInfo = value;
    }

}
