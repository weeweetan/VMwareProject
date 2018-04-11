
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSNetworkResourceManagementCapability complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSNetworkResourceManagementCapability">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="networkResourceManagementSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="networkResourcePoolHighShareValue" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="qosSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userDefinedNetworkResourcePoolsSupported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSNetworkResourceManagementCapability", propOrder = {
    "networkResourceManagementSupported",
    "networkResourcePoolHighShareValue",
    "qosSupported",
    "userDefinedNetworkResourcePoolsSupported"
})
public class DVSNetworkResourceManagementCapability
    extends DynamicData
{

    protected boolean networkResourceManagementSupported;
    protected int networkResourcePoolHighShareValue;
    protected boolean qosSupported;
    protected boolean userDefinedNetworkResourcePoolsSupported;

    /**
     * Gets the value of the networkResourceManagementSupported property.
     * 
     */
    public boolean isNetworkResourceManagementSupported() {
        return networkResourceManagementSupported;
    }

    /**
     * Sets the value of the networkResourceManagementSupported property.
     * 
     */
    public void setNetworkResourceManagementSupported(boolean value) {
        this.networkResourceManagementSupported = value;
    }

    /**
     * Gets the value of the networkResourcePoolHighShareValue property.
     * 
     */
    public int getNetworkResourcePoolHighShareValue() {
        return networkResourcePoolHighShareValue;
    }

    /**
     * Sets the value of the networkResourcePoolHighShareValue property.
     * 
     */
    public void setNetworkResourcePoolHighShareValue(int value) {
        this.networkResourcePoolHighShareValue = value;
    }

    /**
     * Gets the value of the qosSupported property.
     * 
     */
    public boolean isQosSupported() {
        return qosSupported;
    }

    /**
     * Sets the value of the qosSupported property.
     * 
     */
    public void setQosSupported(boolean value) {
        this.qosSupported = value;
    }

    /**
     * Gets the value of the userDefinedNetworkResourcePoolsSupported property.
     * 
     */
    public boolean isUserDefinedNetworkResourcePoolsSupported() {
        return userDefinedNetworkResourcePoolsSupported;
    }

    /**
     * Sets the value of the userDefinedNetworkResourcePoolsSupported property.
     * 
     */
    public void setUserDefinedNetworkResourcePoolsSupported(boolean value) {
        this.userDefinedNetworkResourcePoolsSupported = value;
    }

}
