/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import xml.Html2Xml;

/**
 *
 * @author Apopov
 */
public class Html2XmlImpl implements Html2Xml {

    public File convertHtml2Xml(File inputHtmlFile) {
        File outFile = new File("C:/temp/" + System.currentTimeMillis() + ".xhtml");
        try {
            OutputStream os = new FileOutputStream(outFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, "UTF-8");
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outFile;
    }

    public File convertHtml2Xml(File inputHtmlFile, boolean deleteInputFile) {
        File outFile = new File("C://temp/" + System.currentTimeMillis() + ".xhtml");
        try {
            OutputStream os = new FileOutputStream(outFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, "UTF-8");
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (deleteInputFile) {
            inputHtmlFile.delete();
        }
        return outFile;
    }

    public File convertHtml2Xml(File inputHtmlFile, String encodingXmlFile) {
        File outFile = new File("C://temp/" + System.currentTimeMillis() + ".xhtml");
        try {
            OutputStream os = new FileOutputStream(outFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, encodingXmlFile);
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outFile;
    }

    public File convertHtml2Xml(File inputHtmlFile, String encodingXmlFile, boolean deleteInputFile) {
        File outFile = new File("C://temp/" + System.currentTimeMillis() + ".xhtml");
        try {
            OutputStream os = new FileOutputStream(outFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, encodingXmlFile);
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (deleteInputFile) {
            inputHtmlFile.delete();
        }
        return outFile;
    }

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile) {
        try {
            OutputStream os = new FileOutputStream(outputXmlFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, "UTF-8");
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outputXmlFile;
    }

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile, String encodingXmlFile) {
        try {
            OutputStream os = new FileOutputStream(outputXmlFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, encodingXmlFile);
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return outputXmlFile;
    }

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile, boolean deleteInputFile) {
        try {
            OutputStream os = new FileOutputStream(outputXmlFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, "UTF-8");
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (deleteInputFile) {
            inputHtmlFile.delete();
        }
        return outputXmlFile;
    }

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile, String encodingXmlFile, boolean deleteInputFile) {
        try {
            OutputStream os = new FileOutputStream(outputXmlFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, encodingXmlFile);
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (deleteInputFile) {
            inputHtmlFile.delete();
        }
        return outputXmlFile;
    }

    public File convertHtml2Xml(String inputHtmlString) {
        File inputHtmlFile = new File("C://temp/" + System.currentTimeMillis() + ".html");
        File outFile = new File("C://temp/" + System.currentTimeMillis() + ".xhtml");
        try {
            FileUtils.writeStringToFile(inputHtmlFile, inputHtmlString);
            OutputStream os = new FileOutputStream(outFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, "UTF-8");
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputHtmlFile.delete();
        return outFile;
    }

    public File convertHtml2Xml(String inputHtmlString, String encodingXmlFile) {
        File inputHtmlFile = new File("C://temp/" + System.currentTimeMillis() + ".html");
        File outFile = new File("C://temp/" + System.currentTimeMillis() + ".xhtml");
        try {
            FileUtils.writeStringToFile(inputHtmlFile, inputHtmlString);
            OutputStream os = new FileOutputStream(outFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, encodingXmlFile);
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputHtmlFile.delete();
        return outFile;
    }

    public File convertHtml2Xml(String inputHtmlString, String encodingInputString, String encodingXmlFile) {
        File inputHtmlFile = new File("C://temp/" + System.currentTimeMillis() + ".html");
        File outFile = new File("C://temp/" + System.currentTimeMillis() + ".xhtml");
        try {
            FileUtils.writeStringToFile(inputHtmlFile, inputHtmlString, encodingInputString);
            OutputStream os = new FileOutputStream(outFile);
            XMLReader r = new Parser();
            Writer w = new OutputStreamWriter(os, encodingXmlFile);
            ContentHandler h = new XMLWriter(w);
            r.setContentHandler(h);
            r.parse(inputHtmlFile.toURI().toString());
            w.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputHtmlFile.delete();
        return outFile;
    }
}
