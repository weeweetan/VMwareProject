
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GuestFileAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestFileAttributes">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="modificationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="accessTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="symlinkTarget" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestFileAttributes", propOrder = {
    "modificationTime",
    "accessTime",
    "symlinkTarget"
})
@XmlSeeAlso({
    GuestWindowsFileAttributes.class,
    GuestPosixFileAttributes.class
})
public class GuestFileAttributes
    extends DynamicData
{

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modificationTime;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar accessTime;
    protected String symlinkTarget;

    /**
     * Gets the value of the modificationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getModificationTime() {
        return modificationTime;
    }

    /**
     * Sets the value of the modificationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setModificationTime(XMLGregorianCalendar value) {
        this.modificationTime = value;
    }

    /**
     * Gets the value of the accessTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccessTime() {
        return accessTime;
    }

    /**
     * Sets the value of the accessTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccessTime(XMLGregorianCalendar value) {
        this.accessTime = value;
    }

    /**
     * Gets the value of the symlinkTarget property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymlinkTarget() {
        return symlinkTarget;
    }

    /**
     * Sets the value of the symlinkTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymlinkTarget(String value) {
        this.symlinkTarget = value;
    }

}
