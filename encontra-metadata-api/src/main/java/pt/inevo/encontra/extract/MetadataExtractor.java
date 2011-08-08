package pt.inevo.encontra.extract;

import java.io.InputStream;

public interface MetadataExtractor {
    public void extractMetadata(InputStream input, Metadata metadata);
}