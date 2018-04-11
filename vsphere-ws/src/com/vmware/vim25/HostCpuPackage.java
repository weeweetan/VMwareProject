
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostCpuPackage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostCpuPackage">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="vendor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hz" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="busHz" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="threadId" type="{http://www.w3.org/2001/XMLSchema}short" maxOccurs="unbounded"/>
 *         &lt;element name="cpuFeature" type="{urn:vim25}HostCpuIdInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostCpuPackage", propOrder = {
    "index",
    "vendor",
    "hz",
    "busHz",
    "description",
    "threadId",
    "cpuFeature"
})
public class HostCpuPackage
    extends DynamicData
{

    protected short index;
    @XmlElement(required = true)
    protected String vendor;
    protected long hz;
    protected long busHz;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(type = Short.class)
    protected List<Short> threadId;
    protected List<HostCpuIdInfo> cpuFeature;

    /**
     * Gets the value of the index property.
     * 
     */
    public short getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     */
    public void setIndex(short value) {
        this.index = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendor(String value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the hz property.
     * 
     */
    public long getHz() {
        return hz;
    }

    /**
     * Sets the value of the hz property.
     * 
     */
    public void setHz(long value) {
        this.hz = value;
    }

    /**
     * Gets the value of the busHz property.
     * 
     */
    public long getBusHz() {
        return busHz;
    }

    /**
     * Sets the value of the busHz property.
     * 
     */
    public void setBusHz(long value) {
        this.busHz = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the threadId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the threadId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThreadId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Short }
     * 
     * 
     */
    public List<Short> getThreadId() {
        if (threadId == null) {
            threadId = new ArrayList<Short>();
        }
        return this.threadId;
    }

    /**
     * Gets the value of the cpuFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cpuFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCpuFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostCpuIdInfo }
     * 
     * 
     */
    public List<HostCpuIdInfo> getCpuFeature() {
        if (cpuFeature == null) {
            cpuFeature = new ArrayList<HostCpuIdInfo>();
        }
        return this.cpuFeature;
    }

}
