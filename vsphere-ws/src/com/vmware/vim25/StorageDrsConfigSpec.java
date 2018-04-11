
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageDrsConfigSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageDrsConfigSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="podConfigSpec" type="{urn:vim25}StorageDrsPodConfigSpec" minOccurs="0"/>
 *         &lt;element name="vmConfigSpec" type="{urn:vim25}StorageDrsVmConfigSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageDrsConfigSpec", propOrder = {
    "podConfigSpec",
    "vmConfigSpec"
})
public class StorageDrsConfigSpec
    extends DynamicData
{

    protected StorageDrsPodConfigSpec podConfigSpec;
    protected List<StorageDrsVmConfigSpec> vmConfigSpec;

    /**
     * Gets the value of the podConfigSpec property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDrsPodConfigSpec }
     *     
     */
    public StorageDrsPodConfigSpec getPodConfigSpec() {
        return podConfigSpec;
    }

    /**
     * Sets the value of the podConfigSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDrsPodConfigSpec }
     *     
     */
    public void setPodConfigSpec(StorageDrsPodConfigSpec value) {
        this.podConfigSpec = value;
    }

    /**
     * Gets the value of the vmConfigSpec property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vmConfigSpec property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVmConfigSpec().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StorageDrsVmConfigSpec }
     * 
     * 
     */
    public List<StorageDrsVmConfigSpec> getVmConfigSpec() {
        if (vmConfigSpec == null) {
            vmConfigSpec = new ArrayList<StorageDrsVmConfigSpec>();
        }
        return this.vmConfigSpec;
    }

}
