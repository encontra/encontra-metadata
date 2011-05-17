package pt.inevo.encontra.extract;

import java.io.*;
import java.io.File;
import junit.framework.TestCase;
import org.apache.tika.metadata.DublinCore;
import pt.inevo.encontra.extract.xmp.*;

/**
 * Simple class to test the PSD MetadataExtractor.
 * @author rpd
 */
public class PSDMetadataExtractorTest extends TestCase {

    private PSDMetadataExtractor metadataExtractor;
    private static String _test_filename="/sigma.psd";
//    private static String _test_filename="/color_pill.psd";

    public PSDMetadataExtractorTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        metadataExtractor = new PSDMetadataExtractor();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of extracting metadata from a PSD file.
     */
    public void testPSDMetadataExtractor() {
        InputStream input = getClass().getResourceAsStream(_test_filename);
        Metadata metadata = new Metadata();
        metadataExtractor.extractMetadata(input, metadata);

        System.out.println("Format: " + metadata.get(DublinCoreXMPFields.FORMAT));
        System.out.println("Color Mode: " + metadata.get(PhotoshopXMPFields.COLOR_MODE));
        System.out.println("Creator tool: " + metadata.get(XMPFields.CREATOR_TOOL));
        System.out.println("Modify date: " + metadata.get(XMPFields.MODIFY_DATE));
        System.out.println("Document id: " + metadata.get(XMPMediaManagementFields.DOCUMENT_ID));
        System.out.println("Instance id: " + metadata.get(XMPMediaManagementFields.INSTANCE_ID));
        System.out.println("Resolution Unit: " + metadata.get(ExifTiffXMPFields.RESOLUTION_UNIT));
        System.out.println("X Resolution: " + metadata.get(ExifTiffXMPFields.X_RESOLUTION));
        System.out.println("Orientation: " + metadata.get(ExifTiffXMPFields.ORIENTATION));
        System.out.println("Pixel X Dimension: " + metadata.get(ExifXMPFields.PIXEL_X_DIMENSION));

        System.out.println("Width: " + metadata.get(Metadata.WIDTH));
        System.out.println("Height: " + metadata.get(Metadata.HEIGHT));
        System.out.println("Depth: " + metadata.get(Metadata.DEPTH));
        System.out.println("Channels number: " + metadata.get(Metadata.CHANNELS_NUMBER));
        System.out.println("Layers number:" + metadata.get(Metadata.LAYERS_NUMBER));
        System.out.println("Thumbnail:" + metadata.get(Metadata.THUMBNAIL));
    }
}