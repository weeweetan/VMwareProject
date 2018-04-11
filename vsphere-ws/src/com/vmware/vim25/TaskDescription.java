
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskDescription complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskDescription">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="methodInfo" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="state" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="reason" type="{urn:vim25}TypeDescription" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskDescription", propOrder = {
    "methodInfo",
    "state",
    "reason"
})
public class TaskDescription
    extends DynamicData
{

    @XmlElement(required = true)
    protected List<ElementDescription> methodInfo;
    @XmlElement(required = true)
    protected List<ElementDescription> state;
    @XmlElement(required = true)
    protected List<TypeDescription> reason;

    /**
     * Gets the value of the methodInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the methodInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getMethodInfo() {
        if (methodInfo == null) {
            methodInfo = new ArrayList<ElementDescription>();
        }
        return this.methodInfo;
    }

    /**
     * Gets the value of the state property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the state property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getState() {
        if (state == null) {
            state = new ArrayList<ElementDescription>();
        }
        return this.state;
    }

    /**
     * Gets the value of the reason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeDescription }
     * 
     * 
     */
    public List<TypeDescription> getReason() {
        if (reason == null) {
            reason = new ArrayList<TypeDescription>();
        }
        return this.reason;
    }

}
