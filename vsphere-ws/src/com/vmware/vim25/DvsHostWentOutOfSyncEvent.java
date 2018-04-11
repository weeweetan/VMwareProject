
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsHostWentOutOfSyncEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsHostWentOutOfSyncEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsEvent">
 *       &lt;sequence>
 *         &lt;element name="hostOutOfSync" type="{urn:vim25}DvsOutOfSyncHostArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsHostWentOutOfSyncEvent", propOrder = {
    "hostOutOfSync"
})
public class DvsHostWentOutOfSyncEvent
    extends DvsEvent
{

    @XmlElement(required = true)
    protected DvsOutOfSyncHostArgument hostOutOfSync;

    /**
     * Gets the value of the hostOutOfSync property.
     * 
     * @return
     *     possible object is
     *     {@link DvsOutOfSyncHostArgument }
     *     
     */
    public DvsOutOfSyncHostArgument getHostOutOfSync() {
        return hostOutOfSync;
    }

    /**
     * Sets the value of the hostOutOfSync property.
     * 
     * @param value
     *     allowed object is
     *     {@link DvsOutOfSyncHostArgument }
     *     
     */
    public void setHostOutOfSync(DvsOutOfSyncHostArgument value) {
        this.hostOutOfSync = value;
    }

}
