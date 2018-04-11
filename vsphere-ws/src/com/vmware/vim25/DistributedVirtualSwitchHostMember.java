
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DistributedVirtualSwitchHostMember complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributedVirtualSwitchHostMember">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}DynamicData">
 *       &lt;sequence>
 *         &lt;element name="runtimeState" type="{urn:vim25}DistributedVirtualSwitchHostMemberRuntimeState" minOccurs="0"/>
 *         &lt;element name="config" type="{urn:vim25}DistributedVirtualSwitchHostMemberConfigInfo"/>
 *         &lt;element name="productInfo" type="{urn:vim25}DistributedVirtualSwitchProductSpec" minOccurs="0"/>
 *         &lt;element name="uplinkPortKey" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributedVirtualSwitchHostMember", propOrder = {
    "runtimeState",
    "config",
    "productInfo",
    "uplinkPortKey",
    "status",
    "statusDetail"
})
public class DistributedVirtualSwitchHostMember
    extends DynamicData
{

    protected DistributedVirtualSwitchHostMemberRuntimeState runtimeState;
    @XmlElement(required = true)
    protected DistributedVirtualSwitchHostMemberConfigInfo config;
    protected DistributedVirtualSwitchProductSpec productInfo;
    protected List<String> uplinkPortKey;
    @XmlElement(required = true)
    protected String status;
    protected String statusDetail;

    /**
     * Gets the value of the runtimeState property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchHostMemberRuntimeState }
     *     
     */
    public DistributedVirtualSwitchHostMemberRuntimeState getRuntimeState() {
        return runtimeState;
    }

    /**
     * Sets the value of the runtimeState property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchHostMemberRuntimeState }
     *     
     */
    public void setRuntimeState(DistributedVirtualSwitchHostMemberRuntimeState value) {
        this.runtimeState = value;
    }

    /**
     * Gets the value of the config property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchHostMemberConfigInfo }
     *     
     */
    public DistributedVirtualSwitchHostMemberConfigInfo getConfig() {
        return config;
    }

    /**
     * Sets the value of the config property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchHostMemberConfigInfo }
     *     
     */
    public void setConfig(DistributedVirtualSwitchHostMemberConfigInfo value) {
        this.config = value;
    }

    /**
     * Gets the value of the productInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public DistributedVirtualSwitchProductSpec getProductInfo() {
        return productInfo;
    }

    /**
     * Sets the value of the productInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistributedVirtualSwitchProductSpec }
     *     
     */
    public void setProductInfo(DistributedVirtualSwitchProductSpec value) {
        this.productInfo = value;
    }

    /**
     * Gets the value of the uplinkPortKey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uplinkPortKey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUplinkPortKey().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUplinkPortKey() {
        if (uplinkPortKey == null) {
            uplinkPortKey = new ArrayList<String>();
        }
        return this.uplinkPortKey;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDetail() {
        return statusDetail;
    }

    /**
     * Sets the value of the statusDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDetail(String value) {
        this.statusDetail = value;
    }

}
