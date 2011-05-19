package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;

/**
 * The XMP basic namespace contains properties that provide basic descriptive information.
 * The namespace URI shall be "http://ns.adobe.com/xap/1.0/".
 * The preferred namespace prefix is xmp
 *
 * @see <a href="http://http://www.adobe.com/devnet/xmp.html">Adobe XMP Dev</a>
 */
public interface XMPFields {

     /**
     * XMP main namespace URI.
     */
    public static String NS_URI = XMPConst.NS_XMP;

    /**
     * XMP specific namespace prefix.
     */
    public static String NS_PREFIX = "xmp" + XMPUtil.XMP_SEPARATOR;

    /**
     * The base URL for relative URLs in the document content.
     * If this document contains Internet links, and those links
     * are relative, they are relative to this base URL.
     * This property provides a standard way for embedded
     * relative URLs to be interpreted by tools. Web authoring
     * tools should set the value based on their notion of where
     * URLs will be interpreted.
     */
    public static String BASE_URL = NS_PREFIX + "BaseURL";

    /**
     * The date and time the resource was created. For a digital file, this
     * need not match a file-system creation time. For a freshly created
     * resource, it should be close to that time, modulo the time taken to
     * write the file. Later file transfer, copying, and so on, may make the
     * file-system time arbitrarily different.
     */
    public static String CREATE_DATE = NS_PREFIX + "CreateDate";

    /**
     * The name of the first known tool used to create the resource.
     */
    public static String CREATOR_TOOL = NS_PREFIX + "CreatorTool";

    /**
     * An unordered array of text strings that unambiguously identify the
     * resource within a given context. An array item may be qualified with
     * xmpidq:Scheme (see 8.7, “xmpidq namespace”) to denote the
     * formal identification system to which that identifier conforms.
     * NOTE   The xmp:Identifier property was added because dc:identifier has
     * been defined in the original XMP specification as a single identifier
     * instead of as an array, and changing dc:identifier to an array would
     * break compatibility with existing XMP processors.
     */
    public static String IDENTIFIER = NS_PREFIX + "Identifier";

    /**
     * A word or short phrase that identifies a resource as a member of a
     * user-defined collection.
     * NOTE   One anticipated usage is to organize resources in a file browser
     */
    public static String LABEL = NS_PREFIX + "Label";

    /**
     * The date and time that any metadata for this resource was last
     * changed. It should be the same as or more recent than
     * xmp:ModifyDate.
     */
    public static String METADATA_DATE = NS_PREFIX + "MetadataDate";

    /**
     * The date and time the resource was last modified.
     * NOTE   The value of this property is not necessarily the same as the file’s
     * system modification date because it is typically set before the file is
     * saved.
     */
    public static String MODIFY_DATE = NS_PREFIX + "ModifyDate";

    /**
     * A short informal name for the resource.
     */
    public static String NICKNAME = NS_PREFIX + "Nickname";

    /**
     * A user-assigned rating for this file. The value shall be -1 or in the
     * range [0..5], where -1 indicates “rejected” and 0 indicates “unrated”.
     * If xmp:Rating is not present, a value of 0 may be assumed.
     * NOTE   Anticipated usage is for a typical “star rating” UI, with the addition of
     * a notion of rejection
     */
    public static String RATING = NS_PREFIX + "Rating";

    /**
     * An alternative array of thumbnail images for a file, which
     * can differ in characteristics such as size or image
     * encoding.
     */
    public static String THUMBNAILS = NS_PREFIX + "Thumbnails";
}
