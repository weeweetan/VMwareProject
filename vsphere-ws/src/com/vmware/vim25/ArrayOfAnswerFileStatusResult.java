
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAnswerFileStatusResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAnswerFileStatusResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AnswerFileStatusResult" type="{urn:vim25}AnswerFileStatusResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAnswerFileStatusResult", propOrder = {
    "answerFileStatusResult"
})
public class ArrayOfAnswerFileStatusResult {

    @XmlElement(name = "AnswerFileStatusResult")
    protected List<AnswerFileStatusResult> answerFileStatusResult;

    /**
     * Gets the value of the answerFileStatusResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the answerFileStatusResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnswerFileStatusResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnswerFileStatusResult }
     * 
     * 
     */
    public List<AnswerFileStatusResult> getAnswerFileStatusResult() {
        if (answerFileStatusResult == null) {
            answerFileStatusResult = new ArrayList<AnswerFileStatusResult>();
        }
        return this.answerFileStatusResult;
    }

}
