package pt.inevo.encontra.extract;

import com.adobe.xmp.XMPUtils;
import org.apache.tika.parser.image.xmp.XMPPacketScanner;
import psd.Psd;
import pt.inevo.encontra.extract.xmp.ExifTiffXMPFields;
import pt.inevo.encontra.extract.xmp.XMPExtractor;
import pt.inevo.encontra.extract.xmp.XMPFields;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.logging.Logger;

/**
 * Class that extracts metadata from PSD files.
 * @author rpd
 */
public class PSDMetadataExtractor implements MetadataExtractor {

    private static Logger log = Logger.getLogger(PSDMetadataExtractor.class.getName());

    /**
     * Extracts metadata from a PSD file.
     * @param input a stream to read the PSD file
     * @param metadata object where metadata will be stored
     */
    public void extractMetadata(InputStream input, Metadata metadata) {
        //use Tika scanner to parse the XMP metadata
        XMPPacketScanner xmpScanner = new XMPPacketScanner();
        try {
            //read the stream to a ByteArrayOutputStream to re-use it later
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            int val = 0;
            while ((val = input.read()) != -1){
                stream.write(val);
            }

            ByteArrayInputStream bufferedInput = new ByteArrayInputStream(stream.toByteArray());

            /*reads XMP Packet from psd with Tika packet scanner ands saves it as a string to a temp xml file*/
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("tmp.xml"));
            xmpScanner.parse(bufferedInput, outputStream);
            outputStream.close();

            /*Takes the temp xml file and parses the xmp metadata with XMP Core library from A*/
            InputStream inputStream = new FileInputStream("tmp.xml");
            XMPExtractor xmpExtractor = new XMPExtractor();
            xmpExtractor.extractMetadata(inputStream, metadata);

            //Parse the file with a PSD parser library to obtain more metadata
            Psd file = new Psd(new ByteArrayInputStream(stream.toByteArray()));
            metadata.set(ExifTiffXMPFields.IMAGE_WIDTH, Integer.toString(file.getWidth()));
            metadata.set(ExifTiffXMPFields.IMAGE_LENGTH, Integer.toString(file.getHeight()));
            metadata.set(MetadataAuxProperties.COLOR_DEPTH, Integer.toString(file.getDepth()));
            metadata.set(MetadataAuxProperties.CHANNELS_NUMBER, Integer.toString(file.getChannelsCount()));
            metadata.set(MetadataAuxProperties.LAYERS_NUMBER, Integer.toString(file.getLayersCount()));

            //encode the thumbnail as a base64 image
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(file.getBaseLayer().getImage(), "png", os);

            //TO DO - should we use base64 to encode the thumbnail!?
            String thumbnail = XMPUtils.encodeBase64(os.toByteArray());
            metadata.set(XMPFields.THUMBNAILS, thumbnail);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
