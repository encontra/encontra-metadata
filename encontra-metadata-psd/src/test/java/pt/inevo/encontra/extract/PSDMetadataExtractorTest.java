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
    private static String _test_filename="/metadata_test.psd";

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

    /*get the value of a metadata property*/
    public String getValue(Metadata m, String propertyName) {
        if (m.isMultiValued(propertyName)) {
            String [] values = m.getValues(propertyName);
            String value = "";
            for (int i = 0; i < values.length ; i++) {
                value += values[i] + " ";
            }
            return value;
        } else {
            return m.get(propertyName);
        }
    }

    /**
     * Test of extracting metadata from a PSD file.
     */
    public void testPSDMetadataExtractor() {
        InputStream input = getClass().getResourceAsStream(_test_filename);
        Metadata metadata = new Metadata();
        metadataExtractor.extractMetadata(input, metadata);

        System.out.println("Metadata Extracted from file\n");

        //Dublin Core properties
        System.out.println("Format: " + getValue(metadata, DublinCoreXMPFields.FORMAT));
        System.out.println("Creator: " + getValue(metadata, DublinCoreXMPFields.CREATOR));
        System.out.println("Description: " + getValue(metadata, DublinCoreXMPFields.DESCRIPTION));
        System.out.println("Subject: " + getValue(metadata, DublinCoreXMPFields.SUBJECT));
        System.out.println("Title: " + getValue(metadata, DublinCoreXMPFields.TITLE));
        System.out.println("Rights: " + getValue(metadata, DublinCoreXMPFields.RIGHTS));
        System.out.println("Contributor: " + getValue(metadata, DublinCoreXMPFields.CONTRIBUTOR));
        System.out.println("Coverage: " + getValue(metadata, DublinCoreXMPFields.COVERAGE));
        System.out.println("Identifier: " + getValue(metadata, DublinCoreXMPFields.IDENTIFIER));
        System.out.println("Language: " + getValue(metadata, DublinCoreXMPFields.LANGUAGE));
        System.out.println("Publisher: " + getValue(metadata, DublinCoreXMPFields.PUBLISHER));
        System.out.println("Type: " + getValue(metadata, DublinCoreXMPFields.TYPE));
        System.out.println("Source: " + getValue(metadata, DublinCoreXMPFields.SOURCE));
        System.out.println("Relation: " + getValue(metadata, DublinCoreXMPFields.RELATION));

        System.out.println();

        //IPTC properties
        System.out.println("Scene: " + getValue(metadata, IptcXMPFields.SCENE));
        System.out.println("Subject code: " + getValue(metadata, IptcXMPFields.SUBJECT_CODE));
        System.out.println("Country code: " + getValue(metadata, IptcXMPFields.COUNTRY_CODE));
        System.out.println("Adress City: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_ADR_CITY));
        System.out.println("Ext adress: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_ADR_EXTADR));
        System.out.println("Adress country: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_ADR_CTRY));
        System.out.println("Adress pcode: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_ADR_PCODE));
        System.out.println("Adress region: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_ADR_REGION));
        System.out.println("Email work: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_EMAIL_WORK));
        System.out.println("Tel work: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_TEL_WORK));
        System.out.println("URL work: " + getValue(metadata, IptcXMPFields.CREATOR_CONTACT_URL_WORK));
        System.out.println("Intellectual genre: " + getValue(metadata, IptcXMPFields.INTELLECTUAL_GENRE));
        System.out.println("Location: " + getValue(metadata, IptcXMPFields.LOCATION));

        System.out.println();

        //Other Properties
        System.out.println("Color Mode: " + getValue(metadata, PhotoshopXMPFields.COLOR_MODE));
        System.out.println("Creator tool: " + getValue(metadata, XMPFields.CREATOR_TOOL));
        System.out.println("Modify date: " + getValue(metadata, XMPFields.MODIFY_DATE));
        System.out.println("Document id: " + getValue(metadata, XMPMediaManagementFields.DOCUMENT_ID));
        System.out.println("Instance id: " + getValue(metadata, XMPMediaManagementFields.INSTANCE_ID));
        System.out.println("Resolution Unit: " + getValue(metadata, ExifTiffXMPFields.RESOLUTION_UNIT));
        System.out.println("X Resolution: " + getValue(metadata, ExifTiffXMPFields.X_RESOLUTION));
        System.out.println("Orientation: " + getValue(metadata, ExifTiffXMPFields.ORIENTATION));
        System.out.println("Pixel X Dimension: " + getValue(metadata, ExifXMPFields.PIXEL_X_DIMENSION));
        System.out.println("Pixel Y Dimension: " + getValue(metadata, ExifXMPFields.PIXEL_Y_DIMENSION));

        System.out.println();

        System.out.println("Width: " + getValue(metadata, ExifTiffXMPFields.IMAGE_WIDTH));
        System.out.println("Height: " + getValue(metadata, ExifTiffXMPFields.IMAGE_LENGTH));
        System.out.println("Depth: " + getValue(metadata, MetadataAuxProperties.COLOR_DEPTH));
        System.out.println("Channels number: " + getValue(metadata, MetadataAuxProperties.CHANNELS_NUMBER));
        System.out.println("Layers number:" + getValue(metadata, MetadataAuxProperties.LAYERS_NUMBER));
        System.out.println("Thumbnail:" + getValue(metadata, XMPFields.THUMBNAILS));
    }
}