
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchPortStatistics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualSwitchPortStatistics">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="packetsInMulticast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsOutMulticast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesInMulticast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesOutMulticast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsInUnicast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsOutUnicast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesInUnicast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesOutUnicast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsInBroadcast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsOutBroadcast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesInBroadcast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesOutBroadcast" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsInDropped" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsOutDropped" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsInException" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="packetsOutException" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualSwitchPortStatistics", propOrder = {
    "packetsInMulticast",
    "packetsOutMulticast",
    "bytesInMulticast",
    "bytesOutMulticast",
    "packetsInUnicast",
    "packetsOutUnicast",
    "bytesInUnicast",
    "bytesOutUnicast",
    "packetsInBroadcast",
    "packetsOutBroadcast",
    "bytesInBroadcast",
    "bytesOutBroadcast",
    "packetsInDropped",
    "packetsOutDropped",
    "packetsInException",
    "packetsOutException"
})
public class DistributedVirtualSwitchPortStatistics
    extends DynamicData
{

    protected long packetsInMulticast;
    protected long packetsOutMulticast;
    protected long bytesInMulticast;
    protected long bytesOutMulticast;
    protected long packetsInUnicast;
    protected long packetsOutUnicast;
    protected long bytesInUnicast;
    protected long bytesOutUnicast;
    protected long packetsInBroadcast;
    protected long packetsOutBroadcast;
    protected long bytesInBroadcast;
    protected long bytesOutBroadcast;
    protected long packetsInDropped;
    protected long packetsOutDropped;
    protected long packetsInException;
    protected long packetsOutException;

    /**
     * Gets the value of the packetsInMulticast property.
     * 
     */
    public long getPacketsInMulticast() {
        return packetsInMulticast;
    }

    /**
     * Sets the value of the packetsInMulticast property.
     * 
     */
    public void setPacketsInMulticast(long value) {
        this.packetsInMulticast = value;
    }

    /**
     * Gets the value of the packetsOutMulticast property.
     * 
     */
    public long getPacketsOutMulticast() {
        return packetsOutMulticast;
    }

    /**
     * Sets the value of the packetsOutMulticast property.
     * 
     */
    public void setPacketsOutMulticast(long value) {
        this.packetsOutMulticast = value;
    }

    /**
     * Gets the value of the bytesInMulticast property.
     * 
     */
    public long getBytesInMulticast() {
        return bytesInMulticast;
    }

    /**
     * Sets the value of the bytesInMulticast property.
     * 
     */
    public void setBytesInMulticast(long value) {
        this.bytesInMulticast = value;
    }

    /**
     * Gets the value of the bytesOutMulticast property.
     * 
     */
    public long getBytesOutMulticast() {
        return bytesOutMulticast;
    }

    /**
     * Sets the value of the bytesOutMulticast property.
     * 
     */
    public void setBytesOutMulticast(long value) {
        this.bytesOutMulticast = value;
    }

    /**
     * Gets the value of the packetsInUnicast property.
     * 
     */
    public long getPacketsInUnicast() {
        return packetsInUnicast;
    }

    /**
     * Sets the value of the packetsInUnicast property.
     * 
     */
    public void setPacketsInUnicast(long value) {
        this.packetsInUnicast = value;
    }

    /**
     * Gets the value of the packetsOutUnicast property.
     * 
     */
    public long getPacketsOutUnicast() {
        return packetsOutUnicast;
    }

    /**
     * Sets the value of the packetsOutUnicast property.
     * 
     */
    public void setPacketsOutUnicast(long value) {
        this.packetsOutUnicast = value;
    }

    /**
     * Gets the value of the bytesInUnicast property.
     * 
     */
    public long getBytesInUnicast() {
        return bytesInUnicast;
    }

    /**
     * Sets the value of the bytesInUnicast property.
     * 
     */
    public void setBytesInUnicast(long value) {
        this.bytesInUnicast = value;
    }

    /**
     * Gets the value of the bytesOutUnicast property.
     * 
     */
    public long getBytesOutUnicast() {
        return bytesOutUnicast;
    }

    /**
     * Sets the value of the bytesOutUnicast property.
     * 
     */
    public void setBytesOutUnicast(long value) {
        this.bytesOutUnicast = value;
    }

    /**
     * Gets the value of the packetsInBroadcast property.
     * 
     */
    public long getPacketsInBroadcast() {
        return packetsInBroadcast;
    }

    /**
     * Sets the value of the packetsInBroadcast property.
     * 
     */
    public void setPacketsInBroadcast(long value) {
        this.packetsInBroadcast = value;
    }

    /**
     * Gets the value of the packetsOutBroadcast property.
     * 
     */
    public long getPacketsOutBroadcast() {
        return packetsOutBroadcast;
    }

    /**
     * Sets the value of the packetsOutBroadcast property.
     * 
     */
    public void setPacketsOutBroadcast(long value) {
        this.packetsOutBroadcast = value;
    }

    /**
     * Gets the value of the bytesInBroadcast property.
     * 
     */
    public long getBytesInBroadcast() {
        return bytesInBroadcast;
    }

    /**
     * Sets the value of the bytesInBroadcast property.
     * 
     */
    public void setBytesInBroadcast(long value) {
        this.bytesInBroadcast = value;
    }

    /**
     * Gets the value of the bytesOutBroadcast property.
     * 
     */
    public long getBytesOutBroadcast() {
        return bytesOutBroadcast;
    }

    /**
     * Sets the value of the bytesOutBroadcast property.
     * 
     */
    public void setBytesOutBroadcast(long value) {
        this.bytesOutBroadcast = value;
    }

    /**
     * Gets the value of the packetsInDropped property.
     * 
     */
    public long getPacketsInDropped() {
        return packetsInDropped;
    }

    /**
     * Sets the value of the packetsInDropped property.
     * 
     */
    public void setPacketsInDropped(long value) {
        this.packetsInDropped = value;
    }

    /**
     * Gets the value of the packetsOutDropped property.
     * 
     */
    public long getPacketsOutDropped() {
        return packetsOutDropped;
    }

    /**
     * Sets the value of the packetsOutDropped property.
     * 
     */
    public void setPacketsOutDropped(long value) {
        this.packetsOutDropped = value;
    }

    /**
     * Gets the value of the packetsInException property.
     * 
     */
    public long getPacketsInException() {
        return packetsInException;
    }

    /**
     * Sets the value of the packetsInException property.
     * 
     */
    public void setPacketsInException(long value) {
        this.packetsInException = value;
    }

    /**
     * Gets the value of the packetsOutException property.
     * 
     */
    public long getPacketsOutException() {
        return packetsOutException;
    }

    /**
     * Sets the value of the packetsOutException property.
     * 
     */
    public void setPacketsOutException(long value) {
        this.packetsOutException = value;
    }

}
