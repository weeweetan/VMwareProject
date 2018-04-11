
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VMwareVspanPort complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VMwareVspanPort">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="portKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="uplinkPortName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wildcardPortConnecteeType" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vlans" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VMwareVspanPort", propOrder = {
    "portKey",
    "uplinkPortName",
    "wildcardPortConnecteeType",
    "vlans",
    "ipAddress"
})
public class VMwareVspanPort
    extends DynamicData
{

    protected List<String> portKey;
    protected List<String> uplinkPortName;
    protected List<String> wildcardPortConnecteeType;
    @XmlElement(type = Integer.class)
    protected List<Integer> vlans;
    protected List<String> ipAddress;

    /**
     * Gets the value of the portKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the portKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPortKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPortKey() {
        if (portKey == null) {
            portKey = new ArrayList<String>();
        }
        return this.portKey;
    }

    /**
     * Gets the value of the uplinkPortName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uplinkPortName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUplinkPortName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUplinkPortName() {
        if (uplinkPortName == null) {
            uplinkPortName = new ArrayList<String>();
        }
        return this.uplinkPortName;
    }

    /**
     * Gets the value of the wildcardPortConnecteeType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wildcardPortConnecteeType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWildcardPortConnecteeType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWildcardPortConnecteeType() {
        if (wildcardPortConnecteeType == null) {
            wildcardPortConnecteeType = new ArrayList<String>();
        }
        return this.wildcardPortConnecteeType;
    }

    /**
     * Gets the value of the vlans property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlans property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlans().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getVlans() {
        if (vlans == null) {
            vlans = new ArrayList<Integer>();
        }
        return this.vlans;
    }

    /**
     * Gets the value of the ipAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIpAddress() {
        if (ipAddress == null) {
            ipAddress = new ArrayList<String>();
        }
        return this.ipAddress;
    }

}
