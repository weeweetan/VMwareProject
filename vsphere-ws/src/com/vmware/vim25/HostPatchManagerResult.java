
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPatchManagerResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostPatchManagerResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{urn:vim25}HostPatchManagerStatus" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="xmlResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostPatchManagerResult", propOrder = {
    "version",
    "status",
    "xmlResult"
})
public class HostPatchManagerResult
    extends DynamicData
{

    @XmlElement(required = true)
    protected String version;
    protected List<HostPatchManagerStatus> status;
    protected String xmlResult;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the status property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPatchManagerStatus }
     * 
     * 
     */
    public List<HostPatchManagerStatus> getStatus() {
        if (status == null) {
            status = new ArrayList<HostPatchManagerStatus>();
        }
        return this.status;
    }

    /**
     * Gets the value of the xmlResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlResult() {
        return xmlResult;
    }

    /**
     * Sets the value of the xmlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlResult(String value) {
        this.xmlResult = value;
    }

}
