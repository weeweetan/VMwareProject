
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsHostStatusUpdated complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsHostStatusUpdated">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsEvent">
 *       &lt;sequence>
 *         &lt;element name="hostMember" type="{urn:vim25}HostEventArgument"/>
 *         &lt;element name="oldStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oldStatusDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newStatusDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsHostStatusUpdated", propOrder = {
    "hostMember",
    "oldStatus",
    "newStatus",
    "oldStatusDetail",
    "newStatusDetail"
})
public class DvsHostStatusUpdated
    extends DvsEvent
{

    @XmlElement(required = true)
    protected HostEventArgument hostMember;
    protected String oldStatus;
    protected String newStatus;
    protected String oldStatusDetail;
    protected String newStatusDetail;

    /**
     * Gets the value of the hostMember property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getHostMember() {
        return hostMember;
    }

    /**
     * Sets the value of the hostMember property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setHostMember(HostEventArgument value) {
        this.hostMember = value;
    }

    /**
     * Gets the value of the oldStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldStatus() {
        return oldStatus;
    }

    /**
     * Sets the value of the oldStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldStatus(String value) {
        this.oldStatus = value;
    }

    /**
     * Gets the value of the newStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewStatus() {
        return newStatus;
    }

    /**
     * Sets the value of the newStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewStatus(String value) {
        this.newStatus = value;
    }

    /**
     * Gets the value of the oldStatusDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldStatusDetail() {
        return oldStatusDetail;
    }

    /**
     * Sets the value of the oldStatusDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldStatusDetail(String value) {
        this.oldStatusDetail = value;
    }

    /**
     * Gets the value of the newStatusDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewStatusDetail() {
        return newStatusDetail;
    }

    /**
     * Sets the value of the newStatusDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewStatusDetail(String value) {
        this.newStatusDetail = value;
    }

}
