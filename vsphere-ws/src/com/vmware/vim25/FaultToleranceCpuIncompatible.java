
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FaultToleranceCpuIncompatible complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FaultToleranceCpuIncompatible">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}CpuIncompatible">
 *       &lt;sequence>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="stepping" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FaultToleranceCpuIncompatible", propOrder = {
    "model",
    "family",
    "stepping"
})
public class FaultToleranceCpuIncompatible
    extends CpuIncompatible
{

    protected boolean model;
    protected boolean family;
    protected boolean stepping;

    /**
     * Gets the value of the model property.
     * 
     */
    public boolean isModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     */
    public void setModel(boolean value) {
        this.model = value;
    }

    /**
     * Gets the value of the family property.
     * 
     */
    public boolean isFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     * 
     */
    public void setFamily(boolean value) {
        this.family = value;
    }

    /**
     * Gets the value of the stepping property.
     * 
     */
    public boolean isStepping() {
        return stepping;
    }

    /**
     * Sets the value of the stepping property.
     * 
     */
    public void setStepping(boolean value) {
        this.stepping = value;
    }

}
