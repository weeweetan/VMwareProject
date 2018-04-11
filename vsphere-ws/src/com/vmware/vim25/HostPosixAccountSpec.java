
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostPosixAccountSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostPosixAccountSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostAccountSpec">
 *       &lt;sequence>
 *         &lt;element name="posixId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="shellAccess" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostPosixAccountSpec", propOrder = {
    "posixId",
    "shellAccess"
})
public class HostPosixAccountSpec
    extends HostAccountSpec
{

    protected Integer posixId;
    protected Boolean shellAccess;

    /**
     * Gets the value of the posixId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPosixId() {
        return posixId;
    }

    /**
     * Sets the value of the posixId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPosixId(Integer value) {
        this.posixId = value;
    }

    /**
     * Gets the value of the shellAccess property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShellAccess() {
        return shellAccess;
    }

    /**
     * Sets the value of the shellAccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShellAccess(Boolean value) {
        this.shellAccess = value;
    }

}
