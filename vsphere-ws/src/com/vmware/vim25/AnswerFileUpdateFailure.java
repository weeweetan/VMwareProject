
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnswerFileUpdateFailure complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnswerFileUpdateFailure">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="userInputPath" type="{urn:vim25}ProfilePropertyPath"/>
 *         &lt;element name="errMsg" type="{urn:vim25}LocalizableMessage"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnswerFileUpdateFailure", propOrder = {
    "userInputPath",
    "errMsg"
})
public class AnswerFileUpdateFailure
    extends DynamicData
{

    @XmlElement(required = true)
    protected ProfilePropertyPath userInputPath;
    @XmlElement(required = true)
    protected LocalizableMessage errMsg;

    /**
     * Gets the value of the userInputPath property.
     * 
     * @return
     *     possible object is
     *     {@link ProfilePropertyPath }
     *     
     */
    public ProfilePropertyPath getUserInputPath() {
        return userInputPath;
    }

    /**
     * Sets the value of the userInputPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfilePropertyPath }
     *     
     */
    public void setUserInputPath(ProfilePropertyPath value) {
        this.userInputPath = value;
    }

    /**
     * Gets the value of the errMsg property.
     * 
     * @return
     *     possible object is
     *     {@link LocalizableMessage }
     *     
     */
    public LocalizableMessage getErrMsg() {
        return errMsg;
    }

    /**
     * Sets the value of the errMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalizableMessage }
     *     
     */
    public void setErrMsg(LocalizableMessage value) {
        this.errMsg = value;
    }

}
