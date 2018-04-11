
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VAppIPAssignmentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VAppIPAssignmentInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="supportedAllocationScheme" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipAllocationPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supportedIpProtocol" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipProtocol" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VAppIPAssignmentInfo", propOrder = {
    "supportedAllocationScheme",
    "ipAllocationPolicy",
    "supportedIpProtocol",
    "ipProtocol"
})
public class VAppIPAssignmentInfo
    extends DynamicData
{

    protected List<String> supportedAllocationScheme;
    protected String ipAllocationPolicy;
    protected List<String> supportedIpProtocol;
    protected String ipProtocol;

    /**
     * Gets the value of the supportedAllocationScheme property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedAllocationScheme property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedAllocationScheme().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedAllocationScheme() {
        if (supportedAllocationScheme == null) {
            supportedAllocationScheme = new ArrayList<String>();
        }
        return this.supportedAllocationScheme;
    }

    /**
     * Gets the value of the ipAllocationPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAllocationPolicy() {
        return ipAllocationPolicy;
    }

    /**
     * Sets the value of the ipAllocationPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAllocationPolicy(String value) {
        this.ipAllocationPolicy = value;
    }

    /**
     * Gets the value of the supportedIpProtocol property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportedIpProtocol property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportedIpProtocol().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSupportedIpProtocol() {
        if (supportedIpProtocol == null) {
            supportedIpProtocol = new ArrayList<String>();
        }
        return this.supportedIpProtocol;
    }

    /**
     * Gets the value of the ipProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpProtocol() {
        return ipProtocol;
    }

    /**
     * Sets the value of the ipProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpProtocol(String value) {
        this.ipProtocol = value;
    }

}
