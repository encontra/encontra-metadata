package pt.inevo.encontra.extract;

import java.util.HashMap;
import java.util.Map;

public class MetadataExtractorFactory<T> {

    protected final static Map<String, Class> extractors = new HashMap<String, Class>();

    /**
     * Create an extractor for a specified MIME type.
     *
     * @param mimeType The MIME type of the metadata extractor
     * @return A suitable extractor, or <code>null</code> if one cannot be found
     */
    public MetadataExtractor createExtractor(String mimeType) {
        Class extractorClass = extractors.get(mimeType);
        if (extractorClass == null) {
            return null;
        } else {
            try {
                return (MetadataExtractor) extractorClass.newInstance();
            } catch (Exception ex) {
                return null;
            }
        }
    }

    /**
     * Add a mapping from the specified MIME type to an extractor.
     * Note: The extractor must have a no-argument constructor.
     *
     * @param mimeType       The MIME type of the converter
     * @param extractorClass The <code>Class</code> object for the extractor.
     */
    public void addExtractor(String mimeType, Class extractorClass) {
        extractors.put(mimeType, extractorClass);
    }

    /**
     * Remove the mapping from a specified MIME type.
     *
     * @param mimeType The MIME type to remove from the mapping.
     */
    public void removeExtractor(String mimeType) {
        extractors.remove(mimeType);
    }
}