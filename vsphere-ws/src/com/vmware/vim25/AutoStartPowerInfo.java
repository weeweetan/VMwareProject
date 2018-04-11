
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutoStartPowerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutoStartPowerInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="key" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="startOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startDelay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="waitForHeartbeat" type="{urn:vim25}AutoStartWaitHeartbeatSetting"/>
 *         &lt;element name="startAction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stopDelay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stopAction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoStartPowerInfo", propOrder = {
    "key",
    "startOrder",
    "startDelay",
    "waitForHeartbeat",
    "startAction",
    "stopDelay",
    "stopAction"
})
public class AutoStartPowerInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference key;
    protected int startOrder;
    protected int startDelay;
    @XmlElement(required = true)
    protected AutoStartWaitHeartbeatSetting waitForHeartbeat;
    @XmlElement(required = true)
    protected String startAction;
    protected int stopDelay;
    @XmlElement(required = true)
    protected String stopAction;

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
     * Gets the value of the startOrder property.
     * 
     */
    public int getStartOrder() {
        return startOrder;
    }

    /**
     * Sets the value of the startOrder property.
     * 
     */
    public void setStartOrder(int value) {
        this.startOrder = value;
    }

    /**
     * Gets the value of the startDelay property.
     * 
     */
    public int getStartDelay() {
        return startDelay;
    }

    /**
     * Sets the value of the startDelay property.
     * 
     */
    public void setStartDelay(int value) {
        this.startDelay = value;
    }

    /**
     * Gets the value of the waitForHeartbeat property.
     * 
     * @return
     *     possible object is
     *     {@link AutoStartWaitHeartbeatSetting }
     *     
     */
    public AutoStartWaitHeartbeatSetting getWaitForHeartbeat() {
        return waitForHeartbeat;
    }

    /**
     * Sets the value of the waitForHeartbeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutoStartWaitHeartbeatSetting }
     *     
     */
    public void setWaitForHeartbeat(AutoStartWaitHeartbeatSetting value) {
        this.waitForHeartbeat = value;
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
     */
    public int getStopDelay() {
        return stopDelay;
    }

    /**
     * Sets the value of the stopDelay property.
     * 
     */
    public void setStopDelay(int value) {
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

}
