//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.12 at 06:46:57 PM SGT 
//


package aero.champ.cargospot.cargomax.dummy.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AwbStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AwbStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="KK"/>
 *     &lt;enumeration value="HK"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="NN"/>
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="UU"/>
 *     &lt;enumeration value="XX"/>
 *     &lt;enumeration value="CN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AwbStatus")
@XmlEnum
public enum AwbStatus {

    KK,
    HK,
    CA,
    NN,
    NA,
    UU,
    XX,
    CN;

    public String value() {
        return name();
    }

    public static AwbStatus fromValue(String v) {
        return valueOf(v);
    }

}
