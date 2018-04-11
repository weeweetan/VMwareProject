
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayUpdateSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayUpdateSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="operation" type="{urn:vim25}ArrayUpdateOperation"/>
 *         &lt;element name="removeKey" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayUpdateSpec", propOrder = {
    "operation",
    "removeKey"
})
@XmlSeeAlso({
    ClusterRuleSpec.class,
    VAppPropertySpec.class,
    ClusterDasVmConfigSpec.class,
    StorageDrsVmConfigSpec.class,
    ClusterGroupSpec.class,
    ClusterDpmHostConfigSpec.class,
    ClusterDrsVmConfigSpec.class,
    StorageDrsOptionSpec.class,
    VAppOvfSectionSpec.class,
    VAppProductSpec.class,
    VirtualMachineCpuIdInfoSpec.class
})
public class ArrayUpdateSpec
    extends DynamicData
{

    @XmlElement(required = true)
    protected ArrayUpdateOperation operation;
    protected Object removeKey;

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayUpdateOperation }
     *     
     */
    public ArrayUpdateOperation getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayUpdateOperation }
     *     
     */
    public void setOperation(ArrayUpdateOperation value) {
        this.operation = value;
    }

    /**
     * Gets the value of the removeKey property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRemoveKey() {
        return removeKey;
    }

    /**
     * Sets the value of the removeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRemoveKey(Object value) {
        this.removeKey = value;
    }

}
