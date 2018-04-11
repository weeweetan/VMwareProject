
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVMwareDVSVspanConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVMwareDVSVspanConfigSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VMwareDVSVspanConfigSpec" type="{urn:vim25}VMwareDVSVspanConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVMwareDVSVspanConfigSpec", propOrder = {
    "vMwareDVSVspanConfigSpec"
})
public class ArrayOfVMwareDVSVspanConfigSpec {

    @XmlElement(name = "VMwareDVSVspanConfigSpec")
    protected List<VMwareDVSVspanConfigSpec> vMwareDVSVspanConfigSpec;

    /**
     * Gets the value of the vMwareDVSVspanConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vMwareDVSVspanConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVMwareDVSVspanConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VMwareDVSVspanConfigSpec }
     * 
     * 
     */
    public List<VMwareDVSVspanConfigSpec> getVMwareDVSVspanConfigSpec() {
        if (vMwareDVSVspanConfigSpec == null) {
            vMwareDVSVspanConfigSpec = new ArrayList<VMwareDVSVspanConfigSpec>();
        }
        return this.vMwareDVSVspanConfigSpec;
    }

}
