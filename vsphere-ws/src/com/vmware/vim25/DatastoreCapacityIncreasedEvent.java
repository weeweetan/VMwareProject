
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatastoreCapacityIncreasedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatastoreCapacityIncreasedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DatastoreEvent">
 *       &lt;sequence>
 *         &lt;element name="oldCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="newCapacity" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatastoreCapacityIncreasedEvent", propOrder = {
    "oldCapacity",
    "newCapacity"
})
public class DatastoreCapacityIncreasedEvent
    extends DatastoreEvent
{

    protected long oldCapacity;
    protected long newCapacity;

    /**
     * Gets the value of the oldCapacity property.
     * 
     */
    public long getOldCapacity() {
        return oldCapacity;
    }

    /**
     * Sets the value of the oldCapacity property.
     * 
     */
    public void setOldCapacity(long value) {
        this.oldCapacity = value;
    }

    /**
     * Gets the value of the newCapacity property.
     * 
     */
    public long getNewCapacity() {
        return newCapacity;
    }

    /**
     * Sets the value of the newCapacity property.
     * 
     */
    public void setNewCapacity(long value) {
        this.newCapacity = value;
    }

}
