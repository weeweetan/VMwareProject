
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVPortgroupSelection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVPortgroupSelection">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}SelectionSet">
 *       &lt;sequence>
 *         &lt;element name="dvsUuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portgroupKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVPortgroupSelection", propOrder = {
    "dvsUuid",
    "portgroupKey"
})
public class DVPortgroupSelection
    extends SelectionSet
{

    @XmlElement(required = true)
    protected String dvsUuid;
    @XmlElement(required = true)
    protected List<String> portgroupKey;

    /**
     * Gets the value of the dvsUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDvsUuid() {
        return dvsUuid;
    }

    /**
     * Sets the value of the dvsUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDvsUuid(String value) {
        this.dvsUuid = value;
    }

    /**
     * Gets the value of the portgroupKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portgroupKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortgroupKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPortgroupKey() {
        if (portgroupKey == null) {
            portgroupKey = new ArrayList<String>();
        }
        return this.portgroupKey;
    }

}
