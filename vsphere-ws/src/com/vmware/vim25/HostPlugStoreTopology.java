
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPlugStoreTopology complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostPlugStoreTopology">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="adapter" type="{urn:vim25}HostPlugStoreTopologyAdapter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="path" type="{urn:vim25}HostPlugStoreTopologyPath" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="target" type="{urn:vim25}HostPlugStoreTopologyTarget" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="device" type="{urn:vim25}HostPlugStoreTopologyDevice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="plugin" type="{urn:vim25}HostPlugStoreTopologyPlugin" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostPlugStoreTopology", propOrder = {
    "adapter",
    "path",
    "target",
    "device",
    "plugin"
})
public class HostPlugStoreTopology
    extends DynamicData
{

    protected List<HostPlugStoreTopologyAdapter> adapter;
    protected List<HostPlugStoreTopologyPath> path;
    protected List<HostPlugStoreTopologyTarget> target;
    protected List<HostPlugStoreTopologyDevice> device;
    protected List<HostPlugStoreTopologyPlugin> plugin;

    /**
     * Gets the value of the adapter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adapter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdapter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPlugStoreTopologyAdapter }
     * 
     * 
     */
    public List<HostPlugStoreTopologyAdapter> getAdapter() {
        if (adapter == null) {
            adapter = new ArrayList<HostPlugStoreTopologyAdapter>();
        }
        return this.adapter;
    }

    /**
     * Gets the value of the path property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the path property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPlugStoreTopologyPath }
     * 
     * 
     */
    public List<HostPlugStoreTopologyPath> getPath() {
        if (path == null) {
            path = new ArrayList<HostPlugStoreTopologyPath>();
        }
        return this.path;
    }

    /**
     * Gets the value of the target property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the target property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTarget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPlugStoreTopologyTarget }
     * 
     * 
     */
    public List<HostPlugStoreTopologyTarget> getTarget() {
        if (target == null) {
            target = new ArrayList<HostPlugStoreTopologyTarget>();
        }
        return this.target;
    }

    /**
     * Gets the value of the device property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPlugStoreTopologyDevice }
     * 
     * 
     */
    public List<HostPlugStoreTopologyDevice> getDevice() {
        if (device == null) {
            device = new ArrayList<HostPlugStoreTopologyDevice>();
        }
        return this.device;
    }

    /**
     * Gets the value of the plugin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plugin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlugin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostPlugStoreTopologyPlugin }
     * 
     * 
     */
    public List<HostPlugStoreTopologyPlugin> getPlugin() {
        if (plugin == null) {
            plugin = new ArrayList<HostPlugStoreTopologyPlugin>();
        }
        return this.plugin;
    }

}
