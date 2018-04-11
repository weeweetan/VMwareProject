
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareDVSVlanHealthCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareDVSVlanHealthCheckResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostMemberUplinkHealthCheckResult">
 *       &lt;sequence>
 *         &lt;element name="trunkedVlan" type="{urn:vim25}NumericRange" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="untrunkedVlan" type="{urn:vim25}NumericRange" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareDVSVlanHealthCheckResult", propOrder = {
    "trunkedVlan",
    "untrunkedVlan"
})
public class VMwareDVSVlanHealthCheckResult
    extends HostMemberUplinkHealthCheckResult
{

    protected List<NumericRange> trunkedVlan;
    protected List<NumericRange> untrunkedVlan;

    /**
     * Gets the value of the trunkedVlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trunkedVlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrunkedVlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericRange }
     * 
     * 
     */
    public List<NumericRange> getTrunkedVlan() {
        if (trunkedVlan == null) {
            trunkedVlan = new ArrayList<NumericRange>();
        }
        return this.trunkedVlan;
    }

    /**
     * Gets the value of the untrunkedVlan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the untrunkedVlan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUntrunkedVlan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericRange }
     * 
     * 
     */
    public List<NumericRange> getUntrunkedVlan() {
        if (untrunkedVlan == null) {
            untrunkedVlan = new ArrayList<NumericRange>();
        }
        return this.untrunkedVlan;
    }

}
