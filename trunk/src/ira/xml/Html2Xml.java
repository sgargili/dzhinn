/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ira.xml;

import java.io.File;

/**
 *
 * @author Apopov
 */
public interface Html2Xml {

    public File convertHtml2Xml(File inputHtmlFile);

    public File convertHtml2Xml(File inputHtmlFile, boolean deleteInputFile);

    public File convertHtml2Xml(File inputHtmlFile, String encodingXmlFile);

    public File convertHtml2Xml(File inputHtmlFile, String encodingXmlFile, boolean deleteInputFile);

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile);

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile, String encodingXmlFile);

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile, boolean deleteInputFile);

    public File convertHtml2Xml(File inputHtmlFile, File outputXmlFile, String encodingXmlFile, boolean deleteInputFile);

    public File convertHtml2Xml(String inputHtmlString);

    public File convertHtml2Xml(String inputHtmlString, String encodingXmlFile);

    public File convertHtml2Xml(String inputHtmlString, String encodingInputString, String encodingXmlFile);
}
