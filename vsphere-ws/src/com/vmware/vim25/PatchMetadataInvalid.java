
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatchMetadataInvalid complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatchMetadataInvalid">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *         &lt;element name="patchID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="metaData" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatchMetadataInvalid", propOrder = {
    "patchID",
    "metaData"
})
@XmlSeeAlso({
    PatchMetadataNotFound.class,
    PatchMetadataCorrupted.class
})
public class PatchMetadataInvalid
    extends VimFault
{

    @XmlElement(required = true)
    protected String patchID;
    protected List<String> metaData;

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

    /**
     * Gets the value of the metaData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metaData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetaData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMetaData() {
        if (metaData == null) {
            metaData = new ArrayList<String>();
        }
        return this.metaData;
    }

}
