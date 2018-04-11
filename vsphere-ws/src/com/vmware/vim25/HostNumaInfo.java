
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNumaInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostNumaInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numNodes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numaNode" type="{urn:vim25}HostNumaNode" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostNumaInfo", propOrder = {
    "type",
    "numNodes",
    "numaNode"
})
public class HostNumaInfo
    extends DynamicData
{

    @XmlElement(required = true)
    protected String type;
    protected int numNodes;
    protected List<HostNumaNode> numaNode;

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
     * Gets the value of the numNodes property.
     * 
     */
    public int getNumNodes() {
        return numNodes;
    }

    /**
     * Sets the value of the numNodes property.
     * 
     */
    public void setNumNodes(int value) {
        this.numNodes = value;
    }

    /**
     * Gets the value of the numaNode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the numaNode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNumaNode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HostNumaNode }
     * 
     * 
     */
    public List<HostNumaNode> getNumaNode() {
        if (numaNode == null) {
            numaNode = new ArrayList<HostNumaNode>();
        }
        return this.numaNode;
    }

}
