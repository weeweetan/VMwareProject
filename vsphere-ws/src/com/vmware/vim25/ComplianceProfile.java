
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ComplianceProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplianceProfile">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="expression" type="{urn:vim25}ProfileExpression" maxOccurs="unbounded"/>
 *         &lt;element name="rootExpression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplianceProfile", propOrder = {
    "expression",
    "rootExpression"
})
public class ComplianceProfile
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<ProfileExpression> expression;
    @XmlElement(required = true)
    protected String rootExpression;

    /**
     * Gets the value of the expression property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expression property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpression().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileExpression }
     * 
     * 
     */
    public List<ProfileExpression> getExpression() {
        if (expression == null) {
            expression = new ArrayList<ProfileExpression>();
        }
        return this.expression;
    }

    /**
     * Gets the value of the rootExpression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRootExpression() {
        return rootExpression;
    }

    /**
     * Sets the value of the rootExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRootExpression(String value) {
        this.rootExpression = value;
    }

}
