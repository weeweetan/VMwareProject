
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfNetIpRouteConfigInfoIpRoute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfNetIpRouteConfigInfoIpRoute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NetIpRouteConfigInfoIpRoute" type="{urn:vim25}NetIpRouteConfigInfoIpRoute" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfNetIpRouteConfigInfoIpRoute", propOrder = {
    "netIpRouteConfigInfoIpRoute"
})
public class ArrayOfNetIpRouteConfigInfoIpRoute {

    @XmlElement(name = "NetIpRouteConfigInfoIpRoute")
    protected List<NetIpRouteConfigInfoIpRoute> netIpRouteConfigInfoIpRoute;

    /**
     * Gets the value of the netIpRouteConfigInfoIpRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netIpRouteConfigInfoIpRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetIpRouteConfigInfoIpRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetIpRouteConfigInfoIpRoute }
     * 
     * 
     */
    public List<NetIpRouteConfigInfoIpRoute> getNetIpRouteConfigInfoIpRoute() {
        if (netIpRouteConfigInfoIpRoute == null) {
            netIpRouteConfigInfoIpRoute = new ArrayList<NetIpRouteConfigInfoIpRoute>();
        }
        return this.netIpRouteConfigInfoIpRoute;
    }

}
