//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.12 at 06:46:57 PM SGT 
//


package aero.champ.cargospot.cargomax.dummy.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BookingUpdateRS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookingUpdateRS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BookingId" type="{http://webservices.sabre.com/cargo/BookingTypes/v1}BookingID"/>
 *         &lt;element name="AwbNum" type="{http://webservices.sabre.com/cargo/BookingTypes/v1}AwbNumber"/>
 *         &lt;element name="ErrorMsg" type="{http://webservices.sabre.com/cargo/BookingTypes/v1}MessageLong" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BookingUpdateRS", propOrder = {
    "bookingId",
    "awbNum",
    "errorMsg"
})
public class BookingUpdateRS {

    @XmlElement(name = "BookingId")
    protected long bookingId;
    @XmlElement(name = "AwbNum", required = true)
    protected String awbNum;
    @XmlElement(name = "ErrorMsg")
    protected String errorMsg;

    /**
     * Gets the value of the bookingId property.
     * 
     */
    public long getBookingId() {
        return bookingId;
    }

    /**
     * Sets the value of the bookingId property.
     * 
     */
    public void setBookingId(long value) {
        this.bookingId = value;
    }

    /**
     * Gets the value of the awbNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwbNum() {
        return awbNum;
    }

    /**
     * Sets the value of the awbNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwbNum(String value) {
        this.awbNum = value;
    }

    /**
     * Gets the value of the errorMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Sets the value of the errorMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

}