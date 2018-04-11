
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClusterFailoverLevelAdmissionControlInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClusterFailoverLevelAdmissionControlInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}ClusterDasAdmissionControlInfo">
 *       &lt;sequence>
 *         &lt;element name="currentFailoverLevel" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClusterFailoverLevelAdmissionControlInfo", propOrder = {
    "currentFailoverLevel"
})
public class ClusterFailoverLevelAdmissionControlInfo
    extends ClusterDasAdmissionControlInfo
{

    protected int currentFailoverLevel;

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

}
