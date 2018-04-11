
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProfileSimpleExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileSimpleExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ProfileExpression">
 *       &lt;sequence>
 *         &lt;element name="expressionType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "ProfileSimpleExpression", propOrder = {
    "expressionType",
    "parameter"
})
public class ProfileSimpleExpression
    extends ProfileExpression
{

    @XmlElement(required = true)
    protected String expressionType;
    protected List<KeyAnyValue> parameter;

    /**
     * Gets the value of the expressionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionType() {
        return expressionType;
    }

    /**
     * Sets the value of the expressionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionType(String value) {
        this.expressionType = value;
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
