
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostForceMountedInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostForceMountedInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="persist" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="mounted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostForceMountedInfo", propOrder = {
    "persist",
    "mounted"
})
public class HostForceMountedInfo
    extends DynamicData
{

    protected boolean persist;
    protected boolean mounted;

    /**
     * Gets the value of the persist property.
     * 
     */
    public boolean isPersist() {
        return persist;
    }

    /**
     * Sets the value of the persist property.
     * 
     */
    public void setPersist(boolean value) {
        this.persist = value;
    }

    /**
     * Gets the value of the mounted property.
     * 
     */
    public boolean isMounted() {
        return mounted;
    }

    /**
     * Sets the value of the mounted property.
     * 
     */
    public void setMounted(boolean value) {
        this.mounted = value;
    }

}
