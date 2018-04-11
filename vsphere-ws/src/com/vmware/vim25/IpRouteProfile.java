
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IpRouteProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IpRouteProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ApplyProfile">
 *       &lt;sequence>
 *         &lt;element name="staticRoute" type="{urn:vim25}StaticRouteProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IpRouteProfile", propOrder = {
    "staticRoute"
})
public class IpRouteProfile
    extends ApplyProfile
{

    protected List<StaticRouteProfile> staticRoute;

    /**
     * Gets the value of the staticRoute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staticRoute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaticRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaticRouteProfile }
     * 
     * 
     */
    public List<StaticRouteProfile> getStaticRoute() {
        if (staticRoute == null) {
            staticRoute = new ArrayList<StaticRouteProfile>();
        }
        return this.staticRoute;
    }

}
