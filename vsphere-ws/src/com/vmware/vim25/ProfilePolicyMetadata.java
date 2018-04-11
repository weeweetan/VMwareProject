
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfilePolicyMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfilePolicyMetadata">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="id" type="{urn:vim25}ExtendedElementDescription"/>
 *         &lt;element name="possibleOption" type="{urn:vim25}ProfilePolicyOptionMetadata" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfilePolicyMetadata", propOrder = {
    "id",
    "possibleOption"
})
public class ProfilePolicyMetadata
    extends DynamicData
{

    @XmlElement(required = true)
    protected ExtendedElementDescription id;
    @XmlElement(required = true)
    protected List<ProfilePolicyOptionMetadata> possibleOption;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedElementDescription }
     *     
     */
    public ExtendedElementDescription getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedElementDescription }
     *     
     */
    public void setId(ExtendedElementDescription value) {
        this.id = value;
    }

    /**
     * Gets the value of the possibleOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the possibleOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPossibleOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfilePolicyOptionMetadata }
     * 
     * 
     */
    public List<ProfilePolicyOptionMetadata> getPossibleOption() {
        if (possibleOption == null) {
            possibleOption = new ArrayList<ProfilePolicyOptionMetadata>();
        }
        return this.possibleOption;
    }

}
