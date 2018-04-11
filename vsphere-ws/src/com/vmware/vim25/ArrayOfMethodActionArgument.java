
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfMethodActionArgument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfMethodActionArgument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MethodActionArgument" type="{urn:vim25}MethodActionArgument" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfMethodActionArgument", propOrder = {
    "methodActionArgument"
})
public class ArrayOfMethodActionArgument {

    @XmlElement(name = "MethodActionArgument")
    protected List<MethodActionArgument> methodActionArgument;

    /**
     * Gets the value of the methodActionArgument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the methodActionArgument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodActionArgument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MethodActionArgument }
     * 
     * 
     */
    public List<MethodActionArgument> getMethodActionArgument() {
        if (methodActionArgument == null) {
            methodActionArgument = new ArrayList<MethodActionArgument>();
        }
        return this.methodActionArgument;
    }

}
