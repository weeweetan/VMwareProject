
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendEmailAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SendEmailAction">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}Action">
 *       &lt;sequence>
 *         &lt;element name="toList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccList" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendEmailAction", propOrder = {
    "toList",
    "ccList",
    "subject",
    "body"
})
public class SendEmailAction
    extends Action
{

    @XmlElement(required = true)
    protected String toList;
    @XmlElement(required = true)
    protected String ccList;
    @XmlElement(required = true)
    protected String subject;
    @XmlElement(required = true)
    protected String body;

    /**
     * Gets the value of the toList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToList() {
        return toList;
    }

    /**
     * Sets the value of the toList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToList(String value) {
        this.toList = value;
    }

    /**
     * Gets the value of the ccList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcList() {
        return ccList;
    }

    /**
     * Sets the value of the ccList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcList(String value) {
        this.ccList = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

}
