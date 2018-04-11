
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="expr" type="{urn:vim25}TypeDescription" maxOccurs="unbounded"/>
 *         &lt;element name="stateOperator" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="metricOperator" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="hostSystemConnectionState" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="virtualMachinePowerState" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="datastoreConnectionState" type="{urn:vim25}ElementDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="hostSystemPowerState" type="{urn:vim25}ElementDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="virtualMachineGuestHeartbeatStatus" type="{urn:vim25}ElementDescription" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entityStatus" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="action" type="{urn:vim25}TypeDescription" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmDescription", propOrder = {
    "expr",
    "stateOperator",
    "metricOperator",
    "hostSystemConnectionState",
    "virtualMachinePowerState",
    "datastoreConnectionState",
    "hostSystemPowerState",
    "virtualMachineGuestHeartbeatStatus",
    "entityStatus",
    "action"
})
public class AlarmDescription
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<TypeDescription> expr;
    @XmlElement(required = true)
    protected List<ElementDescription> stateOperator;
    @XmlElement(required = true)
    protected List<ElementDescription> metricOperator;
    @XmlElement(required = true)
    protected List<ElementDescription> hostSystemConnectionState;
    @XmlElement(required = true)
    protected List<ElementDescription> virtualMachinePowerState;
    protected List<ElementDescription> datastoreConnectionState;
    protected List<ElementDescription> hostSystemPowerState;
    protected List<ElementDescription> virtualMachineGuestHeartbeatStatus;
    @XmlElement(required = true)
    protected List<ElementDescription> entityStatus;
    @XmlElement(required = true)
    protected List<TypeDescription> action;

    /**
     * Gets the value of the expr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeDescription }
     * 
     * 
     */
    public List<TypeDescription> getExpr() {
        if (expr == null) {
            expr = new ArrayList<TypeDescription>();
        }
        return this.expr;
    }

    /**
     * Gets the value of the stateOperator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stateOperator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStateOperator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getStateOperator() {
        if (stateOperator == null) {
            stateOperator = new ArrayList<ElementDescription>();
        }
        return this.stateOperator;
    }

    /**
     * Gets the value of the metricOperator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metricOperator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetricOperator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getMetricOperator() {
        if (metricOperator == null) {
            metricOperator = new ArrayList<ElementDescription>();
        }
        return this.metricOperator;
    }

    /**
     * Gets the value of the hostSystemConnectionState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostSystemConnectionState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostSystemConnectionState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getHostSystemConnectionState() {
        if (hostSystemConnectionState == null) {
            hostSystemConnectionState = new ArrayList<ElementDescription>();
        }
        return this.hostSystemConnectionState;
    }

    /**
     * Gets the value of the virtualMachinePowerState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachinePowerState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachinePowerState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getVirtualMachinePowerState() {
        if (virtualMachinePowerState == null) {
            virtualMachinePowerState = new ArrayList<ElementDescription>();
        }
        return this.virtualMachinePowerState;
    }

    /**
     * Gets the value of the datastoreConnectionState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreConnectionState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreConnectionState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getDatastoreConnectionState() {
        if (datastoreConnectionState == null) {
            datastoreConnectionState = new ArrayList<ElementDescription>();
        }
        return this.datastoreConnectionState;
    }

    /**
     * Gets the value of the hostSystemPowerState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hostSystemPowerState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHostSystemPowerState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getHostSystemPowerState() {
        if (hostSystemPowerState == null) {
            hostSystemPowerState = new ArrayList<ElementDescription>();
        }
        return this.hostSystemPowerState;
    }

    /**
     * Gets the value of the virtualMachineGuestHeartbeatStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualMachineGuestHeartbeatStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualMachineGuestHeartbeatStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getVirtualMachineGuestHeartbeatStatus() {
        if (virtualMachineGuestHeartbeatStatus == null) {
            virtualMachineGuestHeartbeatStatus = new ArrayList<ElementDescription>();
        }
        return this.virtualMachineGuestHeartbeatStatus;
    }

    /**
     * Gets the value of the entityStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entityStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntityStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getEntityStatus() {
        if (entityStatus == null) {
            entityStatus = new ArrayList<ElementDescription>();
        }
        return this.entityStatus;
    }

    /**
     * Gets the value of the action property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the action property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeDescription }
     * 
     * 
     */
    public List<TypeDescription> getAction() {
        if (action == null) {
            action = new ArrayList<TypeDescription>();
        }
        return this.action;
    }

}
