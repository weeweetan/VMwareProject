
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatchNotApplicable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatchNotApplicable">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *         &lt;element name="patchID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatchNotApplicable", propOrder = {
    "patchID"
})
@XmlSeeAlso({
    PatchMissingDependencies.class,
    PatchSuperseded.class,
    PatchAlreadyInstalled.class
})
public class PatchNotApplicable
    extends VimFault
{

    @XmlElement(required = true)
    protected String patchID;

    /**
     * Gets the value of the patchID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatchID() {
        return patchID;
    }

    /**
     * Sets the value of the patchID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatchID(String value) {
        this.patchID = value;
    }

}
