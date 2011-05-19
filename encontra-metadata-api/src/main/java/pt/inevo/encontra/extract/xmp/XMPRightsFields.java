package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;

/**
 * The XMP Rights Management namespace contains properties that provide information regarding the legal
 * restrictions associated with a resource.
 * NOTE   These XMP properties are intended to provide a means of rights expression. They are not intended to provide
 * digital rights management (DRM) controls.
 * The namespace URI shall be "http://ns.adobe.com/xap/1.0/rights/".
 * The preferred namespace prefix is xmpRights.
 */
public interface XMPRightsFields {

     /**
     * XMP Rights main namespace URI.
     */
    public static String NS_URI = XMPConst.NS_XMP_RIGHTS;

    /**
     * XMP Rights specific namespace prefix.
     */
    public static String NS_PREFIX = "xmpRights" + XMPUtil.XMP_SEPARATOR;

    /**
     * A web URL for a rights management certificate.
     * NOTE   This is a normal (non-URI) simple value because of
     * historical usage.
     */
    public static String CERTIFICATE = NS_PREFIX + "Certificate";

    /**
     * When true, indicates that this is a rights-managed resource.
     * When false, indicates that this is a public-domain resource.
     * Omit if the state is unknown.
     */
    public static String MARKED = NS_PREFIX + "Marked";

    /**
     * A list of legal owners of the resource.
     */
    public static String OWNER = NS_PREFIX + "Owner";

    /**
     * A collection of text instructions on how a resource can be
     * legally used, given in a variety of languages.
     */
    public static String USAGE_TERMS = NS_PREFIX + "UsageTerms";

    /**
     * A web URL for a statement of the ownership and usage
     * rights for this resource.
     * NOTE   This is a normal (non-URI) simple value because of
     * historical usage.
     */
    public static String WEB_STATEMENT = NS_PREFIX + "WebStatement";
}
