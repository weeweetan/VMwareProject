
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProfileDeferredPolicyOptionParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProfileDeferredPolicyOptionParameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileDeferredPolicyOptionParameter" type="{urn:vim25}ProfileDeferredPolicyOptionParameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProfileDeferredPolicyOptionParameter", propOrder = {
    "profileDeferredPolicyOptionParameter"
})
public class ArrayOfProfileDeferredPolicyOptionParameter {

    @XmlElement(name = "ProfileDeferredPolicyOptionParameter")
    protected List<ProfileDeferredPolicyOptionParameter> profileDeferredPolicyOptionParameter;

    /**
     * Gets the value of the profileDeferredPolicyOptionParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileDeferredPolicyOptionParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileDeferredPolicyOptionParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileDeferredPolicyOptionParameter }
     * 
     * 
     */
    public List<ProfileDeferredPolicyOptionParameter> getProfileDeferredPolicyOptionParameter() {
        if (profileDeferredPolicyOptionParameter == null) {
            profileDeferredPolicyOptionParameter = new ArrayList<ProfileDeferredPolicyOptionParameter>();
        }
        return this.profileDeferredPolicyOptionParameter;
    }

}
