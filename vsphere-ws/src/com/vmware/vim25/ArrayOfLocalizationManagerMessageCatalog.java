
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLocalizationManagerMessageCatalog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLocalizationManagerMessageCatalog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LocalizationManagerMessageCatalog" type="{urn:vim25}LocalizationManagerMessageCatalog" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLocalizationManagerMessageCatalog", propOrder = {
    "localizationManagerMessageCatalog"
})
public class ArrayOfLocalizationManagerMessageCatalog {

    @XmlElement(name = "LocalizationManagerMessageCatalog")
    protected List<LocalizationManagerMessageCatalog> localizationManagerMessageCatalog;

    /**
     * Gets the value of the localizationManagerMessageCatalog property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localizationManagerMessageCatalog property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalizationManagerMessageCatalog().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalizationManagerMessageCatalog }
     * 
     * 
     */
    public List<LocalizationManagerMessageCatalog> getLocalizationManagerMessageCatalog() {
        if (localizationManagerMessageCatalog == null) {
            localizationManagerMessageCatalog = new ArrayList<LocalizationManagerMessageCatalog>();
        }
        return this.localizationManagerMessageCatalog;
    }

}
