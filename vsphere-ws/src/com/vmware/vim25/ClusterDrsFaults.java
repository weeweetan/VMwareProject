
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterDrsFaults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterDrsFaults">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="faultsByVm" type="{urn:vim25}ClusterDrsFaultsFaultsByVm" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterDrsFaults", propOrder = {
    "reason",
    "faultsByVm"
})
public class ClusterDrsFaults
    extends DynamicData
{

    @XmlElement(required = true)
    protected String reason;
    @XmlElement(required = true)
    protected List<ClusterDrsFaultsFaultsByVm> faultsByVm;

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the faultsByVm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faultsByVm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaultsByVm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClusterDrsFaultsFaultsByVm }
     * 
     * 
     */
    public List<ClusterDrsFaultsFaultsByVm> getFaultsByVm() {
        if (faultsByVm == null) {
            faultsByVm = new ArrayList<ClusterDrsFaultsFaultsByVm>();
        }
        return this.faultsByVm;
    }

}
