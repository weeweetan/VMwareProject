
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Event">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="chainId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="createdTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datacenter" type="{urn:vim25}DatacenterEventArgument" minOccurs="0"/>
 *         &lt;element name="computeResource" type="{urn:vim25}ComputeResourceEventArgument" minOccurs="0"/>
 *         &lt;element name="host" type="{urn:vim25}HostEventArgument" minOccurs="0"/>
 *         &lt;element name="vm" type="{urn:vim25}VmEventArgument" minOccurs="0"/>
 *         &lt;element name="ds" type="{urn:vim25}DatastoreEventArgument" minOccurs="0"/>
 *         &lt;element name="net" type="{urn:vim25}NetworkEventArgument" minOccurs="0"/>
 *         &lt;element name="dvs" type="{urn:vim25}DvsEventArgument" minOccurs="0"/>
 *         &lt;element name="fullFormattedMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="changeTag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event", propOrder = {
    "key",
    "chainId",
    "createdTime",
    "userName",
    "datacenter",
    "computeResource",
    "host",
    "vm",
    "ds",
    "net",
    "dvs",
    "fullFormattedMessage",
    "changeTag"
})
@XmlSeeAlso({
    EventEx.class,
    LockerMisconfiguredEvent.class,
    HostInventoryUnreadableEvent.class,
    TaskEvent.class,
    NetworkRollbackEvent.class,
    LockerReconfiguredEvent.class,
    DatacenterEvent.class,
    LicenseExpiredEvent.class,
    SessionEvent.class,
    DatastoreEvent.class,
    CustomFieldEvent.class,
    GeneralEvent.class,
    AuthorizationEvent.class,
    UpgradeEvent.class,
    TemplateUpgradeEvent.class,
    ClusterEvent.class,
    ScheduledTaskEvent.class,
    ProfileEvent.class,
    LicenseEvent.class,
    DVPortgroupEvent.class,
    HealthStatusChangedEvent.class,
    AlarmEvent.class,
    VmEvent.class,
    ResourcePoolEvent.class,
    DvsEvent.class,
    HostEvent.class
})
public class Event
    extends DynamicData
{

    protected int key;
    protected int chainId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdTime;
    @XmlElement(required = true)
    protected String userName;
    protected DatacenterEventArgument datacenter;
    protected ComputeResourceEventArgument computeResource;
    protected HostEventArgument host;
    protected VmEventArgument vm;
    protected DatastoreEventArgument ds;
    protected NetworkEventArgument net;
    protected DvsEventArgument dvs;
    protected String fullFormattedMessage;
    protected String changeTag;

    /**
     * Gets the value of the key property.
     * 
     */
    public int getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     */
    public void setKey(int value) {
        this.key = value;
    }

    /**
     * Gets the value of the chainId property.
     * 
     */
    public int getChainId() {
        return chainId;
    }

    /**
     * Sets the value of the chainId property.
     * 
     */
    public void setChainId(int value) {
        this.chainId = value;
    }

    /**
     * Gets the value of the createdTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets the value of the createdTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedTime(XMLGregorianCalendar value) {
        this.createdTime = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the datacenter property.
     * 
     * @return
     *     possible object is
     *     {@link DatacenterEventArgument }
     *     
     */
    public DatacenterEventArgument getDatacenter() {
        return datacenter;
    }

    /**
     * Sets the value of the datacenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatacenterEventArgument }
     *     
     */
    public void setDatacenter(DatacenterEventArgument value) {
        this.datacenter = value;
    }

    /**
     * Gets the value of the computeResource property.
     * 
     * @return
     *     possible object is
     *     {@link ComputeResourceEventArgument }
     *     
     */
    public ComputeResourceEventArgument getComputeResource() {
        return computeResource;
    }

    /**
     * Sets the value of the computeResource property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComputeResourceEventArgument }
     *     
     */
    public void setComputeResource(ComputeResourceEventArgument value) {
        this.computeResource = value;
    }

    /**
     * Gets the value of the host property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getHost() {
        return host;
    }

    /**
     * Sets the value of the host property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setHost(HostEventArgument value) {
        this.host = value;
    }

    /**
     * Gets the value of the vm property.
     * 
     * @return
     *     possible object is
     *     {@link VmEventArgument }
     *     
     */
    public VmEventArgument getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmEventArgument }
     *     
     */
    public void setVm(VmEventArgument value) {
        this.vm = value;
    }

    /**
     * Gets the value of the ds property.
     * 
     * @return
     *     possible object is
     *     {@link DatastoreEventArgument }
     *     
     */
    public DatastoreEventArgument getDs() {
        return ds;
    }

    /**
     * Sets the value of the ds property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreEventArgument }
     *     
     */
    public void setDs(DatastoreEventArgument value) {
        this.ds = value;
    }

    /**
     * Gets the value of the net property.
     * 
     * @return
     *     possible object is
     *     {@link NetworkEventArgument }
     *     
     */
    public NetworkEventArgument getNet() {
        return net;
    }

    /**
     * Sets the value of the net property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkEventArgument }
     *     
     */
    public void setNet(NetworkEventArgument value) {
        this.net = value;
    }

    /**
     * Gets the value of the dvs property.
     * 
     * @return
     *     possible object is
     *     {@link DvsEventArgument }
     *     
     */
    public DvsEventArgument getDvs() {
        return dvs;
    }

    /**
     * Sets the value of the dvs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DvsEventArgument }
     *     
     */
    public void setDvs(DvsEventArgument value) {
        this.dvs = value;
    }

    /**
     * Gets the value of the fullFormattedMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullFormattedMessage() {
        return fullFormattedMessage;
    }

    /**
     * Sets the value of the fullFormattedMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullFormattedMessage(String value) {
        this.fullFormattedMessage = value;
    }

    /**
     * Gets the value of the changeTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeTag() {
        return changeTag;
    }

    /**
     * Sets the value of the changeTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeTag(String value) {
        this.changeTag = value;
    }

}
