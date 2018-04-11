
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirtualDeviceFileBackingOption complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualDeviceFileBackingOption">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VirtualDeviceBackingOption">
 *       &lt;sequence>
 *         &lt;element name="fileNameExtensions" type="{urn:vim25}ChoiceOption" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualDeviceFileBackingOption", propOrder = {
    "fileNameExtensions"
})
@XmlSeeAlso({
    VirtualDiskFlatVer2BackingOption.class,
    VirtualCdromIsoBackingOption.class,
    VirtualDiskSeSparseBackingOption.class,
    VirtualParallelPortFileBackingOption.class,
    VirtualDiskSparseVer2BackingOption.class,
    VirtualDiskSparseVer1BackingOption.class,
    VirtualFloppyImageBackingOption.class,
    VirtualDiskFlatVer1BackingOption.class,
    VirtualSerialPortFileBackingOption.class
})
public class VirtualDeviceFileBackingOption
    extends VirtualDeviceBackingOption
{

    protected ChoiceOption fileNameExtensions;

    /**
     * Gets the value of the fileNameExtensions property.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOption }
     *     
     */
    public ChoiceOption getFileNameExtensions() {
        return fileNameExtensions;
    }

    /**
     * Sets the value of the fileNameExtensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOption }
     *     
     */
    public void setFileNameExtensions(ChoiceOption value) {
        this.fileNameExtensions = value;
    }

}
