
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualMachineConfigSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualMachineConfigSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="template" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vmPathName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="memorySizeMB" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cpuReservation" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memoryReservation" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numCpu" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numEthernetCards" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numVirtualDisks" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instanceUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guestFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="annotation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="product" type="{urn:vim25}VAppProductInfo" minOccurs="0"/>
 *         &lt;element name="installBootRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ftInfo" type="{urn:vim25}FaultToleranceConfigInfo" minOccurs="0"/>
 *         &lt;element name="managedBy" type="{urn:vim25}ManagedByInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualMachineConfigSummary", propOrder = {
    "name",
    "template",
    "vmPathName",
    "memorySizeMB",
    "cpuReservation",
    "memoryReservation",
    "numCpu",
    "numEthernetCards",
    "numVirtualDisks",
    "uuid",
    "instanceUuid",
    "guestId",
    "guestFullName",
    "annotation",
    "product",
    "installBootRequired",
    "ftInfo",
    "managedBy"
})
public class VirtualMachineConfigSummary
    extends DynamicData
{

    @XmlElement(required = true)
    protected String name;
    protected boolean template;
    @XmlElement(required = true)
    protected String vmPathName;
    protected Integer memorySizeMB;
    protected Integer cpuReservation;
    protected Integer memoryReservation;
    protected Integer numCpu;
    protected Integer numEthernetCards;
    protected Integer numVirtualDisks;
    protected String uuid;
    protected String instanceUuid;
    protected String guestId;
    protected String guestFullName;
    protected String annotation;
    protected VAppProductInfo product;
    protected Boolean installBootRequired;
    protected FaultToleranceConfigInfo ftInfo;
    protected ManagedByInfo managedBy;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the template property.
     * 
     */
    public boolean isTemplate() {
        return template;
    }

    /**
     * Sets the value of the template property.
     * 
     */
    public void setTemplate(boolean value) {
        this.template = value;
    }

    /**
     * Gets the value of the vmPathName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVmPathName() {
        return vmPathName;
    }

    /**
     * Sets the value of the vmPathName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVmPathName(String value) {
        this.vmPathName = value;
    }

    /**
     * Gets the value of the memorySizeMB property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMemorySizeMB() {
        return memorySizeMB;
    }

    /**
     * Sets the value of the memorySizeMB property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMemorySizeMB(Integer value) {
        this.memorySizeMB = value;
    }

    /**
     * Gets the value of the cpuReservation property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCpuReservation() {
        return cpuReservation;
    }

    /**
     * Sets the value of the cpuReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCpuReservation(Integer value) {
        this.cpuReservation = value;
    }

    /**
     * Gets the value of the memoryReservation property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMemoryReservation() {
        return memoryReservation;
    }

    /**
     * Sets the value of the memoryReservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMemoryReservation(Integer value) {
        this.memoryReservation = value;
    }

    /**
     * Gets the value of the numCpu property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumCpu() {
        return numCpu;
    }

    /**
     * Sets the value of the numCpu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumCpu(Integer value) {
        this.numCpu = value;
    }

    /**
     * Gets the value of the numEthernetCards property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumEthernetCards() {
        return numEthernetCards;
    }

    /**
     * Sets the value of the numEthernetCards property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumEthernetCards(Integer value) {
        this.numEthernetCards = value;
    }

    /**
     * Gets the value of the numVirtualDisks property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumVirtualDisks() {
        return numVirtualDisks;
    }

    /**
     * Sets the value of the numVirtualDisks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumVirtualDisks(Integer value) {
        this.numVirtualDisks = value;
    }

    /**
     * Gets the value of the uuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * Gets the value of the instanceUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceUuid() {
        return instanceUuid;
    }

    /**
     * Sets the value of the instanceUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceUuid(String value) {
        this.instanceUuid = value;
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
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnotation(String value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link VAppProductInfo }
     *     
     */
    public VAppProductInfo getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link VAppProductInfo }
     *     
     */
    public void setProduct(VAppProductInfo value) {
        this.product = value;
    }

    /**
     * Gets the value of the installBootRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInstallBootRequired() {
        return installBootRequired;
    }

    /**
     * Sets the value of the installBootRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInstallBootRequired(Boolean value) {
        this.installBootRequired = value;
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

    /**
     * Gets the value of the managedBy property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedByInfo }
     *     
     */
    public ManagedByInfo getManagedBy() {
        return managedBy;
    }

    /**
     * Sets the value of the managedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedByInfo }
     *     
     */
    public void setManagedBy(ManagedByInfo value) {
        this.managedBy = value;
    }

}
