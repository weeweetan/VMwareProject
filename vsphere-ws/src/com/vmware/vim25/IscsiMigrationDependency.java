
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IscsiMigrationDependency complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IscsiMigrationDependency">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="migrationAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="disallowReason" type="{urn:vim25}IscsiStatus" minOccurs="0"/>
 *         &lt;element name="dependency" type="{urn:vim25}IscsiDependencyEntity" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IscsiMigrationDependency", propOrder = {
    "migrationAllowed",
    "disallowReason",
    "dependency"
})
public class IscsiMigrationDependency
    extends DynamicData
{

    protected boolean migrationAllowed;
    protected IscsiStatus disallowReason;
    protected List<IscsiDependencyEntity> dependency;

    /**
     * Gets the value of the migrationAllowed property.
     * 
     */
    public boolean isMigrationAllowed() {
        return migrationAllowed;
    }

    /**
     * Sets the value of the migrationAllowed property.
     * 
     */
    public void setMigrationAllowed(boolean value) {
        this.migrationAllowed = value;
    }

    /**
     * Gets the value of the disallowReason property.
     * 
     * @return
     *     possible object is
     *     {@link IscsiStatus }
     *     
     */
    public IscsiStatus getDisallowReason() {
        return disallowReason;
    }

    /**
     * Sets the value of the disallowReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link IscsiStatus }
     *     
     */
    public void setDisallowReason(IscsiStatus value) {
        this.disallowReason = value;
    }

    /**
     * Gets the value of the dependency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IscsiDependencyEntity }
     * 
     * 
     */
    public List<IscsiDependencyEntity> getDependency() {
        if (dependency == null) {
            dependency = new ArrayList<IscsiDependencyEntity>();
        }
        return this.dependency;
    }

}
