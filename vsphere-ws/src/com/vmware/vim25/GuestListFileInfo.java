
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestListFileInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestListFileInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="files" type="{urn:vim25}GuestFileInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="remaining" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestListFileInfo", propOrder = {
    "files",
    "remaining"
})
public class GuestListFileInfo
    extends DynamicData
{

    protected List<GuestFileInfo> files;
    protected int remaining;

    /**
     * Gets the value of the files property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the files property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestFileInfo }
     * 
     * 
     */
    public List<GuestFileInfo> getFiles() {
        if (files == null) {
            files = new ArrayList<GuestFileInfo>();
        }
        return this.files;
    }

    /**
     * Gets the value of the remaining property.
     * 
     */
    public int getRemaining() {
        return remaining;
    }

    /**
     * Sets the value of the remaining property.
     * 
     */
    public void setRemaining(int value) {
        this.remaining = value;
    }

}
