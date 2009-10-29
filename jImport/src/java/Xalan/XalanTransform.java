package Xalan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.io.FileUtils;

public class XalanTransform {

    public File XSLProcessor(File inFile) throws TransformerException, TransformerConfigurationException, FileNotFoundException, IOException {
        File outFile = new File("C://temp.xml");
        String errorInFileFix = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><itemCard></itemCard>";
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource("web/simple_1.xsl"));
        try {
            transformer.transform(new StreamSource(inFile), new StreamResult(new FileOutputStream(outFile)));
        } catch (TransformerException e) {
            FileUtils.writeStringToFile(inFile, errorInFileFix, "UTF-8");
            transformer.transform(new StreamSource(inFile), new StreamResult(new FileOutputStream(outFile)));
        }
        return outFile;
    }
}
