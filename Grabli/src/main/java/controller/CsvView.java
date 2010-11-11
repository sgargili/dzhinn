package controller;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 10.11.2010
 * Time: 18:31:21
 * To change this template use File | Settings | File Templates.
 */
public class CsvView extends AbstractView {
    private int shopName;
    private String path;

    public CsvView(String path, int shopName) {
        this.path = path;
        this.shopName = shopName;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> stringObjectMap, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        File reportFile = new File(path);
        InputStream is = new FileInputStream(reportFile);
        long length = reportFile.length();
        byte[] pdfasbytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < pdfasbytes.length && (numRead = is.read(pdfasbytes, offset, pdfasbytes.length - offset)) >= 0) {
            offset += numRead;
        }
        if (offset < pdfasbytes.length) {
            throw new IOException("Could not completely read file " + reportFile.getName());
        }
        is.close();

        reportFile.delete();

        String name;

        if (shopName == 1) {
            name = "Nix";
        } else {
            name = "Fcenter";
        }

        ServletOutputStream outstream = httpServletResponse.getOutputStream();
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setContentLength(pdfasbytes.length);
        httpServletResponse.setHeader("Content-disposition", "inline; filename=\"" + name + ".csv\"");
        outstream.write(pdfasbytes, 0, pdfasbytes.length);
        outstream.flush();
    }
}