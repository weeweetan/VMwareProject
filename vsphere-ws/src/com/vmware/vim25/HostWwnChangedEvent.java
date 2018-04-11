
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostWwnChangedEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostWwnChangedEvent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostEvent">
 *       &lt;sequence>
 *         &lt;element name="oldNodeWwns" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="oldPortWwns" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="newNodeWwns" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="newPortWwns" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostWwnChangedEvent", propOrder = {
    "oldNodeWwns",
    "oldPortWwns",
    "newNodeWwns",
    "newPortWwns"
})
public class HostWwnChangedEvent
    extends HostEvent
{

    @XmlElement(type = Long.class)
    protected List<Long> oldNodeWwns;
    @XmlElement(type = Long.class)
    protected List<Long> oldPortWwns;
    @XmlElement(type = Long.class)
    protected List<Long> newNodeWwns;
    @XmlElement(type = Long.class)
    protected List<Long> newPortWwns;

    /**
     * Gets the value of the oldNodeWwns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oldNodeWwns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOldNodeWwns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getOldNodeWwns() {
        if (oldNodeWwns == null) {
            oldNodeWwns = new ArrayList<Long>();
        }
        return this.oldNodeWwns;
    }

    /**
     * Gets the value of the oldPortWwns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oldPortWwns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOldPortWwns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getOldPortWwns() {
        if (oldPortWwns == null) {
            oldPortWwns = new ArrayList<Long>();
        }
        return this.oldPortWwns;
    }

    /**
     * Gets the value of the newNodeWwns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newNodeWwns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewNodeWwns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getNewNodeWwns() {
        if (newNodeWwns == null) {
            newNodeWwns = new ArrayList<Long>();
        }
        return this.newNodeWwns;
    }

    /**
     * Gets the value of the newPortWwns property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the newPortWwns property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNewPortWwns().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getNewPortWwns() {
        if (newPortWwns == null) {
            newPortWwns = new ArrayList<Long>();
        }
        return this.newPortWwns;
    }

}
