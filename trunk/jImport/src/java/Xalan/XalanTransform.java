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

public class XalanTransform {

    public File XSLProcessor(File infile) throws TransformerException, TransformerConfigurationException, FileNotFoundException, IOException {
        File outfile = new File("temp.xml");
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource("web/simple.xsl"));
        transformer.transform(new StreamSource(infile), new StreamResult(new FileOutputStream(outfile)));
        return outfile;
    }
}
