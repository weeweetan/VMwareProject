
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumVirtualCpusExceedsLimit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumVirtualCpusExceedsLimit">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}InsufficientResourcesFault">
 *       &lt;sequence>
 *         &lt;element name="maxSupportedVcpus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumVirtualCpusExceedsLimit", propOrder = {
    "maxSupportedVcpus"
})
public class NumVirtualCpusExceedsLimit
    extends InsufficientResourcesFault
{

    protected int maxSupportedVcpus;

    /**
     * Gets the value of the maxSupportedVcpus property.
     * 
     */
    public int getMaxSupportedVcpus() {
        return maxSupportedVcpus;
    }

    /**
     * Sets the value of the maxSupportedVcpus property.
     * 
     */
    public void setMaxSupportedVcpus(int value) {
        this.maxSupportedVcpus = value;
    }

}
