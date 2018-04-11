
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostMultipathInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostMultipathInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="lun" type="{urn:vim25}HostMultipathInfoLogicalUnit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostMultipathInfo", propOrder = {
    "lun"
})
public class HostMultipathInfo
    extends DynamicData
{

    protected List<HostMultipathInfoLogicalUnit> lun;

    /**
     * Gets the value of the lun property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lun property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLun().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostMultipathInfoLogicalUnit }
     * 
     * 
     */
    public List<HostMultipathInfoLogicalUnit> getLun() {
        if (lun == null) {
            lun = new ArrayList<HostMultipathInfoLogicalUnit>();
        }
        return this.lun;
    }

}
