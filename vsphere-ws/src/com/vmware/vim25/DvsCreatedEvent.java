
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsCreatedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsCreatedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsEvent">
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
@XmlType(name = "DvsCreatedEvent", propOrder = {
    "parent"
})
public class DvsCreatedEvent
    extends DvsEvent
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
