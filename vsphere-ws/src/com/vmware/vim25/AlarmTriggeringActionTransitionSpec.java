
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmTriggeringActionTransitionSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmTriggeringActionTransitionSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="startState" type="{urn:vim25}ManagedEntityStatus"/>
 *         &lt;element name="finalState" type="{urn:vim25}ManagedEntityStatus"/>
 *         &lt;element name="repeats" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmTriggeringActionTransitionSpec", propOrder = {
    "startState",
    "finalState",
    "repeats"
})
public class AlarmTriggeringActionTransitionSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedEntityStatus startState;
    @XmlElement(required = true)
    protected ManagedEntityStatus finalState;
    protected boolean repeats;

    /**
     * Gets the value of the startState property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public ManagedEntityStatus getStartState() {
        return startState;
    }

    /**
     * Sets the value of the startState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public void setStartState(ManagedEntityStatus value) {
        this.startState = value;
    }

    /**
     * Gets the value of the finalState property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public ManagedEntityStatus getFinalState() {
        return finalState;
    }

    /**
     * Sets the value of the finalState property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedEntityStatus }
     *     
     */
    public void setFinalState(ManagedEntityStatus value) {
        this.finalState = value;
    }

    /**
     * Gets the value of the repeats property.
     * 
     */
    public boolean isRepeats() {
        return repeats;
    }

    /**
     * Sets the value of the repeats property.
     * 
     */
    public void setRepeats(boolean value) {
        this.repeats = value;
    }

}
