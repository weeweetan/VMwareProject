
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DvsMergedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DvsMergedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DvsEvent">
 *       &lt;sequence>
 *         &lt;element name="sourceDvs" type="{urn:vim25}DvsEventArgument"/>
 *         &lt;element name="destinationDvs" type="{urn:vim25}DvsEventArgument"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DvsMergedEvent", propOrder = {
    "sourceDvs",
    "destinationDvs"
})
public class DvsMergedEvent
    extends DvsEvent
{

    @XmlElement(required = true)
    protected DvsEventArgument sourceDvs;
    @XmlElement(required = true)
    protected DvsEventArgument destinationDvs;

    /**
     * Gets the value of the sourceDvs property.
     * 
     * @return
     *     possible object is
     *     {@link DvsEventArgument }
     *     
     */
    public DvsEventArgument getSourceDvs() {
        return sourceDvs;
    }

    /**
     * Sets the value of the sourceDvs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DvsEventArgument }
     *     
     */
    public void setSourceDvs(DvsEventArgument value) {
        this.sourceDvs = value;
    }

    /**
     * Gets the value of the destinationDvs property.
     * 
     * @return
     *     possible object is
     *     {@link DvsEventArgument }
     *     
     */
    public DvsEventArgument getDestinationDvs() {
        return destinationDvs;
    }

    /**
     * Sets the value of the destinationDvs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DvsEventArgument }
     *     
     */
    public void setDestinationDvs(DvsEventArgument value) {
        this.destinationDvs = value;
    }

}
