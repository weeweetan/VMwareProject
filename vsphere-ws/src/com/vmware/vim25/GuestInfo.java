
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="toolsStatus" type="{urn:vim25}VirtualMachineToolsStatus" minOccurs="0"/>
 *         &lt;element name="toolsVersionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toolsVersionStatus2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toolsRunningStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toolsVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guestFamily" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guestFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hostName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="net" type="{urn:vim25}GuestNicInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipStack" type="{urn:vim25}GuestStackInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="disk" type="{urn:vim25}GuestDiskInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="screen" type="{urn:vim25}GuestScreenInfo" minOccurs="0"/>
 *         &lt;element name="guestState" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appHeartbeatStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guestOperationsReady" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="interactiveGuestOperationsReady" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="generationInfo" type="{urn:vim25}GuestInfoNamespaceGenerationInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestInfo", propOrder = {
    "toolsStatus",
    "toolsVersionStatus",
    "toolsVersionStatus2",
    "toolsRunningStatus",
    "toolsVersion",
    "guestId",
    "guestFamily",
    "guestFullName",
    "hostName",
    "ipAddress",
    "net",
    "ipStack",
    "disk",
    "screen",
    "guestState",
    "appHeartbeatStatus",
    "guestOperationsReady",
    "interactiveGuestOperationsReady",
    "generationInfo"
})
public class GuestInfo
    extends DynamicData
{

    protected VirtualMachineToolsStatus toolsStatus;
    protected String toolsVersionStatus;
    protected String toolsVersionStatus2;
    protected String toolsRunningStatus;
    protected String toolsVersion;
    protected String guestId;
    protected String guestFamily;
    protected String guestFullName;
    protected String hostName;
    protected String ipAddress;
    protected List<GuestNicInfo> net;
    protected List<GuestStackInfo> ipStack;
    protected List<GuestDiskInfo> disk;
    protected GuestScreenInfo screen;
    @XmlElement(required = true)
    protected String guestState;
    protected String appHeartbeatStatus;
    protected Boolean guestOperationsReady;
    protected Boolean interactiveGuestOperationsReady;
    protected List<GuestInfoNamespaceGenerationInfo> generationInfo;

    /**
     * Gets the value of the toolsStatus property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualMachineToolsStatus }
     *     
     */
    public VirtualMachineToolsStatus getToolsStatus() {
        return toolsStatus;
    }

    /**
     * Sets the value of the toolsStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualMachineToolsStatus }
     *     
     */
    public void setToolsStatus(VirtualMachineToolsStatus value) {
        this.toolsStatus = value;
    }

    /**
     * Gets the value of the toolsVersionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolsVersionStatus() {
        return toolsVersionStatus;
    }

    /**
     * Sets the value of the toolsVersionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolsVersionStatus(String value) {
        this.toolsVersionStatus = value;
    }

    /**
     * Gets the value of the toolsVersionStatus2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolsVersionStatus2() {
        return toolsVersionStatus2;
    }

    /**
     * Sets the value of the toolsVersionStatus2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolsVersionStatus2(String value) {
        this.toolsVersionStatus2 = value;
    }

    /**
     * Gets the value of the toolsRunningStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolsRunningStatus() {
        return toolsRunningStatus;
    }

    /**
     * Sets the value of the toolsRunningStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolsRunningStatus(String value) {
        this.toolsRunningStatus = value;
    }

    /**
     * Gets the value of the toolsVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToolsVersion() {
        return toolsVersion;
    }

    /**
     * Sets the value of the toolsVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToolsVersion(String value) {
        this.toolsVersion = value;
    }

    /**
     * Gets the value of the guestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * Sets the value of the guestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestId(String value) {
        this.guestId = value;
    }

    /**
     * Gets the value of the guestFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestFamily() {
        return guestFamily;
    }

    /**
     * Sets the value of the guestFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestFamily(String value) {
        this.guestFamily = value;
    }

    /**
     * Gets the value of the guestFullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestFullName() {
        return guestFullName;
    }

    /**
     * Sets the value of the guestFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestFullName(String value) {
        this.guestFullName = value;
    }

    /**
     * Gets the value of the hostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * Sets the value of the hostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostName(String value) {
        this.hostName = value;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    /**
     * Gets the value of the net property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the net property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestNicInfo }
     * 
     * 
     */
    public List<GuestNicInfo> getNet() {
        if (net == null) {
            net = new ArrayList<GuestNicInfo>();
        }
        return this.net;
    }

    /**
     * Gets the value of the ipStack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipStack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpStack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestStackInfo }
     * 
     * 
     */
    public List<GuestStackInfo> getIpStack() {
        if (ipStack == null) {
            ipStack = new ArrayList<GuestStackInfo>();
        }
        return this.ipStack;
    }

    /**
     * Gets the value of the disk property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disk property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisk().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestDiskInfo }
     * 
     * 
     */
    public List<GuestDiskInfo> getDisk() {
        if (disk == null) {
            disk = new ArrayList<GuestDiskInfo>();
        }
        return this.disk;
    }

    /**
     * Gets the value of the screen property.
     * 
     * @return
     *     possible object is
     *     {@link GuestScreenInfo }
     *     
     */
    public GuestScreenInfo getScreen() {
        return screen;
    }

    /**
     * Sets the value of the screen property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuestScreenInfo }
     *     
     */
    public void setScreen(GuestScreenInfo value) {
        this.screen = value;
    }

    /**
     * Gets the value of the guestState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestState() {
        return guestState;
    }

    /**
     * Sets the value of the guestState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestState(String value) {
        this.guestState = value;
    }

    /**
     * Gets the value of the appHeartbeatStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppHeartbeatStatus() {
        return appHeartbeatStatus;
    }

    /**
     * Sets the value of the appHeartbeatStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppHeartbeatStatus(String value) {
        this.appHeartbeatStatus = value;
    }

    /**
     * Gets the value of the guestOperationsReady property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGuestOperationsReady() {
        return guestOperationsReady;
    }

    /**
     * Sets the value of the guestOperationsReady property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGuestOperationsReady(Boolean value) {
        this.guestOperationsReady = value;
    }

    /**
     * Gets the value of the interactiveGuestOperationsReady property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInteractiveGuestOperationsReady() {
        return interactiveGuestOperationsReady;
    }

    /**
     * Sets the value of the interactiveGuestOperationsReady property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInteractiveGuestOperationsReady(Boolean value) {
        this.interactiveGuestOperationsReady = value;
    }

    /**
     * Gets the value of the generationInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generationInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenerationInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestInfoNamespaceGenerationInfo }
     * 
     * 
     */
    public List<GuestInfoNamespaceGenerationInfo> getGenerationInfo() {
        if (generationInfo == null) {
            generationInfo = new ArrayList<GuestInfoNamespaceGenerationInfo>();
        }
        return this.generationInfo;
    }

}
