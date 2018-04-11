
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VmfsDatastoreOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VmfsDatastoreOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="info" type="{urn:vim25}VmfsDatastoreBaseOption"/>
 *         &lt;element name="spec" type="{urn:vim25}VmfsDatastoreSpec"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmfsDatastoreOption", propOrder = {
    "info",
    "spec"
})
public class VmfsDatastoreOption
    extends DynamicData
{

    @XmlElement(required = true)
    protected VmfsDatastoreBaseOption info;
    @XmlElement(required = true)
    protected VmfsDatastoreSpec spec;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link VmfsDatastoreBaseOption }
     *     
     */
    public VmfsDatastoreBaseOption getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmfsDatastoreBaseOption }
     *     
     */
    public void setInfo(VmfsDatastoreBaseOption value) {
        this.info = value;
    }

    /**
     * Gets the value of the spec property.
     * 
     * @return
     *     possible object is
     *     {@link VmfsDatastoreSpec }
     *     
     */
    public VmfsDatastoreSpec getSpec() {
        return spec;
    }

    /**
     * Sets the value of the spec property.
     * 
     * @param value
     *     allowed object is
     *     {@link VmfsDatastoreSpec }
     *     
     */
    public void setSpec(VmfsDatastoreSpec value) {
        this.spec = value;
    }

}
