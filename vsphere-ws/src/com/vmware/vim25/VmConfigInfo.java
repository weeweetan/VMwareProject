
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="product" type="{urn:vim25}VAppProductInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="property" type="{urn:vim25}VAppPropertyInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipAssignment" type="{urn:vim25}VAppIPAssignmentInfo"/>
 *         &lt;element name="eula" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ovfSection" type="{urn:vim25}VAppOvfSectionInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ovfEnvironmentTransport" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="installBootRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="installBootStopDelay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmConfigInfo", propOrder = {
    "product",
    "property",
    "ipAssignment",
    "eula",
    "ovfSection",
    "ovfEnvironmentTransport",
    "installBootRequired",
    "installBootStopDelay"
})
@XmlSeeAlso({
    VAppConfigInfo.class
})
public class VmConfigInfo
    extends DynamicData
{

    protected List<VAppProductInfo> product;
    protected List<VAppPropertyInfo> property;
    @XmlElement(required = true)
    protected VAppIPAssignmentInfo ipAssignment;
    protected List<String> eula;
    protected List<VAppOvfSectionInfo> ovfSection;
    protected List<String> ovfEnvironmentTransport;
    protected boolean installBootRequired;
    protected int installBootStopDelay;

    /**
     * Gets the value of the product property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the product property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProduct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppProductInfo }
     * 
     * 
     */
    public List<VAppProductInfo> getProduct() {
        if (product == null) {
            product = new ArrayList<VAppProductInfo>();
        }
        return this.product;
    }

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppPropertyInfo }
     * 
     * 
     */
    public List<VAppPropertyInfo> getProperty() {
        if (property == null) {
            property = new ArrayList<VAppPropertyInfo>();
        }
        return this.property;
    }

    /**
     * Gets the value of the ipAssignment property.
     * 
     * @return
     *     possible object is
     *     {@link VAppIPAssignmentInfo }
     *     
     */
    public VAppIPAssignmentInfo getIpAssignment() {
        return ipAssignment;
    }

    /**
     * Sets the value of the ipAssignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link VAppIPAssignmentInfo }
     *     
     */
    public void setIpAssignment(VAppIPAssignmentInfo value) {
        this.ipAssignment = value;
    }

    /**
     * Gets the value of the eula property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eula property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEula().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEula() {
        if (eula == null) {
            eula = new ArrayList<String>();
        }
        return this.eula;
    }

    /**
     * Gets the value of the ovfSection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ovfSection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOvfSection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VAppOvfSectionInfo }
     * 
     * 
     */
    public List<VAppOvfSectionInfo> getOvfSection() {
        if (ovfSection == null) {
            ovfSection = new ArrayList<VAppOvfSectionInfo>();
        }
        return this.ovfSection;
    }

    /**
     * Gets the value of the ovfEnvironmentTransport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ovfEnvironmentTransport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOvfEnvironmentTransport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOvfEnvironmentTransport() {
        if (ovfEnvironmentTransport == null) {
            ovfEnvironmentTransport = new ArrayList<String>();
        }
        return this.ovfEnvironmentTransport;
    }

    /**
     * Gets the value of the installBootRequired property.
     * 
     */
    public boolean isInstallBootRequired() {
        return installBootRequired;
    }

    /**
     * Sets the value of the installBootRequired property.
     * 
     */
    public void setInstallBootRequired(boolean value) {
        this.installBootRequired = value;
    }

    /**
     * Gets the value of the installBootStopDelay property.
     * 
     */
    public int getInstallBootStopDelay() {
        return installBootStopDelay;
    }

    /**
     * Sets the value of the installBootStopDelay property.
     * 
     */
    public void setInstallBootStopDelay(int value) {
        this.installBootStopDelay = value;
    }

}
