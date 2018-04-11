
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupAlarmAction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupAlarmAction">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}AlarmAction">
 *       &lt;sequence>
 *         &lt;element name="action" type="{urn:vim25}AlarmAction" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupAlarmAction", propOrder = {
    "action"
})
public class GroupAlarmAction
    extends AlarmAction
{

    @XmlElement(required = true)
    protected List<AlarmAction> action;

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
     * {@link AlarmAction }
     * 
     * 
     */
    public List<AlarmAction> getAction() {
        if (action == null) {
            action = new ArrayList<AlarmAction>();
        }
        return this.action;
    }

}
