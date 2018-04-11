
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostFibreChannelOverEthernetHba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HostFibreChannelOverEthernetHba">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostFibreChannelHba">
 *       &lt;sequence>
 *         &lt;element name="underlyingNic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="linkInfo" type="{urn:vim25}HostFibreChannelOverEthernetHbaLinkInfo"/>
 *         &lt;element name="isSoftwareFcoe" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="markedForRemoval" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HostFibreChannelOverEthernetHba", propOrder = {
    "underlyingNic",
    "linkInfo",
    "isSoftwareFcoe",
    "markedForRemoval"
})
public class HostFibreChannelOverEthernetHba
    extends HostFibreChannelHba
{

    @XmlElement(required = true)
    protected String underlyingNic;
    @XmlElement(required = true)
    protected HostFibreChannelOverEthernetHbaLinkInfo linkInfo;
    protected boolean isSoftwareFcoe;
    protected boolean markedForRemoval;

    /**
     * Gets the value of the underlyingNic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderlyingNic() {
        return underlyingNic;
    }

    /**
     * Sets the value of the underlyingNic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderlyingNic(String value) {
        this.underlyingNic = value;
    }

    /**
     * Gets the value of the linkInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HostFibreChannelOverEthernetHbaLinkInfo }
     *     
     */
    public HostFibreChannelOverEthernetHbaLinkInfo getLinkInfo() {
        return linkInfo;
    }

    /**
     * Sets the value of the linkInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostFibreChannelOverEthernetHbaLinkInfo }
     *     
     */
    public void setLinkInfo(HostFibreChannelOverEthernetHbaLinkInfo value) {
        this.linkInfo = value;
    }

    /**
     * Gets the value of the isSoftwareFcoe property.
     * 
     */
    public boolean isIsSoftwareFcoe() {
        return isSoftwareFcoe;
    }

    /**
     * Sets the value of the isSoftwareFcoe property.
     * 
     */
    public void setIsSoftwareFcoe(boolean value) {
        this.isSoftwareFcoe = value;
    }

    /**
     * Gets the value of the markedForRemoval property.
     * 
     */
    public boolean isMarkedForRemoval() {
        return markedForRemoval;
    }

    /**
     * Sets the value of the markedForRemoval property.
     * 
     */
    public void setMarkedForRemoval(boolean value) {
        this.markedForRemoval = value;
    }

}
