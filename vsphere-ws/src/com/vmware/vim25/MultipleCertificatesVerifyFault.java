
package com.vmware.vim25;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultipleCertificatesVerifyFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultipleCertificatesVerifyFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}HostConnectFault">
 *       &lt;sequence>
 *         &lt;element name="thumbprintData" type="{urn:vim25}MultipleCertificatesVerifyFaultThumbprintData" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultipleCertificatesVerifyFault", propOrder = {
    "thumbprintData"
})
public class MultipleCertificatesVerifyFault
    extends HostConnectFault
{

    @XmlElement(required = true)
    protected List<MultipleCertificatesVerifyFaultThumbprintData> thumbprintData;

    /**
     * Gets the value of the thumbprintData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thumbprintData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThumbprintData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultipleCertificatesVerifyFaultThumbprintData }
     * 
     * 
     */
    public List<MultipleCertificatesVerifyFaultThumbprintData> getThumbprintData() {
        if (thumbprintData == null) {
            thumbprintData = new ArrayList<MultipleCertificatesVerifyFaultThumbprintData>();
        }
        return this.thumbprintData;
    }

}
