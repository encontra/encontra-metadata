package pt.inevo.encontra.extract;

import java.io.InputStream;
import java.io.OutputStream;

public interface MetadataExtractor {
    public void extractMetadata(InputStream input, Metadata metadata);
}