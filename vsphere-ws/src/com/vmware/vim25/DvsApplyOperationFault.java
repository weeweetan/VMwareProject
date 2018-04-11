
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsApplyOperationFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsApplyOperationFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsFault">
 *       &lt;sequence>
 *         &lt;element name="objectFault" type="{urn:vim25}DvsApplyOperationFaultFaultOnObject" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsApplyOperationFault", propOrder = {
    "objectFault"
})
public class DvsApplyOperationFault
    extends DvsFault
{

    @XmlElement(required = true)
    protected List<DvsApplyOperationFaultFaultOnObject> objectFault;

    /**
     * Gets the value of the objectFault property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectFault property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectFault().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DvsApplyOperationFaultFaultOnObject }
     * 
     * 
     */
    public List<DvsApplyOperationFaultFaultOnObject> getObjectFault() {
        if (objectFault == null) {
            objectFault = new ArrayList<DvsApplyOperationFaultFaultOnObject>();
        }
        return this.objectFault;
    }

}
