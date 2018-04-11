
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfStorageDrsVmConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfStorageDrsVmConfigInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StorageDrsVmConfigInfo" type="{urn:vim25}StorageDrsVmConfigInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfStorageDrsVmConfigInfo", propOrder = {
    "storageDrsVmConfigInfo"
})
public class ArrayOfStorageDrsVmConfigInfo {

    @XmlElement(name = "StorageDrsVmConfigInfo")
    protected List<StorageDrsVmConfigInfo> storageDrsVmConfigInfo;

    /**
     * Gets the value of the storageDrsVmConfigInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storageDrsVmConfigInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStorageDrsVmConfigInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StorageDrsVmConfigInfo }
     * 
     * 
     */
    public List<StorageDrsVmConfigInfo> getStorageDrsVmConfigInfo() {
        if (storageDrsVmConfigInfo == null) {
            storageDrsVmConfigInfo = new ArrayList<StorageDrsVmConfigInfo>();
        }
        return this.storageDrsVmConfigInfo;
    }

}
