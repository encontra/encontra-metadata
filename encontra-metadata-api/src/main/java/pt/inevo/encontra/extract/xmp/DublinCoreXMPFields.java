package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringType;

/**
 * This namespace specifies properties specified by Dublin Core in XMP.
 * The namespace URI is http://purl.org/dc/elements/1.1/
 * The preferred namespace prefix is 'dc'.
 *
 * @see <a href="http://http://www.adobe.com/devnet/xmp.html">Adobe XMP Dev</a>
 */
public interface DublinCoreXMPFields {

    /**
     * XMP Dublin Core namespace URI.
     */
    public static String NS_URI = XMPConst.NS_DC;

    /**
     * Dublin Core specific namespace for Adobe XMP.
     */
    public static String NS_PREFIX = "dc:";

    /**
     * DCMI definition: An entity responsible for making contributions to the
     * resource.
     * DCMI comment: Examples of a contributor include a person, an
     * organization, or a service. Typically, the name of a contributor should be
     * used to indicate the entity.
     * XMP addition: XMP usage is a list of contributors. These contributors
     * should not include those listed in dc:creator
     */
    public static String CONTRIBUTOR = NS_PREFIX + "contributor";

    /**
     * DCMI definition: The spatial or temporal topic of the resource, the spatial
     * applicability of the resource, or the jurisdiction under which the resource is
     * relevant.
     * XMP addition: XMP usage is the extent or scope of the resource.
     */
    public static String COVERAGE = NS_PREFIX + "coverage";

    /**
     * DCMI definition: An entity primarily responsible for making the resource.
     * DCMI comment: Examples of a creator include a person, an
     * organization, or a service. Typically, the name of a creator should be used
     * to indicate the entity.
     * XMP addition: XMP usage is a list of creators. Entities should be listed in
     * order of decreasing precedence, if such order is significant.
     */
    public static String CREATOR = NS_PREFIX + "creator";

    /**
     * DCMI definition: A point or period of time associated with an event in the
     * lifecycle of the resource.
     */
    public static String DATE = NS_PREFIX + "date";

    /**
     * DCMI definition: An account of the resource.
     * XMP addition: XMP usage is a list of textual descriptions of the content
     * of the resource, given in various languages.
     */
    public static String DESCRIPTION = NS_PREFIX + "description";

    /**
     * DCMI definition: The file format, physical medium, or dimensions of the
     * resource.
     * DCMI comment: Examples of dimensions include size and duration.
     * Recommended best practice is to use a controlled vocabulary such as the
     * list of Internet Media Types [MIME].
     * XMP addition: XMP usage is a MIME type. Dimensions would be stored
     * using a media-specific property, beyond the scope of this document.
     */
    public static String FORMAT = NS_PREFIX + "format";

    /**
     * DCMI definition: An unambiguous reference to the resource within a
     * given context.
     * DCMI comment: Recommended best practice is to identify the resource
     * by means of a string conforming to a formal identification system.
     */
    public static String IDENTIFIER = NS_PREFIX + "identifier";

    /**
     * DCMI definition: A language of the resource.
     * XMP addition: XMP usage is a list of languages used in the content of
     * the resource.
     */
    public static String LANGUAGE = NS_PREFIX + "language";

    /**
     * DCMI definition: An entity responsible for making the resource available.
     * DCMI comment: Examples of a publisher include a person, an
     * organization, or a service. Typically, the name of a publisher should be
     * used to indicate the entity.
     * XMP addition: XMP usage is a list of publishers.
     */
    public static String PUBLISHER = NS_PREFIX + "publisher";

    /**
     * DCMI definition: A related resource.
     * DCMI comment: Recommended best practice is to identify the related
     * resource by means of a string conforming to a formal identification
     * system.
     * XMP addition: XMP usage is a list of related resources.
     */
    public static String RELATION = NS_PREFIX + "relation";

    /**
     * DCMI definition: Information about rights held in and over the resource.
     * DCMI comment: Typically, rights information includes a statement about
     * various property rights associated with the resource, including intellectual
     * property rights.
     * XMP addition: XMP usage is a list of informal rights statements, given in
     * various languages
     */
    public static String RIGHTS = NS_PREFIX + "rights";

    /**
     * DCMI definition: A related resource from which the described resource is
     * derived.
     * DCMI comment: The described resource may be derived from the
     * related resource in whole or in part. Recommended best practice is to
     * identify the related resource by means of a string conforming to a formal
     * identification system.
     */
    public static String SOURCE = NS_PREFIX + "source";

    /**
     * DCMI definition: The topic of the resource.
     * DCMI comment: Typically, the subject will be represented using
     * keywords, key phrases, or classification codes. Recommended best
     * practice is to use a controlled vocabulary. To describe the spatial or
     * temporal topic of the resource, use the dc:coverage element.
     * XMP addition: XMP usage is a list of descriptive phrases or keywords
     * that specify the content of the resource.
     */
    public static String SUBJECT = NS_PREFIX + "subject";

    /**
     * DCMI definition: A name given to the resource.
     * DCMI comment: Typically, a title will be a name by which the resource is
     * formally known.
     * XMP addition: XMP usage is a title or name, given in various languages.
     */
    public static String TITLE = NS_PREFIX + "title";

    /**
     * DCMI definition: The nature or genre of the resource.
     * DCMI comment: Recommended best practice is to use a controlled
     * vocabulary such as the DCMI Type Vocabulary [DCMITYPE]. To describe
     * the file format, physical medium, or dimensions of the resource, use the
     * dc:format element.
     * XMP addition: See the dc:format entry for clarification of the XMP usage
     * of that element.
     */
    public static String TYPE = NS_PREFIX + "type";
}
