
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVnicPortArgument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVnicPortArgument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VnicPortArgument" type="{urn:vim25}VnicPortArgument" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVnicPortArgument", propOrder = {
    "vnicPortArgument"
})
public class ArrayOfVnicPortArgument {

    @XmlElement(name = "VnicPortArgument")
    protected List<VnicPortArgument> vnicPortArgument;

    /**
     * Gets the value of the vnicPortArgument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vnicPortArgument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVnicPortArgument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VnicPortArgument }
     * 
     * 
     */
    public List<VnicPortArgument> getVnicPortArgument() {
        if (vnicPortArgument == null) {
            vnicPortArgument = new ArrayList<VnicPortArgument>();
        }
        return this.vnicPortArgument;
    }

}
