
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="product" type="{urn:vim25}VAppProductSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="property" type="{urn:vim25}VAppPropertySpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipAssignment" type="{urn:vim25}VAppIPAssignmentInfo" minOccurs="0"/>
 *         &lt;element name="eula" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ovfSection" type="{urn:vim25}VAppOvfSectionSpec" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ovfEnvironmentTransport" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="installBootRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="installBootStopDelay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmConfigSpec", propOrder = {
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
    VAppConfigSpec.class
})
public class VmConfigSpec
    extends DynamicData
{

    protected List<VAppProductSpec> product;
    protected List<VAppPropertySpec> property;
    protected VAppIPAssignmentInfo ipAssignment;
    protected List<String> eula;
    protected List<VAppOvfSectionSpec> ovfSection;
    protected List<String> ovfEnvironmentTransport;
    protected Boolean installBootRequired;
    protected Integer installBootStopDelay;

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
     * {@link VAppProductSpec }
     * 
     * 
     */
    public List<VAppProductSpec> getProduct() {
        if (product == null) {
            product = new ArrayList<VAppProductSpec>();
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
     * {@link VAppPropertySpec }
     * 
     * 
     */
    public List<VAppPropertySpec> getProperty() {
        if (property == null) {
            property = new ArrayList<VAppPropertySpec>();
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
     * {@link VAppOvfSectionSpec }
     * 
     * 
     */
    public List<VAppOvfSectionSpec> getOvfSection() {
        if (ovfSection == null) {
            ovfSection = new ArrayList<VAppOvfSectionSpec>();
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
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInstallBootRequired() {
        return installBootRequired;
    }

    /**
     * Sets the value of the installBootRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInstallBootRequired(Boolean value) {
        this.installBootRequired = value;
    }

    /**
     * Gets the value of the installBootStopDelay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInstallBootStopDelay() {
        return installBootStopDelay;
    }

    /**
     * Sets the value of the installBootStopDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInstallBootStopDelay(Integer value) {
        this.installBootStopDelay = value;
    }

}
