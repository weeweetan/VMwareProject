
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlarmSetting complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AlarmSetting">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="toleranceRange" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reportingFrequency" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AlarmSetting", propOrder = {
    "toleranceRange",
    "reportingFrequency"
})
public class AlarmSetting
    extends DynamicData
{

    protected int toleranceRange;
    protected int reportingFrequency;

    /**
     * Gets the value of the toleranceRange property.
     * 
     */
    public int getToleranceRange() {
        return toleranceRange;
    }

    /**
     * Sets the value of the toleranceRange property.
     * 
     */
    public void setToleranceRange(int value) {
        this.toleranceRange = value;
    }

    /**
     * Gets the value of the reportingFrequency property.
     * 
     */
    public int getReportingFrequency() {
        return reportingFrequency;
    }

    /**
     * Sets the value of the reportingFrequency property.
     * 
     */
    public void setReportingFrequency(int value) {
        this.reportingFrequency = value;
    }

}
