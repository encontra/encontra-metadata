package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;

/**
 * The namespace name is http://ns.adobe.com/tiff/1.0/
 * The preferred namespace prefix is tiff
 */
public interface ExifTiffXMPFields {

    /**
     * XMP Tiff main namespace URI.
     */
    public static String NS_URI = XMPConst.NS_TIFF;

    /**
     * XMP Tiff exif specific namespace prefix.
     */
    public static String NS_PREFIX = "tiff" + XMPUtil.XMP_SEPARATOR;

    public static String ARTIST = NS_PREFIX + "Artist";

    public static String BITS_PER_SAMPLE = NS_PREFIX + "BitsPerSample";

    public static String COMPRESSION = NS_PREFIX + "Compression";

    public static String COPYRIGHT = NS_PREFIX + "Copyright";

    public static String DATETIME = NS_PREFIX + "DateTime";

    public static String IMAGE_DESCRIPTION = NS_PREFIX + "ImageDescription";

    public static String IMAGE_LENGTH = NS_PREFIX + "ImageLength";

    public static String IMAGE_WIDTH = NS_PREFIX + "ImageWidth";

    public static String MAKE = NS_PREFIX + "Make";

    public static String MODEL = NS_PREFIX + "Model";

    public static String ORIENTATION = NS_PREFIX + "Orientation";

    public static String PHOTOMETRIC_INTERPRETATION = NS_PREFIX + "PhotometricInterpretation";

    public static String PLANAR_CONFIGURATION = NS_PREFIX + "PlanarConfiguration";

    public static String PRIMARY_CHROMATICITIES = NS_PREFIX + "PrimaryChromaticities";

    public static String REFERENCE_BLACK_WHITE = NS_PREFIX + "ReferenceBlackWhite";

    public static String RESOLUTION_UNIT = NS_PREFIX + "ResolutionUnit";

    public static String SAMPLES_PER_PIXEL = NS_PREFIX + "SamplesPerPixel";

    public static String SOFTWARE = NS_PREFIX + "Software";

    public static String TRANSFER_FUNCTION = NS_PREFIX + "TransferFunction";

    public static String WHITE_POINT = NS_PREFIX + "WhitePoint";

    public static String X_RESOLUTION = NS_PREFIX + "XResolution";

    public static String Y_RESOLUTION = NS_PREFIX + "YResolution";

    public static String Y_CB_CR_COEFFICIENTS = NS_PREFIX + "YCbCrCoefficients";

    public static String Y_CB_CR_POSITIONING = NS_PREFIX + "YCbCrPositioning";

    public static String Y_CB_CR_SAMPLING = NS_PREFIX + "YCbCrSubSampling";
}
