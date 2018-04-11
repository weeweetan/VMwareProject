
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HbrManagerReplicationVmInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HbrManagerReplicationVmInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="progressInfo" type="{urn:vim25}ReplicationVmProgressInfo" minOccurs="0"/>
 *         &lt;element name="imageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastError" type="{urn:vim25}LocalizedMethodFault" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HbrManagerReplicationVmInfo", propOrder = {
    "state",
    "progressInfo",
    "imageId",
    "lastError"
})
public class HbrManagerReplicationVmInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String state;
    protected ReplicationVmProgressInfo progressInfo;
    protected String imageId;
    protected LocalizedMethodFault lastError;

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the progressInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ReplicationVmProgressInfo }
     *     
     */
    public ReplicationVmProgressInfo getProgressInfo() {
        return progressInfo;
    }

    /**
     * Sets the value of the progressInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplicationVmProgressInfo }
     *     
     */
    public void setProgressInfo(ReplicationVmProgressInfo value) {
        this.progressInfo = value;
    }

    /**
     * Gets the value of the imageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * Sets the value of the imageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageId(String value) {
        this.imageId = value;
    }

    /**
     * Gets the value of the lastError property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public LocalizedMethodFault getLastError() {
        return lastError;
    }

    /**
     * Sets the value of the lastError property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizedMethodFault }
     *     
     */
    public void setLastError(LocalizedMethodFault value) {
        this.lastError = value;
    }

}
