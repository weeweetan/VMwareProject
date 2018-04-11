
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAnswerFileStatusError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAnswerFileStatusError">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AnswerFileStatusError" type="{urn:vim25}AnswerFileStatusError" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAnswerFileStatusError", propOrder = {
    "answerFileStatusError"
})
public class ArrayOfAnswerFileStatusError {

    @XmlElement(name = "AnswerFileStatusError")
    protected List<AnswerFileStatusError> answerFileStatusError;

    /**
     * Gets the value of the answerFileStatusError property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the answerFileStatusError property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnswerFileStatusError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnswerFileStatusError }
     * 
     * 
     */
    public List<AnswerFileStatusError> getAnswerFileStatusError() {
        if (answerFileStatusError == null) {
            answerFileStatusError = new ArrayList<AnswerFileStatusError>();
        }
        return this.answerFileStatusError;
    }

}
