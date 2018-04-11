
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VAppEntityConfigInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VAppEntityConfigInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="startDelay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="waitingForGuest" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="startAction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stopDelay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="stopAction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destroyWithParent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VAppEntityConfigInfo", propOrder = {
    "key",
    "tag",
    "startOrder",
    "startDelay",
    "waitingForGuest",
    "startAction",
    "stopDelay",
    "stopAction",
    "destroyWithParent"
})
public class VAppEntityConfigInfo
    extends DynamicData
{

    protected ManagedObjectReference key;
    protected String tag;
    protected Integer startOrder;
    protected Integer startDelay;
    protected Boolean waitingForGuest;
    protected String startAction;
    protected Integer stopDelay;
    protected String stopAction;
    protected Boolean destroyWithParent;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setKey(ManagedObjectReference value) {
        this.key = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Gets the value of the startOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartOrder() {
        return startOrder;
    }

    /**
     * Sets the value of the startOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartOrder(Integer value) {
        this.startOrder = value;
    }

    /**
     * Gets the value of the startDelay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartDelay() {
        return startDelay;
    }

    /**
     * Sets the value of the startDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartDelay(Integer value) {
        this.startDelay = value;
    }

    /**
     * Gets the value of the waitingForGuest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWaitingForGuest() {
        return waitingForGuest;
    }

    /**
     * Sets the value of the waitingForGuest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWaitingForGuest(Boolean value) {
        this.waitingForGuest = value;
    }

    /**
     * Gets the value of the startAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartAction() {
        return startAction;
    }

    /**
     * Sets the value of the startAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartAction(String value) {
        this.startAction = value;
    }

    /**
     * Gets the value of the stopDelay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStopDelay() {
        return stopDelay;
    }

    /**
     * Sets the value of the stopDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStopDelay(Integer value) {
        this.stopDelay = value;
    }

    /**
     * Gets the value of the stopAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopAction() {
        return stopAction;
    }

    /**
     * Sets the value of the stopAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopAction(String value) {
        this.stopAction = value;
    }

    /**
     * Gets the value of the destroyWithParent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDestroyWithParent() {
        return destroyWithParent;
    }

    /**
     * Sets the value of the destroyWithParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDestroyWithParent(Boolean value) {
        this.destroyWithParent = value;
    }

}
