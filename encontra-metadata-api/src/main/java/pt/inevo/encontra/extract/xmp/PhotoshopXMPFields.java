package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;

/**
 * This namespace specifies properties used by Adobe Photoshop.
 * The namespace URI is http://ns.adobe.com/photoshop/1.0/
 * The preferred namespace prefix is photoshop.
 *
 * @see <a href="http://http://www.adobe.com/devnet/xmp.html">Adobe XMP Dev</a>
 */
public interface PhotoshopXMPFields {

    /**
     * The namespace URI.
     */
    public static String NS_URI = XMPConst.NS_PHOTOSHOP;

    /**
     * Photoshop specific namespace for Adobe XMP.
     */
    public static String NS_PREFIX = "photoshop:";

    /**
     * The unique identifier of a document.
     */
    public static String ANCESTOR_ID = NS_PREFIX + "AncestorID";

    /**
     * The identifying name of the text layer.
     */
    public static String LAYER_NAME = NS_PREFIX + "LayerName";

    /**
     * The text content of the text layer.
     */
    public static String LAYER_TEXT = NS_PREFIX + "LayerText";

    /**
     * By-line title.
     */
    public static String AUTHORS_POSITION = NS_PREFIX + "AuthorsPosition";

    /**
     * Writer/editor.
     */
    public static String CAPTION_WRITER = NS_PREFIX + "CaptionWriter";

    /**
     * Category. Limited to 3 7-bit ASCII characters.
     */
    public static String CATEGORY = NS_PREFIX + "Category";

    /**
     * City.
     */
    public static String CITY = NS_PREFIX + "City";

    /**
     * The colour mode. One of:
     *  0 = Bitmap
     *  1 = Gray scale
     *  2 = Indexed colour
     *  3 = RGB colour
     *  4 = CMYK colour
     *  7 = Multi-channel
     *  8 = Duotone
     *  9 = LAB colour
     */
    public static String COLOR_MODE = NS_PREFIX + "ColorMode";

    /**
     * Country/primary location.
     */
    public static String COUNTRY = NS_PREFIX + "Country";

    /**
     * Credit.
     */
    public static String CREDIT = "Credit";

    /**
     * The date the intellectual content of the document was
     * created (rather than the creation date of the physical
     * representation), following IIM conventions. For example, a
     * photo taken during the American Civil War would have a
     * creation date during that epoch (1861-1865) rather than the
     * date the photo was digitized for archiving.
     */
    public static String DATE_CREATED = NS_PREFIX + "DateCreated";

    /**
     * If the source document for a copy-and-paste or place
     * operation has a document ID, that ID is added to this list in
     * the destination document's XMP.
     */
    public static String DOCUMENT_ANCESTORS = NS_PREFIX + "DocumentAncestors";

    /**
     * Headline.
     */
    public static String HEADLINE = NS_PREFIX + "Headline";

    /**
     * The history that appears in the FileInfo panel, if activated in
     * the application preferences.
     */
    public static String HISTORY = NS_PREFIX + "History";

    /**
     * The colour profile, such as AppleRGB, AdobeRGB1998.
     */
    public static String ICC_PROFILE = NS_PREFIX + "ICCProfile";

    /**
     * Special instructions.
     */
    public static String INSTRUCTIONS = "Instructions";

    /**
     * Source.
     */
    public static String SOURCE = NS_PREFIX + "Source";

    /**
     * Province/state.
     */
    public static String STATE = "State";

    /**
     * Supplemental category.
     */
    public static String SUPPLEMENTAL_CATEGORIES = "SupplementalCategories";

    /**
     * If a document has text layers, this property caches the text
     * for each layer.
     */
    public static String TEXT_LAYERS = NS_PREFIX + "TextLayers";

    /**
     * Original transmission reference.
     */
    public static String TRANSMISSION_REFERENCE = "TransmissionReference";

    /**
     * Urgency. Valid range is 1-8.
     */
    public static String URGENCY = NS_PREFIX + "Urgency";
}
