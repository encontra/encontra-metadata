package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;

/**
 * The namespace name is http://ns.adobe.com/exif/1.0/aux/
 * The preferred namespace prefix is aux
 */
public interface ExifAuxXMPFields {

    /**
     * XMP Exif aux main namespace URI.
     */
    public static String NS_URI = XMPConst.NS_EXIF_AUX;

    /**
     * XMP Exif aux specific namespace prefix.
     */
    public static String NS_PREFIX = "aux" + XMPUtil.XMP_SEPARATOR;

    public static String LENS = NS_PREFIX + "Lens";

    public static String SERIAL_NUMBER = NS_PREFIX + "SerialNumber";
}
