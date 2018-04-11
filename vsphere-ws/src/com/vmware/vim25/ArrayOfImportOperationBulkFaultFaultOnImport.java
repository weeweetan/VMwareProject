
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfImportOperationBulkFaultFaultOnImport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfImportOperationBulkFaultFaultOnImport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ImportOperationBulkFaultFaultOnImport" type="{urn:vim25}ImportOperationBulkFaultFaultOnImport" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfImportOperationBulkFaultFaultOnImport", propOrder = {
    "importOperationBulkFaultFaultOnImport"
})
public class ArrayOfImportOperationBulkFaultFaultOnImport {

    @XmlElement(name = "ImportOperationBulkFaultFaultOnImport")
    protected List<ImportOperationBulkFaultFaultOnImport> importOperationBulkFaultFaultOnImport;

    /**
     * Gets the value of the importOperationBulkFaultFaultOnImport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importOperationBulkFaultFaultOnImport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportOperationBulkFaultFaultOnImport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportOperationBulkFaultFaultOnImport }
     * 
     * 
     */
    public List<ImportOperationBulkFaultFaultOnImport> getImportOperationBulkFaultFaultOnImport() {
        if (importOperationBulkFaultFaultOnImport == null) {
            importOperationBulkFaultFaultOnImport = new ArrayList<ImportOperationBulkFaultFaultOnImport>();
        }
        return this.importOperationBulkFaultFaultOnImport;
    }

}
