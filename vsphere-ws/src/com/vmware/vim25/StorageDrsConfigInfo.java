
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="podConfig" type="{urn:vim25}StorageDrsPodConfigInfo"/>
 *         &lt;element name="vmConfig" type="{urn:vim25}StorageDrsVmConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsConfigInfo", propOrder = {
    "podConfig",
    "vmConfig"
})
public class StorageDrsConfigInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected StorageDrsPodConfigInfo podConfig;
    protected List<StorageDrsVmConfigInfo> vmConfig;

    /**
     * Gets the value of the podConfig property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDrsPodConfigInfo }
     *     
     */
    public StorageDrsPodConfigInfo getPodConfig() {
        return podConfig;
    }

    /**
     * Sets the value of the podConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDrsPodConfigInfo }
     *     
     */
    public void setPodConfig(StorageDrsPodConfigInfo value) {
        this.podConfig = value;
    }

    /**
     * Gets the value of the vmConfig property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmConfig property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmConfig().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StorageDrsVmConfigInfo }
     * 
     * 
     */
    public List<StorageDrsVmConfigInfo> getVmConfig() {
        if (vmConfig == null) {
            vmConfig = new ArrayList<StorageDrsVmConfigInfo>();
        }
        return this.vmConfig;
    }

}
