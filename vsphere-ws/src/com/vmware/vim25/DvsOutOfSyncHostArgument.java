
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsOutOfSyncHostArgument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsOutOfSyncHostArgument">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="outOfSyncHost" type="{urn:vim25}HostEventArgument"/>
 *         &lt;element name="configParamters" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsOutOfSyncHostArgument", propOrder = {
    "outOfSyncHost",
    "configParamters"
})
public class DvsOutOfSyncHostArgument
    extends DynamicData
{

    @XmlElement(required = true)
    protected HostEventArgument outOfSyncHost;
    @XmlElement(required = true)
    protected List<String> configParamters;

    /**
     * Gets the value of the outOfSyncHost property.
     * 
     * @return
     *     possible object is
     *     {@link HostEventArgument }
     *     
     */
    public HostEventArgument getOutOfSyncHost() {
        return outOfSyncHost;
    }

    /**
     * Sets the value of the outOfSyncHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostEventArgument }
     *     
     */
    public void setOutOfSyncHost(HostEventArgument value) {
        this.outOfSyncHost = value;
    }

    /**
     * Gets the value of the configParamters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configParamters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfigParamters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConfigParamters() {
        if (configParamters == null) {
            configParamters = new ArrayList<String>();
        }
        return this.configParamters;
    }

}
