
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryMemoryOverheadRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryMemoryOverheadRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="memorySize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="videoRamSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numVcpus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryMemoryOverheadRequestType", propOrder = {
    "_this",
    "memorySize",
    "videoRamSize",
    "numVcpus"
})
public class QueryMemoryOverheadRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    protected long memorySize;
    protected Integer videoRamSize;
    protected int numVcpus;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setThis(ManagedObjectReference value) {
        this._this = value;
    }

    /**
     * Gets the value of the memorySize property.
     * 
     */
    public long getMemorySize() {
        return memorySize;
    }

    /**
     * Sets the value of the memorySize property.
     * 
     */
    public void setMemorySize(long value) {
        this.memorySize = value;
    }

    /**
     * Gets the value of the videoRamSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVideoRamSize() {
        return videoRamSize;
    }

    /**
     * Sets the value of the videoRamSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVideoRamSize(Integer value) {
        this.videoRamSize = value;
    }

    /**
     * Gets the value of the numVcpus property.
     * 
     */
    public int getNumVcpus() {
        return numVcpus;
    }

    /**
     * Sets the value of the numVcpus property.
     * 
     */
    public void setNumVcpus(int value) {
        this.numVcpus = value;
    }

}
