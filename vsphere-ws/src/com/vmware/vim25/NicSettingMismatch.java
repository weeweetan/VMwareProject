
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NicSettingMismatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NicSettingMismatch">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}CustomizationFault">
 *       &lt;sequence>
 *         &lt;element name="numberOfNicsInSpec" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfNicsInVM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NicSettingMismatch", propOrder = {
    "numberOfNicsInSpec",
    "numberOfNicsInVM"
})
public class NicSettingMismatch
    extends CustomizationFault
{

    protected int numberOfNicsInSpec;
    protected int numberOfNicsInVM;

    /**
     * Gets the value of the numberOfNicsInSpec property.
     * 
     */
    public int getNumberOfNicsInSpec() {
        return numberOfNicsInSpec;
    }

    /**
     * Sets the value of the numberOfNicsInSpec property.
     * 
     */
    public void setNumberOfNicsInSpec(int value) {
        this.numberOfNicsInSpec = value;
    }

    /**
     * Gets the value of the numberOfNicsInVM property.
     * 
     */
    public int getNumberOfNicsInVM() {
        return numberOfNicsInVM;
    }

    /**
     * Sets the value of the numberOfNicsInVM property.
     * 
     */
    public void setNumberOfNicsInVM(int value) {
        this.numberOfNicsInVM = value;
    }

}
