
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNetIpRouteConfigSpecIpRouteSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNetIpRouteConfigSpecIpRouteSpec">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NetIpRouteConfigSpecIpRouteSpec" type="{urn:vim25}NetIpRouteConfigSpecIpRouteSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNetIpRouteConfigSpecIpRouteSpec", propOrder = {
    "netIpRouteConfigSpecIpRouteSpec"
})
public class ArrayOfNetIpRouteConfigSpecIpRouteSpec {

    @XmlElement(name = "NetIpRouteConfigSpecIpRouteSpec")
    protected List<NetIpRouteConfigSpecIpRouteSpec> netIpRouteConfigSpecIpRouteSpec;

    /**
     * Gets the value of the netIpRouteConfigSpecIpRouteSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netIpRouteConfigSpecIpRouteSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetIpRouteConfigSpecIpRouteSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetIpRouteConfigSpecIpRouteSpec }
     * 
     * 
     */
    public List<NetIpRouteConfigSpecIpRouteSpec> getNetIpRouteConfigSpecIpRouteSpec() {
        if (netIpRouteConfigSpecIpRouteSpec == null) {
            netIpRouteConfigSpecIpRouteSpec = new ArrayList<NetIpRouteConfigSpecIpRouteSpec>();
        }
        return this.netIpRouteConfigSpecIpRouteSpec;
    }

}
