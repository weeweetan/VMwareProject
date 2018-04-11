
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDasDataSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterDasDataSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterDasData">
 *       &lt;sequence>
 *         &lt;element name="hostListVersion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="clusterConfigVersion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="compatListVersion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterDasDataSummary", propOrder = {
    "hostListVersion",
    "clusterConfigVersion",
    "compatListVersion"
})
public class ClusterDasDataSummary
    extends ClusterDasData
{

    protected long hostListVersion;
    protected long clusterConfigVersion;
    protected long compatListVersion;

    /**
     * Gets the value of the hostListVersion property.
     * 
     */
    public long getHostListVersion() {
        return hostListVersion;
    }

    /**
     * Sets the value of the hostListVersion property.
     * 
     */
    public void setHostListVersion(long value) {
        this.hostListVersion = value;
    }

    /**
     * Gets the value of the clusterConfigVersion property.
     * 
     */
    public long getClusterConfigVersion() {
        return clusterConfigVersion;
    }

    /**
     * Sets the value of the clusterConfigVersion property.
     * 
     */
    public void setClusterConfigVersion(long value) {
        this.clusterConfigVersion = value;
    }

    /**
     * Gets the value of the compatListVersion property.
     * 
     */
    public long getCompatListVersion() {
        return compatListVersion;
    }

    /**
     * Sets the value of the compatListVersion property.
     * 
     */
    public void setCompatListVersion(long value) {
        this.compatListVersion = value;
    }

}
