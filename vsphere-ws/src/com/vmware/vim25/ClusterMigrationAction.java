
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterMigrationAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterMigrationAction">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterAction">
 *       &lt;sequence>
 *         &lt;element name="drsMigration" type="{urn:vim25}ClusterDrsMigration" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterMigrationAction", propOrder = {
    "drsMigration"
})
public class ClusterMigrationAction
    extends ClusterAction
{

    protected ClusterDrsMigration drsMigration;

    /**
     * Gets the value of the drsMigration property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDrsMigration }
     *     
     */
    public ClusterDrsMigration getDrsMigration() {
        return drsMigration;
    }

    /**
     * Sets the value of the drsMigration property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDrsMigration }
     *     
     */
    public void setDrsMigration(ClusterDrsMigration value) {
        this.drsMigration = value;
    }

}
