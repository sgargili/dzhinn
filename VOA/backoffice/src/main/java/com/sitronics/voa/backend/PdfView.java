package com.sitronics.voa.backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class PdfView extends AbstractView {

    private static final String PREFIX = "report";

    public PdfView() {
        setContentType("application/pdf");
    }

    protected boolean generatesDownloadContent() {
        return true;
    }

    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        HashMap<String, Object> params = new HashMap<String, Object>();

        ServletContext context = request.getSession().getServletContext();
        String path = context.getRealPath("/report/Order.pdf");

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

        ServletOutputStream outstream = response.getOutputStream();
        response.setContentType("application/pdf");
        response.setContentLength(pdfasbytes.length);
        response.setHeader("Content-disposition", "inline; filename=\"order.pdf\"");
        outstream.write(pdfasbytes, 0, pdfasbytes.length);
        outstream.flush();
    }
}
