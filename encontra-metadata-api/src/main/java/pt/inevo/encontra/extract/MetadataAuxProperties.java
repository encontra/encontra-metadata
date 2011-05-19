package pt.inevo.encontra.extract;

import com.adobe.xmp.XMPConst;
import pt.inevo.encontra.extract.xmp.XMPUtil;

public interface MetadataAuxProperties {

    /**
     * The namespace URI.
     */
    public static String NS_URI = "http://inevo.pt/encontra/metadata/1.0/";

    /**
     * Photoshop specific namespace for Adobe XMP.
     */
    public static String NS_PREFIX = "encontraMM" + XMPUtil.XMP_SEPARATOR;

    public static String COLOR_DEPTH = NS_PREFIX + "ColorDepth";

    public static String CHANNELS_NUMBER = NS_PREFIX + "Channels";

    public static String LAYERS_NUMBER = NS_PREFIX + "Layers";
}
