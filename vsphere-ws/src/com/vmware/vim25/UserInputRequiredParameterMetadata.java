
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserInputRequiredParameterMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserInputRequiredParameterMetadata">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ProfilePolicyOptionMetadata">
 *       &lt;sequence>
 *         &lt;element name="userInputParameter" type="{urn:vim25}ProfileParameterMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInputRequiredParameterMetadata", propOrder = {
    "userInputParameter"
})
public class UserInputRequiredParameterMetadata
    extends ProfilePolicyOptionMetadata
{

    protected List<ProfileParameterMetadata> userInputParameter;

    /**
     * Gets the value of the userInputParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userInputParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserInputParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileParameterMetadata }
     * 
     * 
     */
    public List<ProfileParameterMetadata> getUserInputParameter() {
        if (userInputParameter == null) {
            userInputParameter = new ArrayList<ProfileParameterMetadata>();
        }
        return this.userInputParameter;
    }

}
