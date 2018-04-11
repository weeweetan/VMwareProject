
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostStorageElementInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostStorageElementInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostHardwareElementInfo">
 *       &lt;sequence>
 *         &lt;element name="operationalInfo" type="{urn:vim25}HostStorageOperationalInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostStorageElementInfo", propOrder = {
    "operationalInfo"
})
public class HostStorageElementInfo
    extends HostHardwareElementInfo
{

    protected List<HostStorageOperationalInfo> operationalInfo;

    /**
     * Gets the value of the operationalInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operationalInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperationalInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostStorageOperationalInfo }
     * 
     * 
     */
    public List<HostStorageOperationalInfo> getOperationalInfo() {
        if (operationalInfo == null) {
            operationalInfo = new ArrayList<HostStorageOperationalInfo>();
        }
        return this.operationalInfo;
    }

}
