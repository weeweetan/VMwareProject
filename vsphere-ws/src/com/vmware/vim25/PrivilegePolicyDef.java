
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivilegePolicyDef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivilegePolicyDef">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="createPrivilege" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="readPrivilege" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="updatePrivilege" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deletePrivilege" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivilegePolicyDef", propOrder = {
    "createPrivilege",
    "readPrivilege",
    "updatePrivilege",
    "deletePrivilege"
})
public class PrivilegePolicyDef
    extends DynamicData
{

    @XmlElement(required = true)
    protected String createPrivilege;
    @XmlElement(required = true)
    protected String readPrivilege;
    @XmlElement(required = true)
    protected String updatePrivilege;
    @XmlElement(required = true)
    protected String deletePrivilege;

    /**
     * Gets the value of the createPrivilege property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatePrivilege() {
        return createPrivilege;
    }

    /**
     * Sets the value of the createPrivilege property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatePrivilege(String value) {
        this.createPrivilege = value;
    }

    /**
     * Gets the value of the readPrivilege property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadPrivilege() {
        return readPrivilege;
    }

    /**
     * Sets the value of the readPrivilege property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadPrivilege(String value) {
        this.readPrivilege = value;
    }

    /**
     * Gets the value of the updatePrivilege property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatePrivilege() {
        return updatePrivilege;
    }

    /**
     * Sets the value of the updatePrivilege property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatePrivilege(String value) {
        this.updatePrivilege = value;
    }

    /**
     * Gets the value of the deletePrivilege property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeletePrivilege() {
        return deletePrivilege;
    }

    /**
     * Sets the value of the deletePrivilege property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeletePrivilege(String value) {
        this.deletePrivilege = value;
    }

}
