
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostSystemSwapConfigurationDatastoreOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostSystemSwapConfigurationDatastoreOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostSystemSwapConfigurationSystemSwapOption">
 *       &lt;sequence>
 *         &lt;element name="datastore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostSystemSwapConfigurationDatastoreOption", propOrder = {
    "datastore"
})
public class HostSystemSwapConfigurationDatastoreOption
    extends HostSystemSwapConfigurationSystemSwapOption
{

    @XmlElement(required = true)
    protected String datastore;

    /**
     * Gets the value of the datastore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatastore() {
        return datastore;
    }

    /**
     * Sets the value of the datastore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatastore(String value) {
        this.datastore = value;
    }

}
