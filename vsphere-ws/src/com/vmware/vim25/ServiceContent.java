
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceContent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceContent">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="rootFolder" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="propertyCollector" type="{urn:vim25}ManagedObjectReference"/>
 *         &lt;element name="viewManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="about" type="{urn:vim25}AboutInfo"/>
 *         &lt;element name="setting" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="userDirectory" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="sessionManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="authorizationManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="serviceManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="perfManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="scheduledTaskManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="alarmManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="eventManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="taskManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="extensionManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="customizationSpecManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="customFieldsManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="accountManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="diagnosticManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="licenseManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="searchIndex" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="fileManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="virtualDiskManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="virtualizationManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="snmpSystem" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="vmProvisioningChecker" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="vmCompatibilityChecker" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="ovfManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="ipPoolManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="dvSwitchManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="hostProfileManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="clusterProfileManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="complianceManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="localizationManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="storageResourceManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *         &lt;element name="guestOperationsManager" type="{urn:vim25}ManagedObjectReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceContent", propOrder = {
    "rootFolder",
    "propertyCollector",
    "viewManager",
    "about",
    "setting",
    "userDirectory",
    "sessionManager",
    "authorizationManager",
    "serviceManager",
    "perfManager",
    "scheduledTaskManager",
    "alarmManager",
    "eventManager",
    "taskManager",
    "extensionManager",
    "customizationSpecManager",
    "customFieldsManager",
    "accountManager",
    "diagnosticManager",
    "licenseManager",
    "searchIndex",
    "fileManager",
    "virtualDiskManager",
    "virtualizationManager",
    "snmpSystem",
    "vmProvisioningChecker",
    "vmCompatibilityChecker",
    "ovfManager",
    "ipPoolManager",
    "dvSwitchManager",
    "hostProfileManager",
    "clusterProfileManager",
    "complianceManager",
    "localizationManager",
    "storageResourceManager",
    "guestOperationsManager"
})
public class ServiceContent
    extends DynamicData
{

    @XmlElement(required = true)
    protected ManagedObjectReference rootFolder;
    @XmlElement(required = true)
    protected ManagedObjectReference propertyCollector;
    protected ManagedObjectReference viewManager;
    @XmlElement(required = true)
    protected AboutInfo about;
    protected ManagedObjectReference setting;
    protected ManagedObjectReference userDirectory;
    protected ManagedObjectReference sessionManager;
    protected ManagedObjectReference authorizationManager;
    protected ManagedObjectReference serviceManager;
    protected ManagedObjectReference perfManager;
    protected ManagedObjectReference scheduledTaskManager;
    protected ManagedObjectReference alarmManager;
    protected ManagedObjectReference eventManager;
    protected ManagedObjectReference taskManager;
    protected ManagedObjectReference extensionManager;
    protected ManagedObjectReference customizationSpecManager;
    protected ManagedObjectReference customFieldsManager;
    protected ManagedObjectReference accountManager;
    protected ManagedObjectReference diagnosticManager;
    protected ManagedObjectReference licenseManager;
    protected ManagedObjectReference searchIndex;
    protected ManagedObjectReference fileManager;
    protected ManagedObjectReference virtualDiskManager;
    protected ManagedObjectReference virtualizationManager;
    protected ManagedObjectReference snmpSystem;
    protected ManagedObjectReference vmProvisioningChecker;
    protected ManagedObjectReference vmCompatibilityChecker;
    protected ManagedObjectReference ovfManager;
    protected ManagedObjectReference ipPoolManager;
    protected ManagedObjectReference dvSwitchManager;
    protected ManagedObjectReference hostProfileManager;
    protected ManagedObjectReference clusterProfileManager;
    protected ManagedObjectReference complianceManager;
    protected ManagedObjectReference localizationManager;
    protected ManagedObjectReference storageResourceManager;
    protected ManagedObjectReference guestOperationsManager;

    /**
     * Gets the value of the rootFolder property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getRootFolder() {
        return rootFolder;
    }

    /**
     * Sets the value of the rootFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setRootFolder(ManagedObjectReference value) {
        this.rootFolder = value;
    }

    /**
     * Gets the value of the propertyCollector property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getPropertyCollector() {
        return propertyCollector;
    }

    /**
     * Sets the value of the propertyCollector property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setPropertyCollector(ManagedObjectReference value) {
        this.propertyCollector = value;
    }

    /**
     * Gets the value of the viewManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getViewManager() {
        return viewManager;
    }

    /**
     * Sets the value of the viewManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setViewManager(ManagedObjectReference value) {
        this.viewManager = value;
    }

    /**
     * Gets the value of the about property.
     * 
     * @return
     *     possible object is
     *     {@link AboutInfo }
     *     
     */
    public AboutInfo getAbout() {
        return about;
    }

    /**
     * Sets the value of the about property.
     * 
     * @param value
     *     allowed object is
     *     {@link AboutInfo }
     *     
     */
    public void setAbout(AboutInfo value) {
        this.about = value;
    }

    /**
     * Gets the value of the setting property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSetting() {
        return setting;
    }

    /**
     * Sets the value of the setting property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSetting(ManagedObjectReference value) {
        this.setting = value;
    }

    /**
     * Gets the value of the userDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getUserDirectory() {
        return userDirectory;
    }

    /**
     * Sets the value of the userDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setUserDirectory(ManagedObjectReference value) {
        this.userDirectory = value;
    }

    /**
     * Gets the value of the sessionManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSessionManager() {
        return sessionManager;
    }

    /**
     * Sets the value of the sessionManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSessionManager(ManagedObjectReference value) {
        this.sessionManager = value;
    }

    /**
     * Gets the value of the authorizationManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getAuthorizationManager() {
        return authorizationManager;
    }

    /**
     * Sets the value of the authorizationManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setAuthorizationManager(ManagedObjectReference value) {
        this.authorizationManager = value;
    }

    /**
     * Gets the value of the serviceManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getServiceManager() {
        return serviceManager;
    }

    /**
     * Sets the value of the serviceManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setServiceManager(ManagedObjectReference value) {
        this.serviceManager = value;
    }

    /**
     * Gets the value of the perfManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getPerfManager() {
        return perfManager;
    }

    /**
     * Sets the value of the perfManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setPerfManager(ManagedObjectReference value) {
        this.perfManager = value;
    }

    /**
     * Gets the value of the scheduledTaskManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getScheduledTaskManager() {
        return scheduledTaskManager;
    }

    /**
     * Sets the value of the scheduledTaskManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setScheduledTaskManager(ManagedObjectReference value) {
        this.scheduledTaskManager = value;
    }

    /**
     * Gets the value of the alarmManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getAlarmManager() {
        return alarmManager;
    }

    /**
     * Sets the value of the alarmManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setAlarmManager(ManagedObjectReference value) {
        this.alarmManager = value;
    }

    /**
     * Gets the value of the eventManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getEventManager() {
        return eventManager;
    }

    /**
     * Sets the value of the eventManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setEventManager(ManagedObjectReference value) {
        this.eventManager = value;
    }

    /**
     * Gets the value of the taskManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getTaskManager() {
        return taskManager;
    }

    /**
     * Sets the value of the taskManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setTaskManager(ManagedObjectReference value) {
        this.taskManager = value;
    }

    /**
     * Gets the value of the extensionManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getExtensionManager() {
        return extensionManager;
    }

    /**
     * Sets the value of the extensionManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setExtensionManager(ManagedObjectReference value) {
        this.extensionManager = value;
    }

    /**
     * Gets the value of the customizationSpecManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getCustomizationSpecManager() {
        return customizationSpecManager;
    }

    /**
     * Sets the value of the customizationSpecManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setCustomizationSpecManager(ManagedObjectReference value) {
        this.customizationSpecManager = value;
    }

    /**
     * Gets the value of the customFieldsManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getCustomFieldsManager() {
        return customFieldsManager;
    }

    /**
     * Sets the value of the customFieldsManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setCustomFieldsManager(ManagedObjectReference value) {
        this.customFieldsManager = value;
    }

    /**
     * Gets the value of the accountManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getAccountManager() {
        return accountManager;
    }

    /**
     * Sets the value of the accountManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setAccountManager(ManagedObjectReference value) {
        this.accountManager = value;
    }

    /**
     * Gets the value of the diagnosticManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDiagnosticManager() {
        return diagnosticManager;
    }

    /**
     * Sets the value of the diagnosticManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDiagnosticManager(ManagedObjectReference value) {
        this.diagnosticManager = value;
    }

    /**
     * Gets the value of the licenseManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getLicenseManager() {
        return licenseManager;
    }

    /**
     * Sets the value of the licenseManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setLicenseManager(ManagedObjectReference value) {
        this.licenseManager = value;
    }

    /**
     * Gets the value of the searchIndex property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSearchIndex() {
        return searchIndex;
    }

    /**
     * Sets the value of the searchIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSearchIndex(ManagedObjectReference value) {
        this.searchIndex = value;
    }

    /**
     * Gets the value of the fileManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getFileManager() {
        return fileManager;
    }

    /**
     * Sets the value of the fileManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setFileManager(ManagedObjectReference value) {
        this.fileManager = value;
    }

    /**
     * Gets the value of the virtualDiskManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVirtualDiskManager() {
        return virtualDiskManager;
    }

    /**
     * Sets the value of the virtualDiskManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVirtualDiskManager(ManagedObjectReference value) {
        this.virtualDiskManager = value;
    }

    /**
     * Gets the value of the virtualizationManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVirtualizationManager() {
        return virtualizationManager;
    }

    /**
     * Sets the value of the virtualizationManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVirtualizationManager(ManagedObjectReference value) {
        this.virtualizationManager = value;
    }

    /**
     * Gets the value of the snmpSystem property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getSnmpSystem() {
        return snmpSystem;
    }

    /**
     * Sets the value of the snmpSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setSnmpSystem(ManagedObjectReference value) {
        this.snmpSystem = value;
    }

    /**
     * Gets the value of the vmProvisioningChecker property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVmProvisioningChecker() {
        return vmProvisioningChecker;
    }

    /**
     * Sets the value of the vmProvisioningChecker property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVmProvisioningChecker(ManagedObjectReference value) {
        this.vmProvisioningChecker = value;
    }

    /**
     * Gets the value of the vmCompatibilityChecker property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getVmCompatibilityChecker() {
        return vmCompatibilityChecker;
    }

    /**
     * Sets the value of the vmCompatibilityChecker property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setVmCompatibilityChecker(ManagedObjectReference value) {
        this.vmCompatibilityChecker = value;
    }

    /**
     * Gets the value of the ovfManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getOvfManager() {
        return ovfManager;
    }

    /**
     * Sets the value of the ovfManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setOvfManager(ManagedObjectReference value) {
        this.ovfManager = value;
    }

    /**
     * Gets the value of the ipPoolManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getIpPoolManager() {
        return ipPoolManager;
    }

    /**
     * Sets the value of the ipPoolManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setIpPoolManager(ManagedObjectReference value) {
        this.ipPoolManager = value;
    }

    /**
     * Gets the value of the dvSwitchManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getDvSwitchManager() {
        return dvSwitchManager;
    }

    /**
     * Sets the value of the dvSwitchManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setDvSwitchManager(ManagedObjectReference value) {
        this.dvSwitchManager = value;
    }

    /**
     * Gets the value of the hostProfileManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getHostProfileManager() {
        return hostProfileManager;
    }

    /**
     * Sets the value of the hostProfileManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setHostProfileManager(ManagedObjectReference value) {
        this.hostProfileManager = value;
    }

    /**
     * Gets the value of the clusterProfileManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getClusterProfileManager() {
        return clusterProfileManager;
    }

    /**
     * Sets the value of the clusterProfileManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setClusterProfileManager(ManagedObjectReference value) {
        this.clusterProfileManager = value;
    }

    /**
     * Gets the value of the complianceManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getComplianceManager() {
        return complianceManager;
    }

    /**
     * Sets the value of the complianceManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setComplianceManager(ManagedObjectReference value) {
        this.complianceManager = value;
    }

    /**
     * Gets the value of the localizationManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getLocalizationManager() {
        return localizationManager;
    }

    /**
     * Sets the value of the localizationManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setLocalizationManager(ManagedObjectReference value) {
        this.localizationManager = value;
    }

    /**
     * Gets the value of the storageResourceManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getStorageResourceManager() {
        return storageResourceManager;
    }

    /**
     * Sets the value of the storageResourceManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setStorageResourceManager(ManagedObjectReference value) {
        this.storageResourceManager = value;
    }

    /**
     * Gets the value of the guestOperationsManager property.
     * 
     * @return
     *     possible object is
     *     {@link ManagedObjectReference }
     *     
     */
    public ManagedObjectReference getGuestOperationsManager() {
        return guestOperationsManager;
    }

    /**
     * Sets the value of the guestOperationsManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link ManagedObjectReference }
     *     
     */
    public void setGuestOperationsManager(ManagedObjectReference value) {
        this.guestOperationsManager = value;
    }

}
