
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDatastoreConnectInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDatastoreConnectInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="summary" type="{urn:vim25}DatastoreSummary"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDatastoreConnectInfo", propOrder = {
    "summary"
})
@XmlSeeAlso({
    HostDatastoreExistsConnectInfo.class,
    HostDatastoreNameConflictConnectInfo.class
})
public class HostDatastoreConnectInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected DatastoreSummary summary;

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link DatastoreSummary }
     *     
     */
    public DatastoreSummary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreSummary }
     *     
     */
    public void setSummary(DatastoreSummary value) {
        this.summary = value;
    }

}
