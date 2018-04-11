
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmDiskFileQueryFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmDiskFileQueryFilter">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="diskType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="matchHardwareVersion" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="controllerType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="thin" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmDiskFileQueryFilter", propOrder = {
    "diskType",
    "matchHardwareVersion",
    "controllerType",
    "thin"
})
public class VmDiskFileQueryFilter
    extends DynamicData
{

    protected List<String> diskType;
    @XmlElement(type = Integer.class)
    protected List<Integer> matchHardwareVersion;
    protected List<String> controllerType;
    protected Boolean thin;

    /**
     * Gets the value of the diskType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diskType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiskType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDiskType() {
        if (diskType == null) {
            diskType = new ArrayList<String>();
        }
        return this.diskType;
    }

    /**
     * Gets the value of the matchHardwareVersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matchHardwareVersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchHardwareVersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getMatchHardwareVersion() {
        if (matchHardwareVersion == null) {
            matchHardwareVersion = new ArrayList<Integer>();
        }
        return this.matchHardwareVersion;
    }

    /**
     * Gets the value of the controllerType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controllerType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControllerType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getControllerType() {
        if (controllerType == null) {
            controllerType = new ArrayList<String>();
        }
        return this.controllerType;
    }

    /**
     * Gets the value of the thin property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isThin() {
        return thin;
    }

    /**
     * Sets the value of the thin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setThin(Boolean value) {
        this.thin = value;
    }

}
