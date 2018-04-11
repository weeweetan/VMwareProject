
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatacenterMismatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatacenterMismatch">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}MigrationFault">
 *       &lt;sequence>
 *         &lt;element name="invalidArgument" type="{urn:vim25}DatacenterMismatchArgument" maxOccurs="unbounded"/>
 *         &lt;element name="expectedDatacenter" type="{urn:vim25}ManagedObjectReference"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatacenterMismatch", propOrder = {
    "invalidArgument",
    "expectedDatacenter"
})
public class DatacenterMismatch
    extends MigrationFault
{

    @XmlElement(required = true)
    protected List<DatacenterMismatchArgument> invalidArgument;
    @XmlElement(required = true)
    protected ManagedObjectReference expectedDatacenter;

    /**
     * Gets the value of the invalidArgument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invalidArgument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvalidArgument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatacenterMismatchArgument }
     * 
     * 
     */
    public List<DatacenterMismatchArgument> getInvalidArgument() {
        if (invalidArgument == null) {
            invalidArgument = new ArrayList<DatacenterMismatchArgument>();
        }
        return this.invalidArgument;
    }

    /**
     * Gets the value of the expectedDatacenter property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getExpectedDatacenter() {
        return expectedDatacenter;
    }

    /**
     * Sets the value of the expectedDatacenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setExpectedDatacenter(ManagedObjectReference value) {
        this.expectedDatacenter = value;
    }

}
