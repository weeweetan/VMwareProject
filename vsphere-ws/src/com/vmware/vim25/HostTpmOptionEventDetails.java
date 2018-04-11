
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostTpmOptionEventDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostTpmOptionEventDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostTpmEventDetails">
 *       &lt;sequence>
 *         &lt;element name="optionsFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bootOptions" type="{http://www.w3.org/2001/XMLSchema}byte" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostTpmOptionEventDetails", propOrder = {
    "optionsFileName",
    "bootOptions"
})
public class HostTpmOptionEventDetails
    extends HostTpmEventDetails
{

    @XmlElement(required = true)
    protected String optionsFileName;
    @XmlElement(type = Byte.class)
    protected List<Byte> bootOptions;

    /**
     * Gets the value of the optionsFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionsFileName() {
        return optionsFileName;
    }

    /**
     * Sets the value of the optionsFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionsFileName(String value) {
        this.optionsFileName = value;
    }

    /**
     * Gets the value of the bootOptions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bootOptions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBootOptions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getBootOptions() {
        if (bootOptions == null) {
            bootOptions = new ArrayList<Byte>();
        }
        return this.bootOptions;
    }

}
