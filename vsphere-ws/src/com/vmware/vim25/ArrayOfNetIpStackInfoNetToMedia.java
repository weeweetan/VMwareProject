
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNetIpStackInfoNetToMedia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNetIpStackInfoNetToMedia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NetIpStackInfoNetToMedia" type="{urn:vim25}NetIpStackInfoNetToMedia" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNetIpStackInfoNetToMedia", propOrder = {
    "netIpStackInfoNetToMedia"
})
public class ArrayOfNetIpStackInfoNetToMedia {

    @XmlElement(name = "NetIpStackInfoNetToMedia")
    protected List<NetIpStackInfoNetToMedia> netIpStackInfoNetToMedia;

    /**
     * Gets the value of the netIpStackInfoNetToMedia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netIpStackInfoNetToMedia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetIpStackInfoNetToMedia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetIpStackInfoNetToMedia }
     * 
     * 
     */
    public List<NetIpStackInfoNetToMedia> getNetIpStackInfoNetToMedia() {
        if (netIpStackInfoNetToMedia == null) {
            netIpStackInfoNetToMedia = new ArrayList<NetIpStackInfoNetToMedia>();
        }
        return this.netIpStackInfoNetToMedia;
    }

}
