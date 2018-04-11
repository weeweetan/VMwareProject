
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LinkLayerDiscoveryProtocolInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LinkLayerDiscoveryProtocolInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="chassisId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="portId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeToLive" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parameter" type="{urn:vim25}KeyAnyValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkLayerDiscoveryProtocolInfo", propOrder = {
    "chassisId",
    "portId",
    "timeToLive",
    "parameter"
})
public class LinkLayerDiscoveryProtocolInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String chassisId;
    @XmlElement(required = true)
    protected String portId;
    protected int timeToLive;
    protected List<KeyAnyValue> parameter;

    /**
     * Gets the value of the chassisId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChassisId() {
        return chassisId;
    }

    /**
     * Sets the value of the chassisId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChassisId(String value) {
        this.chassisId = value;
    }

    /**
     * Gets the value of the portId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortId() {
        return portId;
    }

    /**
     * Sets the value of the portId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortId(String value) {
        this.portId = value;
    }

    /**
     * Gets the value of the timeToLive property.
     * 
     */
    public int getTimeToLive() {
        return timeToLive;
    }

    /**
     * Sets the value of the timeToLive property.
     * 
     */
    public void setTimeToLive(int value) {
        this.timeToLive = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyAnyValue }
     * 
     * 
     */
    public List<KeyAnyValue> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<KeyAnyValue>();
        }
        return this.parameter;
    }

}
