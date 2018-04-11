
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVMwareVspanSession complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVMwareVspanSession">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VMwareVspanSession" type="{urn:vim25}VMwareVspanSession" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVMwareVspanSession", propOrder = {
    "vMwareVspanSession"
})
public class ArrayOfVMwareVspanSession {

    @XmlElement(name = "VMwareVspanSession")
    protected List<VMwareVspanSession> vMwareVspanSession;

    /**
     * Gets the value of the vMwareVspanSession property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vMwareVspanSession property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVMwareVspanSession().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VMwareVspanSession }
     * 
     * 
     */
    public List<VMwareVspanSession> getVMwareVspanSession() {
        if (vMwareVspanSession == null) {
            vMwareVspanSession = new ArrayList<VMwareVspanSession>();
        }
        return this.vMwareVspanSession;
    }

}
