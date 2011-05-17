package pt.inevo.encontra.extract.xmp;

/**
 * The xmpidq namespace contains a single qualifier that defines the scheme used in the xmp:Identifier array.
 * The namespace URI shall be "http://ns.adobe.com/xmp/identifier/qual/1.0/".
 * The preferred namespace prefix is xmpidq.
 */
public interface XMPidq {

     /**
     * xmpidq main namespace URI.
     */
    public static String NS_URI = "http://ns.adobe.com/xmp/identifier/qual/1.0/";

    /**
     * xmpidq specific namespace prefix.
     */
    public static String NS_PREFIX = "xmpidq:";

    /**
     * A qualifier providing the name of the formal
     * identification scheme used for an item in the
     * xmp:Identifier array.
     */
    public static String SCHEME = NS_PREFIX + "Scheme";
}
