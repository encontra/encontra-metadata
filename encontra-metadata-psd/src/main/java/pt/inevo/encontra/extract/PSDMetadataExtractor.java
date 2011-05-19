package pt.inevo.encontra.extract;

import com.adobe.xmp.*;
import com.adobe.xmp.options.IteratorOptions;
import com.adobe.xmp.options.PropertyOptions;
import com.adobe.xmp.properties.XMPProperty;
import com.adobe.xmp.properties.XMPPropertyInfo;
import org.apache.tika.parser.image.xmp.XMPPacketScanner;
import psd.Psd;
import pt.inevo.encontra.extract.xmp.ExifTiffXMPFields;
import pt.inevo.encontra.extract.xmp.XMPFields;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
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

                //the property is an array, so let's read all the properties
                PropertyOptions propOptions = propInfo.getOptions();
                if (propOptions.isArray()) {

//                    System.out.print("Array");
//                    System.out.println(" [Path: " + propInfo.getPath() + ", Value: " + propInfo.getValue() + "]");

                    int numArrayItems = meta.countArrayItems(propInfo.getNamespace(), propInfo.getPath());

                    //XMP arrays index starts in 1, NOT 0!
                    String value = "";
                    for (int i = 1; i <= numArrayItems; i++) {
                        XMPProperty p = meta.getArrayItem(propInfo.getNamespace(), propInfo.getPath(), i);
                        value = p.getValue().toString();
                        metadata.add(propInfo.getPath(), value);
                    }
                    it.skipSubtree();

                } else if (propOptions.isArrayAlternate()) {
//                    System.out.println("Array Alternate");
                } else if (propOptions.isArrayAltText()) {
//                    System.out.println("Array Alt Text");
                } else if (propOptions.isArrayOrdered()) {
//                    System.out.println("Array ordered");
                } else if (propOptions.isCompositeProperty()) {
//                    System.out.print("Composite Property");
//                    System.out.println(" [Path: " + propInfo.getPath() + ", Value: " + propInfo.getValue() + "]");

                    XMPProperty p = meta.getProperty(propInfo.getNamespace(), propInfo.getPath());
                    PropertyOptions po = p.getOptions();
                    if (po.isStruct()) {

                        IteratorOptions io = new IteratorOptions();
                        XMPIterator structIt = meta.iterator(propInfo.getNamespace(), propInfo.getPath(), io);
                        while(structIt.hasNext()) {
                            XMPPropertyInfo structPropInfo = (XMPPropertyInfo) structIt.next();

                            String path = structPropInfo.getPath();
                            Object value = structPropInfo.getValue();
                            if (path != null && value != null) {
                                metadata.add(path, value.toString());
                            }
                        }

                    } else {
                        continue;
                    }

                } else if (propOptions.isOnlyArrayOptions()) {
//                    System.out.print("Only Array Options");
//                    System.out.print(" [Path: " + propInfo.getPath() + ", Value: " + propInfo.getValue() + "] ");

                    XMPProperty p = meta.getProperty(propInfo.getNamespace(), propInfo.getPath());
//                    System.out.println(p.getValue());

                    String path = propInfo.getPath();
                    Object value = propInfo.getValue();
                    if (path != null && value != null) {
                        metadata.add(path, value.toString());
                    }
                } else if (propOptions.isSchemaNode()) {
                    //discard because it doesn't contain any useful information
                    continue;
                } else if (propOptions.isStruct()) {
//                    System.out.println("Struct");
                    continue;
                } else if (propOptions.isURI()) {
                    //discard URI's
                    continue;
                } else if (propOptions.isSimple())/*detect if it's simple!*/{
//                    System.out.print("Simple");
//                    System.out.println(" [Path: " + propInfo.getPath() + ", Value: " + propInfo.getValue() + "]");
                    String path = propInfo.getPath();
                    Object value = propInfo.getValue();
                    if (path != null && value != null) {
                        metadata.add(path, value.toString());
                    }
                }
            }

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
            String thumbnail = XMPUtils.encodeBase64(os.toByteArray());
            metadata.set(XMPFields.THUMBNAILS, thumbnail);

        } catch (XMPException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
