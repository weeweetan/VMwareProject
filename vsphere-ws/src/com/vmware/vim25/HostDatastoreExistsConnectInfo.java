
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDatastoreExistsConnectInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDatastoreExistsConnectInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostDatastoreConnectInfo">
 *       &lt;sequence>
 *         &lt;element name="newDatastoreName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDatastoreExistsConnectInfo", propOrder = {
    "newDatastoreName"
})
public class HostDatastoreExistsConnectInfo
    extends HostDatastoreConnectInfo
{

    @XmlElement(required = true)
    protected String newDatastoreName;

    /**
     * Gets the value of the newDatastoreName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDatastoreName() {
        return newDatastoreName;
    }

    /**
     * Sets the value of the newDatastoreName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDatastoreName(String value) {
        this.newDatastoreName = value;
    }

}
