
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestProcessNotFound complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GuestProcessNotFound">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}GuestOperationsFault">
 *       &lt;sequence>
 *         &lt;element name="pid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestProcessNotFound", propOrder = {
    "pid"
})
public class GuestProcessNotFound
    extends GuestOperationsFault
{

    protected long pid;

    /**
     * Gets the value of the pid property.
     * 
     */
    public long getPid() {
        return pid;
    }

    /**
     * Sets the value of the pid property.
     * 
     */
    public void setPid(long value) {
        this.pid = value;
    }

}
