package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPIterator;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.options.IteratorOptions;
import com.adobe.xmp.options.PropertyOptions;
import com.adobe.xmp.properties.XMPProperty;
import com.adobe.xmp.properties.XMPPropertyInfo;
import pt.inevo.encontra.extract.Metadata;
import pt.inevo.encontra.extract.MetadataExtractor;

import java.io.InputStream;

/*Extracts XMP metadata from a XMP stream.*/
public class XMPExtractor implements MetadataExtractor {

    /**
     * Extracts XMP metadata from the input stream.
     * @param input a xml XMP stream
     * @param metadata object where XMP metadata will be stored
     */
    public void extractMetadata(InputStream input, Metadata metadata){
        try {
            XMPMeta meta = XMPMetaFactory.parse(input);

            //read all the xmp metadata from the file
            XMPIterator it = meta.iterator();
            while (it.hasNext()) {
                XMPPropertyInfo propInfo = (XMPPropertyInfo) it.next();

                //the property is an array, so let's read all the properties
                PropertyOptions propOptions = propInfo.getOptions();
                if (propOptions.isArray()) {

                    //get the number of items in the array, to iterate over it
                    int numArrayItems = meta.countArrayItems(propInfo.getNamespace(), propInfo.getPath());

                    //set the number of elements in the array as a metadata property
                    metadata.set(propInfo.getPath(), Integer.toString(numArrayItems));

                    //XMP arrays index starts in 1, NOT 0!
                    String value = "";
                    for (int i = 1; i <= numArrayItems; i++) {
                        XMPProperty p = meta.getArrayItem(propInfo.getNamespace(), propInfo.getPath(), i);

                        //is the array property composity or anything else?
                        //TO DO - make this recursive and support complex and arbitrary metadata objects
                        if (p.getOptions().isCompositeProperty() || p.getOptions().isArray()) {

                            IteratorOptions io = new IteratorOptions();
                            io.setJustLeafnodes(true);
                            io.setJustLeafname(true);
                            XMPIterator structIt = meta.iterator(propInfo.getNamespace(), propInfo.getPath(), io);
                            while(structIt.hasNext()) {
                                XMPPropertyInfo structPropInfo = (XMPPropertyInfo) structIt.next();

                                String path = structPropInfo.getPath();
                                Object va = structPropInfo.getValue();
                                if (path != null && value != null) {
                                    metadata.add(path, va.toString());
                                }
                            }
                        } else {
                            //most common case, the property is just simple!
                            value = p.getValue().toString();
                            metadata.add(propInfo.getPath(), value);
                        }
                    }
                    it.skipSubtree();
                } else if (propOptions.isArrayAlternate()) {
                    //do nothing
                } else if (propOptions.isArrayAltText()) {
                    //do nothing
                } else if (propOptions.isArrayOrdered()) {
                    //do nothing
                } else if (propOptions.isCompositeProperty()) {
                    //composite property, iterate over all its properties
                    IteratorOptions io = new IteratorOptions();
                    io.setJustLeafnodes(true);
                    io.setJustLeafname(true);
                    XMPIterator structIt = meta.iterator(propInfo.getNamespace(), propInfo.getPath(), io);
                    while(structIt.hasNext()) {
                        XMPPropertyInfo structPropInfo = (XMPPropertyInfo) structIt.next();

                        //add the metadata property to the directory
                        String path = structPropInfo.getPath();
                        Object value = structPropInfo.getValue();
                        if (path != null && value != null) {
                            metadata.add(path, value.toString());
                        }
                    }
                } else if (propOptions.isOnlyArrayOptions()) {
                    XMPProperty p = meta.getProperty(propInfo.getNamespace(), propInfo.getPath());

                    String path = propInfo.getPath();
                    Object value = p.getValue();
                    if (path != null && value != null) {
                        metadata.add(path, value.toString());
                    }
                } else if (propOptions.isSchemaNode()) {
                    //discard because it doesn't contain any useful information (only the namespace)
                } else if (propOptions.isStruct()) {
                    //do nothing here
                } else if (propOptions.isURI()) {
                    //do nothing here
                } else if (propOptions.isSimple())/*detect if it's simple!*/{
                    String path = propInfo.getPath();
                    Object value = propInfo.getValue();
                    if (path != null && value != null) {
                        metadata.add(path, value.toString());
                    }
                }
            }
        } catch (XMPException e) {
            e.printStackTrace();
        }
    }
}
