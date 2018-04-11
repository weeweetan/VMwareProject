
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualPCNet32Option complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualPCNet32Option">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualEthernetCardOption">
 *       &lt;sequence>
 *         &lt;element name="supportsMorphing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualPCNet32Option", propOrder = {
    "supportsMorphing"
})
public class VirtualPCNet32Option
    extends VirtualEthernetCardOption
{

    protected boolean supportsMorphing;

    /**
     * Gets the value of the supportsMorphing property.
     * 
     */
    public boolean isSupportsMorphing() {
        return supportsMorphing;
    }

    /**
     * Sets the value of the supportsMorphing property.
     * 
     */
    public void setSupportsMorphing(boolean value) {
        this.supportsMorphing = value;
    }

}
