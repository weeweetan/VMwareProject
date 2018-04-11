
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileDeferredPolicyOptionParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileDeferredPolicyOptionParameter">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="inputPath" type="{urn:vim25}ProfilePropertyPath"/>
 *         &lt;element name="parameter" type="{urn:vim25}KeyAnyValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileDeferredPolicyOptionParameter", propOrder = {
    "inputPath",
    "parameter"
})
public class ProfileDeferredPolicyOptionParameter
    extends DynamicData
{

    @XmlElement(required = true)
    protected ProfilePropertyPath inputPath;
    protected List<KeyAnyValue> parameter;

    /**
     * Gets the value of the inputPath property.
     * 
     * @return
     *     possible object is
     *     {@link ProfilePropertyPath }
     *     
     */
    public ProfilePropertyPath getInputPath() {
        return inputPath;
    }

    /**
     * Sets the value of the inputPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfilePropertyPath }
     *     
     */
    public void setInputPath(ProfilePropertyPath value) {
        this.inputPath = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyAnyValue }
     * 
     * 
     */
    public List<KeyAnyValue> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<KeyAnyValue>();
        }
        return this.parameter;
    }

}
