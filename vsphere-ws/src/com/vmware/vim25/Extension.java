
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Extension complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Extension">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="description" type="{urn:vim25}Description"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="subjectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="server" type="{urn:vim25}ExtensionServerInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="client" type="{urn:vim25}ExtensionClientInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="taskList" type="{urn:vim25}ExtensionTaskTypeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="eventList" type="{urn:vim25}ExtensionEventTypeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="faultList" type="{urn:vim25}ExtensionFaultTypeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="privilegeList" type="{urn:vim25}ExtensionPrivilegeInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="resourceList" type="{urn:vim25}ExtensionResourceInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lastHeartbeatTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="healthInfo" type="{urn:vim25}ExtensionHealthInfo" minOccurs="0"/>
 *         &lt;element name="ovfConsumerInfo" type="{urn:vim25}ExtensionOvfConsumerInfo" minOccurs="0"/>
 *         &lt;element name="extendedProductInfo" type="{urn:vim25}ExtExtendedProductInfo" minOccurs="0"/>
 *         &lt;element name="managedEntityInfo" type="{urn:vim25}ExtManagedEntityInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="shownInSolutionManager" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="solutionManagerInfo" type="{urn:vim25}ExtSolutionManagerInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extension", propOrder = {
    "description",
    "key",
    "company",
    "type",
    "version",
    "subjectName",
    "server",
    "client",
    "taskList",
    "eventList",
    "faultList",
    "privilegeList",
    "resourceList",
    "lastHeartbeatTime",
    "healthInfo",
    "ovfConsumerInfo",
    "extendedProductInfo",
    "managedEntityInfo",
    "shownInSolutionManager",
    "solutionManagerInfo"
})
public class Extension
    extends DynamicData
{

    @XmlElement(required = true)
    protected Description description;
    @XmlElement(required = true)
    protected String key;
    protected String company;
    protected String type;
    @XmlElement(required = true)
    protected String version;
    protected String subjectName;
    protected List<ExtensionServerInfo> server;
    protected List<ExtensionClientInfo> client;
    protected List<ExtensionTaskTypeInfo> taskList;
    protected List<ExtensionEventTypeInfo> eventList;
    protected List<ExtensionFaultTypeInfo> faultList;
    protected List<ExtensionPrivilegeInfo> privilegeList;
    protected List<ExtensionResourceInfo> resourceList;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastHeartbeatTime;
    protected ExtensionHealthInfo healthInfo;
    protected ExtensionOvfConsumerInfo ovfConsumerInfo;
    protected ExtExtendedProductInfo extendedProductInfo;
    protected List<ExtManagedEntityInfo> managedEntityInfo;
    protected Boolean shownInSolutionManager;
    protected ExtSolutionManagerInfo solutionManagerInfo;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

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
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the subjectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the value of the subjectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectName(String value) {
        this.subjectName = value;
    }

    /**
     * Gets the value of the server property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the server property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionServerInfo }
     * 
     * 
     */
    public List<ExtensionServerInfo> getServer() {
        if (server == null) {
            server = new ArrayList<ExtensionServerInfo>();
        }
        return this.server;
    }

    /**
     * Gets the value of the client property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the client property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionClientInfo }
     * 
     * 
     */
    public List<ExtensionClientInfo> getClient() {
        if (client == null) {
            client = new ArrayList<ExtensionClientInfo>();
        }
        return this.client;
    }

    /**
     * Gets the value of the taskList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taskList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaskList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionTaskTypeInfo }
     * 
     * 
     */
    public List<ExtensionTaskTypeInfo> getTaskList() {
        if (taskList == null) {
            taskList = new ArrayList<ExtensionTaskTypeInfo>();
        }
        return this.taskList;
    }

    /**
     * Gets the value of the eventList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionEventTypeInfo }
     * 
     * 
     */
    public List<ExtensionEventTypeInfo> getEventList() {
        if (eventList == null) {
            eventList = new ArrayList<ExtensionEventTypeInfo>();
        }
        return this.eventList;
    }

    /**
     * Gets the value of the faultList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faultList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaultList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionFaultTypeInfo }
     * 
     * 
     */
    public List<ExtensionFaultTypeInfo> getFaultList() {
        if (faultList == null) {
            faultList = new ArrayList<ExtensionFaultTypeInfo>();
        }
        return this.faultList;
    }

    /**
     * Gets the value of the privilegeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the privilegeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrivilegeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionPrivilegeInfo }
     * 
     * 
     */
    public List<ExtensionPrivilegeInfo> getPrivilegeList() {
        if (privilegeList == null) {
            privilegeList = new ArrayList<ExtensionPrivilegeInfo>();
        }
        return this.privilegeList;
    }

    /**
     * Gets the value of the resourceList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resourceList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResourceList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionResourceInfo }
     * 
     * 
     */
    public List<ExtensionResourceInfo> getResourceList() {
        if (resourceList == null) {
            resourceList = new ArrayList<ExtensionResourceInfo>();
        }
        return this.resourceList;
    }

    /**
     * Gets the value of the lastHeartbeatTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastHeartbeatTime() {
        return lastHeartbeatTime;
    }

    /**
     * Sets the value of the lastHeartbeatTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastHeartbeatTime(XMLGregorianCalendar value) {
        this.lastHeartbeatTime = value;
    }

    /**
     * Gets the value of the healthInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionHealthInfo }
     *     
     */
    public ExtensionHealthInfo getHealthInfo() {
        return healthInfo;
    }

    /**
     * Sets the value of the healthInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionHealthInfo }
     *     
     */
    public void setHealthInfo(ExtensionHealthInfo value) {
        this.healthInfo = value;
    }

    /**
     * Gets the value of the ovfConsumerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionOvfConsumerInfo }
     *     
     */
    public ExtensionOvfConsumerInfo getOvfConsumerInfo() {
        return ovfConsumerInfo;
    }

    /**
     * Sets the value of the ovfConsumerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionOvfConsumerInfo }
     *     
     */
    public void setOvfConsumerInfo(ExtensionOvfConsumerInfo value) {
        this.ovfConsumerInfo = value;
    }

    /**
     * Gets the value of the extendedProductInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExtExtendedProductInfo }
     *     
     */
    public ExtExtendedProductInfo getExtendedProductInfo() {
        return extendedProductInfo;
    }

    /**
     * Sets the value of the extendedProductInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtExtendedProductInfo }
     *     
     */
    public void setExtendedProductInfo(ExtExtendedProductInfo value) {
        this.extendedProductInfo = value;
    }

    /**
     * Gets the value of the managedEntityInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the managedEntityInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManagedEntityInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtManagedEntityInfo }
     * 
     * 
     */
    public List<ExtManagedEntityInfo> getManagedEntityInfo() {
        if (managedEntityInfo == null) {
            managedEntityInfo = new ArrayList<ExtManagedEntityInfo>();
        }
        return this.managedEntityInfo;
    }

    /**
     * Gets the value of the shownInSolutionManager property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShownInSolutionManager() {
        return shownInSolutionManager;
    }

    /**
     * Sets the value of the shownInSolutionManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShownInSolutionManager(Boolean value) {
        this.shownInSolutionManager = value;
    }

    /**
     * Gets the value of the solutionManagerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ExtSolutionManagerInfo }
     *     
     */
    public ExtSolutionManagerInfo getSolutionManagerInfo() {
        return solutionManagerInfo;
    }

    /**
     * Sets the value of the solutionManagerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtSolutionManagerInfo }
     *     
     */
    public void setSolutionManagerInfo(ExtSolutionManagerInfo value) {
        this.solutionManagerInfo = value;
    }

}
