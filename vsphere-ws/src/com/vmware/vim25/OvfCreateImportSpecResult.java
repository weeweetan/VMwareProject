
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OvfCreateImportSpecResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OvfCreateImportSpecResult">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="importSpec" type="{urn:vim25}ImportSpec" minOccurs="0"/>
 *         &lt;element name="fileItem" type="{urn:vim25}OvfFileItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="warning" type="{urn:vim25}LocalizedMethodFault" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="error" type="{urn:vim25}LocalizedMethodFault" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OvfCreateImportSpecResult", propOrder = {
    "importSpec",
    "fileItem",
    "warning",
    "error"
})
public class OvfCreateImportSpecResult
    extends DynamicData
{

    protected ImportSpec importSpec;
    protected List<OvfFileItem> fileItem;
    protected List<LocalizedMethodFault> warning;
    protected List<LocalizedMethodFault> error;

    /**
     * Gets the value of the importSpec property.
     * 
     * @return
     *     possible object is
     *     {@link ImportSpec }
     *     
     */
    public ImportSpec getImportSpec() {
        return importSpec;
    }

    /**
     * Sets the value of the importSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportSpec }
     *     
     */
    public void setImportSpec(ImportSpec value) {
        this.importSpec = value;
    }

    /**
     * Gets the value of the fileItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OvfFileItem }
     * 
     * 
     */
    public List<OvfFileItem> getFileItem() {
        if (fileItem == null) {
            fileItem = new ArrayList<OvfFileItem>();
        }
        return this.fileItem;
    }

    /**
     * Gets the value of the warning property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the warning property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWarning().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizedMethodFault }
     * 
     * 
     */
    public List<LocalizedMethodFault> getWarning() {
        if (warning == null) {
            warning = new ArrayList<LocalizedMethodFault>();
        }
        return this.warning;
    }

    /**
     * Gets the value of the error property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the error property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getError().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizedMethodFault }
     * 
     * 
     */
    public List<LocalizedMethodFault> getError() {
        if (error == null) {
            error = new ArrayList<LocalizedMethodFault>();
        }
        return this.error;
    }

}
