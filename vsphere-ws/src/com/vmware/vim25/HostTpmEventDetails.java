
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostTpmEventDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostTpmEventDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="dataHash" type="{http://www.w3.org/2001/XMLSchema}byte" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostTpmEventDetails", propOrder = {
    "dataHash"
})
@XmlSeeAlso({
    HostTpmCommandEventDetails.class,
    HostTpmOptionEventDetails.class,
    HostTpmBootSecurityOptionEventDetails.class,
    HostTpmSoftwareComponentEventDetails.class
})
public class HostTpmEventDetails
    extends DynamicData
{

    @XmlElement(type = Byte.class)
    protected List<Byte> dataHash;

    /**
     * Gets the value of the dataHash property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataHash property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataHash().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Byte }
     * 
     * 
     */
    public List<Byte> getDataHash() {
        if (dataHash == null) {
            dataHash = new ArrayList<Byte>();
        }
        return this.dataHash;
    }

}
