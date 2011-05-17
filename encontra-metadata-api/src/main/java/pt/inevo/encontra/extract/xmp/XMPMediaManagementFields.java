package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;

/**
 * The XMP Media Management namespace contains properties that provide information regarding the
 * identification, composition, and history of a resource.
 * The namespace URI shall be "http://ns.adobe.com/xap/1.0/mm/".
 * The preferred namespace prefix is xmpMM.
 *
 * The following properties are “owned” by the DAM system and should be set by applications under their
 * direction; they should not be used by unmanaged files:  xmpMM: ManagedFrom,  xmpMM:Manager,
 * xmpMM:ManageTo, xmpMM:ManageUI, xmpMM: ManagerVariant.
 * The following properties are owned by the DAM system for managed files, but can also be used by applications
 * for unmanaged files:  xmpMM:DerivedFrom,  xmpMM:DocumentID,  xmpMM: RenditionClass,  xmpMM:
 * RenditionParams, xmpMM:VersionID, xmpMM:Versions.
 * The xmpMM:History property is always owned by the application.
 *
 */
public interface XMPMediaManagementFields {

    /**
     * XMP Media Management main namespace URI.
     */
    public static String NS_URI = XMPConst.NS_XMP_MM;

    /**
     * XMP Media Management specific namespace prefix.
     */
    public static String NS_PREFIX = "xmpMM:";

    /**
     * A reference to the resource from which this one is
     * derived. This should be a minimal reference, in which
     * missing components can be assumed to be
     * unchanged.
     * See definitions of rendition (3.6) and version (3.8).
     * NOTE   A rendition might need to specify only the
     * xmpMM:InstanceID and xmpMM:RenditionClass of
     * the original.
     */
    public static String DERIVED_FROM = NS_PREFIX + "DerivedFrom";

    /**
     * The common identifier for all versions and renditions of
     * a resource. See Annex A, “(Informative) Document
     * and instance IDs” and definitions of rendition (3.6) and
     * version (3.8).
     */
    public static String DOCUMENT_ID = NS_PREFIX + "DocumentID";

    /**
     * An identifier for a specific incarnation of a resource,
     * updated each time a file is saved.
     * See Annex A, “(Informative) Document and instance
     * IDs”.
     */
    public static String INSTANCE_ID = NS_PREFIX + "InstanceID";

    /**
     * The common identifier for the original resource from
     * which the current resource is derived. For example, if
     * you save a resource to a different format, then save
     * that one to another format, each save operation should
     * generate a new xmpMM:DocumentID that uniquely
     * identifies the resource in that format, but should retain
     * the ID of the source file here.
     * See Annex A, “(Informative) Document and instance
     * IDs”.
     */
    public static String ORIGINAL_DOCUMENT_ID = NS_PREFIX + "OriginalDocumentID";

    /**
     * The rendition class name for this resource. This
     * property should be absent or set to default for a
     * resource that is not a derived rendition. See definitions
     * of rendition (3.6) and version (3.8).
     */
    public static String RENDITION_CLASS = NS_PREFIX + "RenditionClass";

    /**
     * Can be used to provide additional rendition parameters
     * that are too complex or verbose to encode in
     * xmpMM:RenditionClass.
     */
    public static String RenditionParams = NS_PREFIX + "RenditionParams";

    /**
     * High-level actions that resulted in this resource. It is
     * intended to give human readers a description of the steps
     * taken to make the changes from the previous version to this
     * one. The list should be at an abstract level; it is not
     * intended to be an exhaustive keystroke or other detailed
     * history. The description should be sufficient for metadata
     * management, as well as for workflow enhancement.
     */
    public static String HISTORY = NS_PREFIX + "History";

    /**
     * A reference to the document as it was prior to becoming
     * managed. It is set when a managed document is
     * introduced to an asset management system that does not
     * currently own it. It may or may not include references to
     * different management systems.
     */
    public static String MANAGED_FROM = NS_PREFIX + "ManagedFrom";

    /**
     * The name of the asset management system that manages
     * this resource. Along with xmpMM: ManagerVariant, it tells
     * applications which asset management system to contact
     * concerning this document.
     */
    public static String MANAGER = NS_PREFIX + "Manager";

    /**
     * A URI identifying the managed resource to the asset
     * management system; the presence of this property is the
     * formal indication that this resource is managed. The form
     * and content of this URI is private to the asset management
     * system.
     */
    public static String MANAGE_TO = NS_PREFIX + "ManageTo";

    /**
     * A URI that can be used to access information about the
     * managed resource through a web browser. It might require
     * a custom browser plug-in.
     */
    public static String MANAGE_UI = NS_PREFIX + "ManageUI";

    /**
     * Specifies a particular variant of the asset management
     * system. The format of this property is private to the specific
     * asset management system
     */
    public static String MANAGER_VARIANT = NS_PREFIX + "ManagerVariant";

    /**
     * Each array item has a structure value with a potentially
     * unique set of fields, containing extracted XMP from a
     * component. Each field is a property from the XMP of a
     * contained resource component, with all substructure
     * preserved.
     * Each pantry entry shall contain an xmpMM:InstanceID.
     * Only one copy of the pantry entry for any given
     * xmpMM:InstanceID shall be retained in the pantry.
     * Nested pantry items shall be removed from the individual
     * pantry item and promoted to the top level of the pantry.
     */
    public static String PANTRY = NS_PREFIX + "Pantry";

    /**
     * The document version identifier for this resource.
     * Each version of a document gets a new identifier, usually
     * simply by incrementing integers 1, 2, 3 . . . and so on.
     * Media management systems can have other conventions
     * or support branching which requires a more complex
     * scheme.
     */
    public static String VERSION_ID = NS_PREFIX + "VersionId";

    /**
     * The version history associated with this resource. Entry [1]
     * is the oldest known version for this document, entry [last()]
     * is the most recent version.
     * Typically, a media management system would fill in the
     * version information in the metadata on check-in.
     * It is not guaranteed that a complete history of versions from
     * the first to this one will be present in the xmpMM:Versions
     * property. Interior version information can be compressed or
     * eliminated and the version history can be truncated at
     * some point.
     */
    public static String VERSIONS = NS_PREFIX + "Versions";
}
