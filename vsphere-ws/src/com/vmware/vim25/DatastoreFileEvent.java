
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatastoreFileEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatastoreFileEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DatastoreEvent">
 *       &lt;sequence>
 *         &lt;element name="targetFile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatastoreFileEvent", propOrder = {
    "targetFile"
})
@XmlSeeAlso({
    DatastoreFileDeletedEvent.class,
    DatastoreFileMovedEvent.class,
    DatastoreFileCopiedEvent.class
})
public class DatastoreFileEvent
    extends DatastoreEvent
{

    @XmlElement(required = true)
    protected String targetFile;

    /**
     * Gets the value of the targetFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetFile() {
        return targetFile;
    }

    /**
     * Sets the value of the targetFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetFile(String value) {
        this.targetFile = value;
    }

}
