
package com.vmware.vim25;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileFault">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:vim25}VimFault">
 *       &lt;sequence>
 *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileFault", propOrder = {
    "file"
})
@XmlSeeAlso({
    NetworkCopyFault.class,
    FileNotFound.class,
    FileLocked.class,
    CannotCreateFile.class,
    FileNameTooLong.class,
    FileNotWritable.class,
    CannotAccessFile.class,
    FileTooLarge.class,
    NotADirectory.class,
    TooManyConcurrentNativeClones.class,
    CannotDeleteFile.class,
    IncorrectFileType.class,
    NoDiskSpace.class,
    NotAFile.class,
    TooManyNativeClonesOnFile.class,
    TooManyNativeCloneLevels.class,
    FileAlreadyExists.class,
    DirectoryNotEmpty.class
})
public class FileFault
    extends VimFault
{

    @XmlElement(required = true)
    protected String file;

    /**
     * Gets the value of the file property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFile(String value) {
        this.file = value;
    }

}
