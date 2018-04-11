
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MetricAlarmExpression complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MetricAlarmExpression">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}AlarmExpression">
 *       &lt;sequence>
 *         &lt;element name="operator" type="{urn:vim25}MetricAlarmOperator"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="metric" type="{urn:vim25}PerfMetricId"/>
 *         &lt;element name="yellow" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="yellowInterval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="red" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="redInterval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetricAlarmExpression", propOrder = {
    "operator",
    "type",
    "metric",
    "yellow",
    "yellowInterval",
    "red",
    "redInterval"
})
public class MetricAlarmExpression
    extends AlarmExpression
{

    @XmlElement(required = true)
    protected MetricAlarmOperator operator;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected PerfMetricId metric;
    protected Integer yellow;
    protected Integer yellowInterval;
    protected Integer red;
    protected Integer redInterval;

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link MetricAlarmOperator }
     *     
     */
    public MetricAlarmOperator getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetricAlarmOperator }
     *     
     */
    public void setOperator(MetricAlarmOperator value) {
        this.operator = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the metric property.
     * 
     * @return
     *     possible object is
     *     {@link PerfMetricId }
     *     
     */
    public PerfMetricId getMetric() {
        return metric;
    }

    /**
     * Sets the value of the metric property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerfMetricId }
     *     
     */
    public void setMetric(PerfMetricId value) {
        this.metric = value;
    }

    /**
     * Gets the value of the yellow property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYellow() {
        return yellow;
    }

    /**
     * Sets the value of the yellow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYellow(Integer value) {
        this.yellow = value;
    }

    /**
     * Gets the value of the yellowInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getYellowInterval() {
        return yellowInterval;
    }

    /**
     * Sets the value of the yellowInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setYellowInterval(Integer value) {
        this.yellowInterval = value;
    }

    /**
     * Gets the value of the red property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRed() {
        return red;
    }

    /**
     * Sets the value of the red property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRed(Integer value) {
        this.red = value;
    }

    /**
     * Gets the value of the redInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRedInterval() {
        return redInterval;
    }

    /**
     * Sets the value of the redInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRedInterval(Integer value) {
        this.redInterval = value;
    }

}
