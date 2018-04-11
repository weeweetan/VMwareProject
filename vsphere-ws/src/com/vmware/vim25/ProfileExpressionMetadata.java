
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileExpressionMetadata complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileExpressionMetadata">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="expressionId" type="{urn:vim25}ExtendedElementDescription"/>
 *         &lt;element name="parameter" type="{urn:vim25}ProfileParameterMetadata" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileExpressionMetadata", propOrder = {
    "expressionId",
    "parameter"
})
public class ProfileExpressionMetadata
    extends DynamicData
{

    @XmlElement(required = true)
    protected ExtendedElementDescription expressionId;
    protected List<ProfileParameterMetadata> parameter;

    /**
     * Gets the value of the expressionId property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedElementDescription }
     *     
     */
    public ExtendedElementDescription getExpressionId() {
        return expressionId;
    }

    /**
     * Sets the value of the expressionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedElementDescription }
     *     
     */
    public void setExpressionId(ExtendedElementDescription value) {
        this.expressionId = value;
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
     * {@link ProfileParameterMetadata }
     * 
     * 
     */
    public List<ProfileParameterMetadata> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<ProfileParameterMetadata>();
        }
        return this.parameter;
    }

}
