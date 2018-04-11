
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileExecuteResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileExecuteResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="configSpec" type="{urn:vim25}HostConfigSpec" minOccurs="0"/>
 *         &lt;element name="inapplicablePath" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requireInput" type="{urn:vim25}ProfileDeferredPolicyOptionParameter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="error" type="{urn:vim25}ProfileExecuteError" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileExecuteResult", propOrder = {
    "status",
    "configSpec",
    "inapplicablePath",
    "requireInput",
    "error"
})
public class ProfileExecuteResult
    extends DynamicData
{

    @XmlElement(required = true)
    protected String status;
    protected HostConfigSpec configSpec;
    protected List<String> inapplicablePath;
    protected List<ProfileDeferredPolicyOptionParameter> requireInput;
    protected List<ProfileExecuteError> error;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the configSpec property.
     * 
     * @return
     *     possible object is
     *     {@link HostConfigSpec }
     *     
     */
    public HostConfigSpec getConfigSpec() {
        return configSpec;
    }

    /**
     * Sets the value of the configSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostConfigSpec }
     *     
     */
    public void setConfigSpec(HostConfigSpec value) {
        this.configSpec = value;
    }

    /**
     * Gets the value of the inapplicablePath property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inapplicablePath property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInapplicablePath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInapplicablePath() {
        if (inapplicablePath == null) {
            inapplicablePath = new ArrayList<String>();
        }
        return this.inapplicablePath;
    }

    /**
     * Gets the value of the requireInput property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requireInput property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequireInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileDeferredPolicyOptionParameter }
     * 
     * 
     */
    public List<ProfileDeferredPolicyOptionParameter> getRequireInput() {
        if (requireInput == null) {
            requireInput = new ArrayList<ProfileDeferredPolicyOptionParameter>();
        }
        return this.requireInput;
    }

    /**
     * Gets the value of the error property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the error property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileExecuteError }
     * 
     * 
     */
    public List<ProfileExecuteError> getError() {
        if (error == null) {
            error = new ArrayList<ProfileExecuteError>();
        }
        return this.error;
    }

}
