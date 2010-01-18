/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

/**
 *
 * @author APopov
 */
public class HTMLParser {

    private static HTMLParser instance = null;

    public static HTMLParser getInstance() {
        if (instance == null) {
            instance = new HTMLParser();
        }
        return instance;
    }

    public File normalizeHTML(File tempInputPtFile, String encoding) {
        XMLReader r = new Parser();
        File tempOutputPtFile = new File("tempPT.html");
        try {
            OutputStream os = new FileOutputStream(tempOutputPtFile);
            Writer w = new OutputStreamWriter(os, encoding);
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(tempInputPtFile.toURI().toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tempOutputPtFile;
    }
}
