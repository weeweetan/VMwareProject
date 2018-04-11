
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmConfigFileQuery complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmConfigFileQuery">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}FileQuery">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{urn:vim25}VmConfigFileQueryFilter" minOccurs="0"/>
 *         &lt;element name="details" type="{urn:vim25}VmConfigFileQueryFlags" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmConfigFileQuery", propOrder = {
    "filter",
    "details"
})
@XmlSeeAlso({
    TemplateConfigFileQuery.class
})
public class VmConfigFileQuery
    extends FileQuery
{

    protected VmConfigFileQueryFilter filter;
    protected VmConfigFileQueryFlags details;

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link VmConfigFileQueryFilter }
     *     
     */
    public VmConfigFileQueryFilter getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmConfigFileQueryFilter }
     *     
     */
    public void setFilter(VmConfigFileQueryFilter value) {
        this.filter = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link VmConfigFileQueryFlags }
     *     
     */
    public VmConfigFileQueryFlags getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmConfigFileQueryFlags }
     *     
     */
    public void setDetails(VmConfigFileQueryFlags value) {
        this.details = value;
    }

}
