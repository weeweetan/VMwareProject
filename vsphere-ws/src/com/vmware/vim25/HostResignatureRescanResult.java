
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostResignatureRescanResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostResignatureRescanResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="rescan" type="{urn:vim25}HostVmfsRescanResult" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="result" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostResignatureRescanResult", propOrder = {
    "rescan",
    "result"
})
public class HostResignatureRescanResult
    extends DynamicData
{

    protected List<HostVmfsRescanResult> rescan;
    @XmlElement(required = true)
    protected ManagedObjectReference result;

    /**
     * Gets the value of the rescan property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rescan property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRescan().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostVmfsRescanResult }
     * 
     * 
     */
    public List<HostVmfsRescanResult> getRescan() {
        if (rescan == null) {
            rescan = new ArrayList<HostVmfsRescanResult>();
        }
        return this.rescan;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setResult(ManagedObjectReference value) {
        this.result = value;
    }

}
