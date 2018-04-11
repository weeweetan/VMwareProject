
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostActiveDirectoryInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostActiveDirectoryInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostDirectoryStoreInfo">
 *       &lt;sequence>
 *         &lt;element name="joinedDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trustedDomain" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="domainMembershipStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostActiveDirectoryInfo", propOrder = {
    "joinedDomain",
    "trustedDomain",
    "domainMembershipStatus"
})
public class HostActiveDirectoryInfo
    extends HostDirectoryStoreInfo
{

    protected String joinedDomain;
    protected List<String> trustedDomain;
    protected String domainMembershipStatus;

    /**
     * Gets the value of the joinedDomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJoinedDomain() {
        return joinedDomain;
    }

    /**
     * Sets the value of the joinedDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJoinedDomain(String value) {
        this.joinedDomain = value;
    }

    /**
     * Gets the value of the trustedDomain property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trustedDomain property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrustedDomain().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTrustedDomain() {
        if (trustedDomain == null) {
            trustedDomain = new ArrayList<String>();
        }
        return this.trustedDomain;
    }

    /**
     * Gets the value of the domainMembershipStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainMembershipStatus() {
        return domainMembershipStatus;
    }

    /**
     * Sets the value of the domainMembershipStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainMembershipStatus(String value) {
        this.domainMembershipStatus = value;
    }

}
