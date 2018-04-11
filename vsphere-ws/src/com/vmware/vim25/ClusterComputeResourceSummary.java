
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterComputeResourceSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterComputeResourceSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ComputeResourceSummary">
 *       &lt;sequence>
 *         &lt;element name="currentFailoverLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="admissionControlInfo" type="{urn:vim25}ClusterDasAdmissionControlInfo" minOccurs="0"/>
 *         &lt;element name="numVmotions" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="targetBalance" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="currentBalance" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="currentEVCModeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dasData" type="{urn:vim25}ClusterDasData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterComputeResourceSummary", propOrder = {
    "currentFailoverLevel",
    "admissionControlInfo",
    "numVmotions",
    "targetBalance",
    "currentBalance",
    "currentEVCModeKey",
    "dasData"
})
public class ClusterComputeResourceSummary
    extends ComputeResourceSummary
{

    protected int currentFailoverLevel;
    protected ClusterDasAdmissionControlInfo admissionControlInfo;
    protected int numVmotions;
    protected Integer targetBalance;
    protected Integer currentBalance;
    protected String currentEVCModeKey;
    protected ClusterDasData dasData;

    /**
     * Gets the value of the currentFailoverLevel property.
     * 
     */
    public int getCurrentFailoverLevel() {
        return currentFailoverLevel;
    }

    /**
     * Sets the value of the currentFailoverLevel property.
     * 
     */
    public void setCurrentFailoverLevel(int value) {
        this.currentFailoverLevel = value;
    }

    /**
     * Gets the value of the admissionControlInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDasAdmissionControlInfo }
     *     
     */
    public ClusterDasAdmissionControlInfo getAdmissionControlInfo() {
        return admissionControlInfo;
    }

    /**
     * Sets the value of the admissionControlInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDasAdmissionControlInfo }
     *     
     */
    public void setAdmissionControlInfo(ClusterDasAdmissionControlInfo value) {
        this.admissionControlInfo = value;
    }

    /**
     * Gets the value of the numVmotions property.
     * 
     */
    public int getNumVmotions() {
        return numVmotions;
    }

    /**
     * Sets the value of the numVmotions property.
     * 
     */
    public void setNumVmotions(int value) {
        this.numVmotions = value;
    }

    /**
     * Gets the value of the targetBalance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTargetBalance() {
        return targetBalance;
    }

    /**
     * Sets the value of the targetBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTargetBalance(Integer value) {
        this.targetBalance = value;
    }

    /**
     * Gets the value of the currentBalance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Sets the value of the currentBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCurrentBalance(Integer value) {
        this.currentBalance = value;
    }

    /**
     * Gets the value of the currentEVCModeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentEVCModeKey() {
        return currentEVCModeKey;
    }

    /**
     * Sets the value of the currentEVCModeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentEVCModeKey(String value) {
        this.currentEVCModeKey = value;
    }

    /**
     * Gets the value of the dasData property.
     * 
     * @return
     *     possible object is
     *     {@link ClusterDasData }
     *     
     */
    public ClusterDasData getDasData() {
        return dasData;
    }

    /**
     * Sets the value of the dasData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClusterDasData }
     *     
     */
    public void setDasData(ClusterDasData value) {
        this.dasData = value;
    }

}
