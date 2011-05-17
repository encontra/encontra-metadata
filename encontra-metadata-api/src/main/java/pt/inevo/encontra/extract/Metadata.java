package pt.inevo.encontra.extract;

/**
 * Class that holds the metadata fields. For now holds the metadata inherited from Apache Tika.
 */
public class Metadata extends org.apache.tika.metadata.Metadata {

    public static String WIDTH = "width";
    public static String HEIGHT = "width";
    public static String DEPTH = "depth";
    public static String CHANNELS_NUMBER = "channels-number";
    public static String LAYERS_NUMBER = "layers-number";
    public static String THUMBNAIL = "thumbnail";
}
