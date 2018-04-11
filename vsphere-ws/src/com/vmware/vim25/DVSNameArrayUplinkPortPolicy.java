
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DVSNameArrayUplinkPortPolicy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DVSNameArrayUplinkPortPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DVSUplinkPortPolicy">
 *       &lt;sequence>
 *         &lt;element name="uplinkPortName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DVSNameArrayUplinkPortPolicy", propOrder = {
    "uplinkPortName"
})
public class DVSNameArrayUplinkPortPolicy
    extends DVSUplinkPortPolicy
{

    @XmlElement(required = true)
    protected List<String> uplinkPortName;

    /**
     * Gets the value of the uplinkPortName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uplinkPortName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUplinkPortName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUplinkPortName() {
        if (uplinkPortName == null) {
            uplinkPortName = new ArrayList<String>();
        }
        return this.uplinkPortName;
    }

}
