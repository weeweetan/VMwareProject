
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatacenterCreatedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatacenterCreatedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DatacenterEvent">
 *       &lt;sequence>
 *         &lt;element name="parent" type="{urn:vim25}FolderEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatacenterCreatedEvent", propOrder = {
    "parent"
})
public class DatacenterCreatedEvent
    extends DatacenterEvent
{

    @XmlElement(required = true)
    protected FolderEventArgument parent;

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link FolderEventArgument }
     *     
     */
    public FolderEventArgument getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link FolderEventArgument }
     *     
     */
    public void setParent(FolderEventArgument value) {
        this.parent = value;
    }

}
