
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultToleranceConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultToleranceConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="instanceUuids" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="configPaths" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultToleranceConfigInfo", propOrder = {
    "role",
    "instanceUuids",
    "configPaths"
})
@XmlSeeAlso({
    FaultTolerancePrimaryConfigInfo.class,
    FaultToleranceSecondaryConfigInfo.class
})
public class FaultToleranceConfigInfo
    extends DynamicData
{

    protected int role;
    @XmlElement(required = true)
    protected List<String> instanceUuids;
    @XmlElement(required = true)
    protected List<String> configPaths;

    /**
     * Gets the value of the role property.
     * 
     */
    public int getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     */
    public void setRole(int value) {
        this.role = value;
    }

    /**
     * Gets the value of the instanceUuids property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instanceUuids property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstanceUuids().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInstanceUuids() {
        if (instanceUuids == null) {
            instanceUuids = new ArrayList<String>();
        }
        return this.instanceUuids;
    }

    /**
     * Gets the value of the configPaths property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configPaths property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfigPaths().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConfigPaths() {
        if (configPaths == null) {
            configPaths = new ArrayList<String>();
        }
        return this.configPaths;
    }

}
