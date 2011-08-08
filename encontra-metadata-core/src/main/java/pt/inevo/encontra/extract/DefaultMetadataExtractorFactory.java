package pt.inevo.encontra.extract;

/**
 * EnContRA Default Metadata Extractor
 * @author rpd
 */
public class DefaultMetadataExtractorFactory extends MetadataExtractorFactory {

    public DefaultMetadataExtractorFactory() {
        super();
        addExtractor("image/psd", PSDMetadataExtractor.class);
    }
}
