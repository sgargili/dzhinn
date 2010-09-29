/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpclient;

import java.io.File;

/**
 *
 * @author Apopov
 */
public interface HttpData {

    public String downloadContentAsString(String url);

    public String downloadContentAsString(String url, boolean useProxy);

    public String downloadContentAsString(String url, String inputEncoding);

    public String downloadContentAsString(String url, String inputEncoding, boolean useProxy);

    public File downloadContentAsFile(String url);

    public File downloadContentAsFile(String url, boolean useProxy);

    public File downloadContentAsFile(String url, File toFile);

    public File downloadContentAsFile(String url, File toFile, boolean useProxy);

    public File downloadContentAsFile(String url, String outputFileEncoding);

    public File downloadContentAsFile(String url, String outputFileEncoding, File toFile);

    public File downloadContentAsFile(String url, String outputFileEncoding, boolean useProxy);

    public File downloadContentAsFile(String url, String outputFileEncoding, File toFile, boolean useProxy);

    public File downloadContentAsFile(String url, String inputEncoding, String outputFileEncoding);

    public File downloadContentAsFile(String url, String inputEncoding, String outputFileEncoding, File toFile);

    public File downloadContentAsFile(String url, String inputEncoding, String outputFileEncoding, boolean useProxy);

    public File downloadContentAsFile(String url, String inputEncoding, String outputFileEncoding, boolean useProxy, String ip);

    public File downloadContentAsFile(String url, String inputEncoding, String outputFileEncoding, File toFile, boolean useProxy);

    public void DownloadBinaryFile(String url, boolean useProxy, String fileName);
}
