
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnswerFileSerializedCreateSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnswerFileSerializedCreateSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}AnswerFileCreateSpec">
 *       &lt;sequence>
 *         &lt;element name="answerFileConfigString" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnswerFileSerializedCreateSpec", propOrder = {
    "answerFileConfigString"
})
public class AnswerFileSerializedCreateSpec
    extends AnswerFileCreateSpec
{

    @XmlElement(required = true)
    protected String answerFileConfigString;

    /**
     * Gets the value of the answerFileConfigString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnswerFileConfigString() {
        return answerFileConfigString;
    }

    /**
     * Sets the value of the answerFileConfigString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnswerFileConfigString(String value) {
        this.answerFileConfigString = value;
    }

}
