
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompositePolicyOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompositePolicyOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}PolicyOption">
 *       &lt;sequence>
 *         &lt;element name="option" type="{urn:vim25}PolicyOption" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompositePolicyOption", propOrder = {
    "option"
})
public class CompositePolicyOption
    extends PolicyOption
{

    protected List<PolicyOption> option;

    /**
     * Gets the value of the option property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the option property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PolicyOption }
     * 
     * 
     */
    public List<PolicyOption> getOption() {
        if (option == null) {
            option = new ArrayList<PolicyOption>();
        }
        return this.option;
    }

}
