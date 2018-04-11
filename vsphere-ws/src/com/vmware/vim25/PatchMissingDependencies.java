
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PatchMissingDependencies complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatchMissingDependencies">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}PatchNotApplicable">
 *       &lt;sequence>
 *         &lt;element name="prerequisitePatch" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prerequisiteLib" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatchMissingDependencies", propOrder = {
    "prerequisitePatch",
    "prerequisiteLib"
})
public class PatchMissingDependencies
    extends PatchNotApplicable
{

    protected List<String> prerequisitePatch;
    protected List<String> prerequisiteLib;

    /**
     * Gets the value of the prerequisitePatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prerequisitePatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrerequisitePatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrerequisitePatch() {
        if (prerequisitePatch == null) {
            prerequisitePatch = new ArrayList<String>();
        }
        return this.prerequisitePatch;
    }

    /**
     * Gets the value of the prerequisiteLib property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prerequisiteLib property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrerequisiteLib().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrerequisiteLib() {
        if (prerequisiteLib == null) {
            prerequisiteLib = new ArrayList<String>();
        }
        return this.prerequisiteLib;
    }

}
