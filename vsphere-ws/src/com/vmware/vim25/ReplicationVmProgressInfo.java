
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReplicationVmProgressInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReplicationVmProgressInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="progress" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bytesTransferred" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesToTransfer" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="checksumTotalBytes" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="checksumComparedBytes" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReplicationVmProgressInfo", propOrder = {
    "progress",
    "bytesTransferred",
    "bytesToTransfer",
    "checksumTotalBytes",
    "checksumComparedBytes"
})
public class ReplicationVmProgressInfo
    extends DynamicData
{

    protected int progress;
    protected long bytesTransferred;
    protected long bytesToTransfer;
    protected Long checksumTotalBytes;
    protected Long checksumComparedBytes;

    /**
     * Gets the value of the progress property.
     * 
     */
    public int getProgress() {
        return progress;
    }

    /**
     * Sets the value of the progress property.
     * 
     */
    public void setProgress(int value) {
        this.progress = value;
    }

    /**
     * Gets the value of the bytesTransferred property.
     * 
     */
    public long getBytesTransferred() {
        return bytesTransferred;
    }

    /**
     * Sets the value of the bytesTransferred property.
     * 
     */
    public void setBytesTransferred(long value) {
        this.bytesTransferred = value;
    }

    /**
     * Gets the value of the bytesToTransfer property.
     * 
     */
    public long getBytesToTransfer() {
        return bytesToTransfer;
    }

    /**
     * Sets the value of the bytesToTransfer property.
     * 
     */
    public void setBytesToTransfer(long value) {
        this.bytesToTransfer = value;
    }

    /**
     * Gets the value of the checksumTotalBytes property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChecksumTotalBytes() {
        return checksumTotalBytes;
    }

    /**
     * Sets the value of the checksumTotalBytes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChecksumTotalBytes(Long value) {
        this.checksumTotalBytes = value;
    }

    /**
     * Gets the value of the checksumComparedBytes property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChecksumComparedBytes() {
        return checksumComparedBytes;
    }

    /**
     * Sets the value of the checksumComparedBytes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChecksumComparedBytes(Long value) {
        this.checksumComparedBytes = value;
    }

}
