
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutOfBounds complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutOfBounds">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *         &lt;element name="argumentName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutOfBounds", propOrder = {
    "argumentName"
})
public class OutOfBounds
    extends VimFault
{

    @XmlElement(required = true)
    protected String argumentName;

    /**
     * Gets the value of the argumentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArgumentName() {
        return argumentName;
    }

    /**
     * Sets the value of the argumentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArgumentName(String value) {
        this.argumentName = value;
    }

}
