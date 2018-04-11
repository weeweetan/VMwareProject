
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualAppImportSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualAppImportSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ImportSpec">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vAppConfigSpec" type="{urn:vim25}VAppConfigSpec"/>
 *         &lt;element name="resourcePoolSpec" type="{urn:vim25}ResourceConfigSpec"/>
 *         &lt;element name="child" type="{urn:vim25}ImportSpec" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualAppImportSpec", propOrder = {
    "name",
    "vAppConfigSpec",
    "resourcePoolSpec",
    "child"
})
public class VirtualAppImportSpec
    extends ImportSpec
{

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected VAppConfigSpec vAppConfigSpec;
    @XmlElement(required = true)
    protected ResourceConfigSpec resourcePoolSpec;
    protected List<ImportSpec> child;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the vAppConfigSpec property.
     * 
     * @return
     *     possible object is
     *     {@link VAppConfigSpec }
     *     
     */
    public VAppConfigSpec getVAppConfigSpec() {
        return vAppConfigSpec;
    }

    /**
     * Sets the value of the vAppConfigSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link VAppConfigSpec }
     *     
     */
    public void setVAppConfigSpec(VAppConfigSpec value) {
        this.vAppConfigSpec = value;
    }

    /**
     * Gets the value of the resourcePoolSpec property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceConfigSpec }
     *     
     */
    public ResourceConfigSpec getResourcePoolSpec() {
        return resourcePoolSpec;
    }

    /**
     * Sets the value of the resourcePoolSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceConfigSpec }
     *     
     */
    public void setResourcePoolSpec(ResourceConfigSpec value) {
        this.resourcePoolSpec = value;
    }

    /**
     * Gets the value of the child property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the child property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportSpec }
     * 
     * 
     */
    public List<ImportSpec> getChild() {
        if (child == null) {
            child = new ArrayList<ImportSpec>();
        }
        return this.child;
    }

}
