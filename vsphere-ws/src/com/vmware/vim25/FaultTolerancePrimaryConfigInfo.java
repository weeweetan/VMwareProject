
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultTolerancePrimaryConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultTolerancePrimaryConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}FaultToleranceConfigInfo">
 *       &lt;sequence>
 *         &lt;element name="secondaries" type="{urn:vim25}ManagedObjectReference" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultTolerancePrimaryConfigInfo", propOrder = {
    "secondaries"
})
public class FaultTolerancePrimaryConfigInfo
    extends FaultToleranceConfigInfo
{

    @XmlElement(required = true)
    protected List<ManagedObjectReference> secondaries;

    /**
     * Gets the value of the secondaries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the secondaries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecondaries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ManagedObjectReference }
     * 
     * 
     */
    public List<ManagedObjectReference> getSecondaries() {
        if (secondaries == null) {
            secondaries = new ArrayList<ManagedObjectReference>();
        }
        return this.secondaries;
    }

}
