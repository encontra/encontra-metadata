package pt.inevo.encontra.extract;

import com.adobe.xmp.*;
import com.adobe.xmp.properties.XMPPropertyInfo;
import org.apache.tika.parser.image.xmp.XMPPacketScanner;
import psd.Psd;

import java.io.*;
import java.util.logging.Logger;

/**
 * Class that extracts metadata from PSD files.
 * @author rpd
 */
public class PSDMetadataExtractor implements MetadataExtractor {

    private static Logger log = Logger.getLogger(PSDMetadataExtractor.class.getName());

    public void extractMetadata(InputStream input, Metadata metadata) {
        XMPPacketScanner xmpScanner = new XMPPacketScanner();
        try {
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
            XMPMeta meta = XMPMetaFactory.parse(inputStream);

            //read all the xmp metadata from the file
            XMPIterator it = meta.iterator();
            while (it.hasNext()) {
                XMPPropertyInfo propInfo = (XMPPropertyInfo) it.next();
                String path = propInfo.getPath();
                Object value = propInfo.getValue();
                if (path != null && value != null) {
                    metadata.set(path, value.toString());
                }
            }

            //Parse the file with a PSD parser library to obtain more metadata
            Psd file = new Psd(new ByteArrayInputStream(stream.toByteArray()));
            metadata.set(Metadata.WIDTH, Integer.toString(file.getWidth()));
            metadata.set(Metadata.HEIGHT, Integer.toString(file.getHeight()));
            metadata.set(Metadata.DEPTH, Integer.toString(file.getDepth()));
            metadata.set(Metadata.CHANNELS_NUMBER, Integer.toString(file.getChannelsCount()));
            metadata.set(Metadata.LAYERS_NUMBER, Integer.toString(file.getLayersCount()));
            metadata.set(Metadata.THUMBNAIL, file.getBaseLayer().getImage().toString());

        } catch (XMPException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
