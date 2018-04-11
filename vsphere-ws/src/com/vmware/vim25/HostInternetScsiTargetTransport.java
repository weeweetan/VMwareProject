
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostInternetScsiTargetTransport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostInternetScsiTargetTransport">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostTargetTransport">
 *       &lt;sequence>
 *         &lt;element name="iScsiName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iScsiAlias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostInternetScsiTargetTransport", propOrder = {
    "iScsiName",
    "iScsiAlias",
    "address"
})
public class HostInternetScsiTargetTransport
    extends HostTargetTransport
{

    @XmlElement(required = true)
    protected String iScsiName;
    @XmlElement(required = true)
    protected String iScsiAlias;
    protected List<String> address;

    /**
     * Gets the value of the iScsiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIScsiName() {
        return iScsiName;
    }

    /**
     * Sets the value of the iScsiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIScsiName(String value) {
        this.iScsiName = value;
    }

    /**
     * Gets the value of the iScsiAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIScsiAlias() {
        return iScsiAlias;
    }

    /**
     * Sets the value of the iScsiAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIScsiAlias(String value) {
        this.iScsiAlias = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddress() {
        if (address == null) {
            address = new ArrayList<String>();
        }
        return this.address;
    }

}
