
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiagnosticManagerLogHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiagnosticManagerLogHeader">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="lineStart" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lineEnd" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lineText" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiagnosticManagerLogHeader", propOrder = {
    "lineStart",
    "lineEnd",
    "lineText"
})
public class DiagnosticManagerLogHeader
    extends DynamicData
{

    protected int lineStart;
    protected int lineEnd;
    protected List<String> lineText;

    /**
     * Gets the value of the lineStart property.
     * 
     */
    public int getLineStart() {
        return lineStart;
    }

    /**
     * Sets the value of the lineStart property.
     * 
     */
    public void setLineStart(int value) {
        this.lineStart = value;
    }

    /**
     * Gets the value of the lineEnd property.
     * 
     */
    public int getLineEnd() {
        return lineEnd;
    }

    /**
     * Sets the value of the lineEnd property.
     * 
     */
    public void setLineEnd(int value) {
        this.lineEnd = value;
    }

    /**
     * Gets the value of the lineText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLineText() {
        if (lineText == null) {
            lineText = new ArrayList<String>();
        }
        return this.lineText;
    }

}
