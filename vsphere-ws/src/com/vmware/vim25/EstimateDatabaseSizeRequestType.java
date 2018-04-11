
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstimateDatabaseSizeRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EstimateDatabaseSizeRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_this" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="dbSizeParam" type="{urn:vim25}DatabaseSizeParam"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstimateDatabaseSizeRequestType", propOrder = {
    "_this",
    "dbSizeParam"
})
public class EstimateDatabaseSizeRequestType {

    @XmlElement(required = true)
    protected ManagedObjectReference _this;
    @XmlElement(required = true)
    protected DatabaseSizeParam dbSizeParam;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setThis(ManagedObjectReference value) {
        this._this = value;
    }

    /**
     * Gets the value of the dbSizeParam property.
     * 
     * @return
     *     possible object is
     *     {@link DatabaseSizeParam }
     *     
     */
    public DatabaseSizeParam getDbSizeParam() {
        return dbSizeParam;
    }

    /**
     * Sets the value of the dbSizeParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatabaseSizeParam }
     *     
     */
    public void setDbSizeParam(DatabaseSizeParam value) {
        this.dbSizeParam = value;
    }

}
