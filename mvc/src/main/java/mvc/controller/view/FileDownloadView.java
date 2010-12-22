package mvc.controller.view;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Andrey Popov
 * Date: 21.12.10
 * Time: 17:24
 */
public class FileDownloadView extends AbstractView {
    public static final String DEFAULT_CONTENT_TYPE = "text/csv";

    private List<String> fileTypes;

//    public FileDownloadView() {
//        setContentType(DEFAULT_CONTENT_TYPE);
//    }

    public FileDownloadView(List<String> fileTypes) {
        setContentType(DEFAULT_CONTENT_TYPE);
        this.fileTypes = fileTypes;
    }

    public List<String> getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(List<String> fileTypes) {
        this.fileTypes = fileTypes;
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        File sendedFile = getFileFromModel(model);
        InputStream is = new FileInputStream(sendedFile);

        long length = sendedFile.length();
        byte[] filebytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;

        while (offset < filebytes.length && (numRead = is.read(filebytes, offset, filebytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < filebytes.length) {
            throw new IOException("Could not completely read file " + sendedFile.getName());
        }

        is.close();

        ServletOutputStream outstream = response.getOutputStream();
        response.setContentType(DEFAULT_CONTENT_TYPE);
        response.setContentLength(filebytes.length);
        response.setHeader("Content-disposition", "inline; filename=\"" + sendedFile.getName() + "\"");

        outstream.write(filebytes, 0, filebytes.length);
        outstream.flush();
    }

    private File getFileFromModel(Map<String, Object> model) {
        File file = null;
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            if ((entry.getValue() instanceof File)) {
                file = (File) entry.getValue();
            }
        }
        return file;
    }
}
