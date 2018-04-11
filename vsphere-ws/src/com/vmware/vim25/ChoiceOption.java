
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChoiceOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChoiceOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}OptionType">
 *       &lt;sequence>
 *         &lt;element name="choiceInfo" type="{urn:vim25}ElementDescription" maxOccurs="unbounded"/>
 *         &lt;element name="defaultIndex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChoiceOption", propOrder = {
    "choiceInfo",
    "defaultIndex"
})
public class ChoiceOption
    extends OptionType
{

    @XmlElement(required = true)
    protected List<ElementDescription> choiceInfo;
    protected Integer defaultIndex;

    /**
     * Gets the value of the choiceInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the choiceInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChoiceInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElementDescription }
     * 
     * 
     */
    public List<ElementDescription> getChoiceInfo() {
        if (choiceInfo == null) {
            choiceInfo = new ArrayList<ElementDescription>();
        }
        return this.choiceInfo;
    }

    /**
     * Gets the value of the defaultIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultIndex() {
        return defaultIndex;
    }

    /**
     * Sets the value of the defaultIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultIndex(Integer value) {
        this.defaultIndex = value;
    }

}
