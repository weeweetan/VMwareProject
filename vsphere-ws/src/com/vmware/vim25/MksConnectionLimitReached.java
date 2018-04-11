
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MksConnectionLimitReached complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MksConnectionLimitReached">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InvalidState">
 *       &lt;sequence>
 *         &lt;element name="connectionLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MksConnectionLimitReached", propOrder = {
    "connectionLimit"
})
public class MksConnectionLimitReached
    extends InvalidState
{

    protected int connectionLimit;

    /**
     * Gets the value of the connectionLimit property.
     * 
     */
    public int getConnectionLimit() {
        return connectionLimit;
    }

    /**
     * Sets the value of the connectionLimit property.
     * 
     */
    public void setConnectionLimit(int value) {
        this.connectionLimit = value;
    }

}
