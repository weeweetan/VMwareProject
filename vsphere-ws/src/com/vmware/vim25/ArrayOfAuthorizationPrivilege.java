
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAuthorizationPrivilege complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAuthorizationPrivilege">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuthorizationPrivilege" type="{urn:vim25}AuthorizationPrivilege" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAuthorizationPrivilege", propOrder = {
    "authorizationPrivilege"
})
public class ArrayOfAuthorizationPrivilege {

    @XmlElement(name = "AuthorizationPrivilege")
    protected List<AuthorizationPrivilege> authorizationPrivilege;

    /**
     * Gets the value of the authorizationPrivilege property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorizationPrivilege property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorizationPrivilege().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuthorizationPrivilege }
     * 
     * 
     */
    public List<AuthorizationPrivilege> getAuthorizationPrivilege() {
        if (authorizationPrivilege == null) {
            authorizationPrivilege = new ArrayList<AuthorizationPrivilege>();
        }
        return this.authorizationPrivilege;
    }

}
