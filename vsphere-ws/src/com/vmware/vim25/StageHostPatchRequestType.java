
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StageHostPatchRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StageHostPatchRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="metaUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bundleUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vibUrls" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="spec" type="{urn:vim25}HostPatchManagerPatchManagerOperationSpec" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StageHostPatchRequestType", propOrder = {
    "_this",
    "metaUrls",
    "bundleUrls",
    "vibUrls",
    "spec"
})
public class StageHostPatchRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    protected List<String> metaUrls;
    protected List<String> bundleUrls;
    protected List<String> vibUrls;
    protected HostPatchManagerPatchManagerOperationSpec spec;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setThis(ManagedObjectReference value) {
        this._this = value;
    }

    /**
     * Gets the value of the metaUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMetaUrls() {
        if (metaUrls == null) {
            metaUrls = new ArrayList<String>();
        }
        return this.metaUrls;
    }

    /**
     * Gets the value of the bundleUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bundleUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBundleUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBundleUrls() {
        if (bundleUrls == null) {
            bundleUrls = new ArrayList<String>();
        }
        return this.bundleUrls;
    }

    /**
     * Gets the value of the vibUrls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vibUrls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVibUrls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVibUrls() {
        if (vibUrls == null) {
            vibUrls = new ArrayList<String>();
        }
        return this.vibUrls;
    }

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link HostPatchManagerPatchManagerOperationSpec }
     *     
     */
    public HostPatchManagerPatchManagerOperationSpec getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostPatchManagerPatchManagerOperationSpec }
     *     
     */
    public void setSpec(HostPatchManagerPatchManagerOperationSpec value) {
        this.spec = value;
    }

}
