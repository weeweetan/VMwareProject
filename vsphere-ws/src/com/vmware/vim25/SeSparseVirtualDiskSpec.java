
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SeSparseVirtualDiskSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SeSparseVirtualDiskSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}FileBackedVirtualDiskSpec">
 *       &lt;sequence>
 *         &lt;element name="grainSizeKb" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SeSparseVirtualDiskSpec", propOrder = {
    "grainSizeKb"
})
public class SeSparseVirtualDiskSpec
    extends FileBackedVirtualDiskSpec
{

    protected Integer grainSizeKb;

    /**
     * Gets the value of the grainSizeKb property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGrainSizeKb() {
        return grainSizeKb;
    }

    /**
     * Sets the value of the grainSizeKb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGrainSizeKb(Integer value) {
        this.grainSizeKb = value;
    }

}
