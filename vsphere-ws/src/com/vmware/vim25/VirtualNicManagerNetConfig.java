
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualNicManagerNetConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualNicManagerNetConfig">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="nicType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="multiSelectAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="candidateVnic" type="{urn:vim25}HostVirtualNic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="selectedVnic" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualNicManagerNetConfig", propOrder = {
    "nicType",
    "multiSelectAllowed",
    "candidateVnic",
    "selectedVnic"
})
public class VirtualNicManagerNetConfig
    extends DynamicData
{

    @XmlElement(required = true)
    protected String nicType;
    protected boolean multiSelectAllowed;
    protected List<HostVirtualNic> candidateVnic;
    protected List<String> selectedVnic;

    /**
     * Gets the value of the nicType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNicType() {
        return nicType;
    }

    /**
     * Sets the value of the nicType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNicType(String value) {
        this.nicType = value;
    }

    /**
     * Gets the value of the multiSelectAllowed property.
     * 
     */
    public boolean isMultiSelectAllowed() {
        return multiSelectAllowed;
    }

    /**
     * Sets the value of the multiSelectAllowed property.
     * 
     */
    public void setMultiSelectAllowed(boolean value) {
        this.multiSelectAllowed = value;
    }

    /**
     * Gets the value of the candidateVnic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the candidateVnic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCandidateVnic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVirtualNic }
     * 
     * 
     */
    public List<HostVirtualNic> getCandidateVnic() {
        if (candidateVnic == null) {
            candidateVnic = new ArrayList<HostVirtualNic>();
        }
        return this.candidateVnic;
    }

    /**
     * Gets the value of the selectedVnic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectedVnic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectedVnic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSelectedVnic() {
        if (selectedVnic == null) {
            selectedVnic = new ArrayList<String>();
        }
        return this.selectedVnic;
    }

}
