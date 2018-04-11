
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConnectedIso complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConnectedIso">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OvfExport">
 *       &lt;sequence>
 *         &lt;element name="cdrom" type="{urn:vim25}VirtualCdrom"/>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConnectedIso", propOrder = {
    "cdrom",
    "filename"
})
public class ConnectedIso
    extends OvfExport
{

    @XmlElement(required = true)
    protected VirtualCdrom cdrom;
    @XmlElement(required = true)
    protected String filename;

    /**
     * Gets the value of the cdrom property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualCdrom }
     *     
     */
    public VirtualCdrom getCdrom() {
        return cdrom;
    }

    /**
     * Sets the value of the cdrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualCdrom }
     *     
     */
    public void setCdrom(VirtualCdrom value) {
        this.cdrom = value;
    }

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

}
