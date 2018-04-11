
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostDatastoreBrowserSearchSpec complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostDatastoreBrowserSearchSpec">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="query" type="{urn:vim25}FileQuery" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="details" type="{urn:vim25}FileQueryFlags" minOccurs="0"/>
 *         &lt;element name="searchCaseInsensitive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="matchPattern" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sortFoldersFirst" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostDatastoreBrowserSearchSpec", propOrder = {
    "query",
    "details",
    "searchCaseInsensitive",
    "matchPattern",
    "sortFoldersFirst"
})
public class HostDatastoreBrowserSearchSpec
    extends DynamicData
{

    protected List<FileQuery> query;
    protected FileQueryFlags details;
    protected Boolean searchCaseInsensitive;
    protected List<String> matchPattern;
    protected Boolean sortFoldersFirst;

    /**
     * Gets the value of the query property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the query property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileQuery }
     * 
     * 
     */
    public List<FileQuery> getQuery() {
        if (query == null) {
            query = new ArrayList<FileQuery>();
        }
        return this.query;
    }

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link FileQueryFlags }
     *     
     */
    public FileQueryFlags getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileQueryFlags }
     *     
     */
    public void setDetails(FileQueryFlags value) {
        this.details = value;
    }

    /**
     * Gets the value of the searchCaseInsensitive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSearchCaseInsensitive() {
        return searchCaseInsensitive;
    }

    /**
     * Sets the value of the searchCaseInsensitive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSearchCaseInsensitive(Boolean value) {
        this.searchCaseInsensitive = value;
    }

    /**
     * Gets the value of the matchPattern property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matchPattern property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatchPattern().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMatchPattern() {
        if (matchPattern == null) {
            matchPattern = new ArrayList<String>();
        }
        return this.matchPattern;
    }

    /**
     * Gets the value of the sortFoldersFirst property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSortFoldersFirst() {
        return sortFoldersFirst;
    }

    /**
     * Sets the value of the sortFoldersFirst property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSortFoldersFirst(Boolean value) {
        this.sortFoldersFirst = value;
    }

}
