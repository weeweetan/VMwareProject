
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetIpStackInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NetIpStackInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="neighbor" type="{urn:vim25}NetIpStackInfoNetToMedia" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultRouter" type="{urn:vim25}NetIpStackInfoDefaultRouter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetIpStackInfo", propOrder = {
    "neighbor",
    "defaultRouter"
})
public class NetIpStackInfo
    extends DynamicData
{

    protected List<NetIpStackInfoNetToMedia> neighbor;
    protected List<NetIpStackInfoDefaultRouter> defaultRouter;

    /**
     * Gets the value of the neighbor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the neighbor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNeighbor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetIpStackInfoNetToMedia }
     * 
     * 
     */
    public List<NetIpStackInfoNetToMedia> getNeighbor() {
        if (neighbor == null) {
            neighbor = new ArrayList<NetIpStackInfoNetToMedia>();
        }
        return this.neighbor;
    }

    /**
     * Gets the value of the defaultRouter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the defaultRouter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefaultRouter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NetIpStackInfoDefaultRouter }
     * 
     * 
     */
    public List<NetIpStackInfoDefaultRouter> getDefaultRouter() {
        if (defaultRouter == null) {
            defaultRouter = new ArrayList<NetIpStackInfoDefaultRouter>();
        }
        return this.defaultRouter;
    }

}
