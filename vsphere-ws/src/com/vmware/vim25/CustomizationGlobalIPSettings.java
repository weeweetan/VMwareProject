
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomizationGlobalIPSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomizationGlobalIPSettings">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="dnsSuffixList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dnsServerList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomizationGlobalIPSettings", propOrder = {
    "dnsSuffixList",
    "dnsServerList"
})
public class CustomizationGlobalIPSettings
    extends DynamicData
{

    protected List<String> dnsSuffixList;
    protected List<String> dnsServerList;

    /**
     * Gets the value of the dnsSuffixList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dnsSuffixList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDnsSuffixList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDnsSuffixList() {
        if (dnsSuffixList == null) {
            dnsSuffixList = new ArrayList<String>();
        }
        return this.dnsSuffixList;
    }

    /**
     * Gets the value of the dnsServerList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dnsServerList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDnsServerList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDnsServerList() {
        if (dnsServerList == null) {
            dnsServerList = new ArrayList<String>();
        }
        return this.dnsServerList;
    }

}
