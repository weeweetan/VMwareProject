
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StorageProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StorageProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ApplyProfile">
 *       &lt;sequence>
 *         &lt;element name="nasStorage" type="{urn:vim25}NasStorageProfile" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StorageProfile", propOrder = {
    "nasStorage"
})
public class StorageProfile
    extends ApplyProfile
{

    protected List<NasStorageProfile> nasStorage;

    /**
     * Gets the value of the nasStorage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nasStorage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNasStorage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NasStorageProfile }
     * 
     * 
     */
    public List<NasStorageProfile> getNasStorage() {
        if (nasStorage == null) {
            nasStorage = new ArrayList<NasStorageProfile>();
        }
        return this.nasStorage;
    }

}
