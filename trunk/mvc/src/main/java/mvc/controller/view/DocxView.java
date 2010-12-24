package mvc.controller.view;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * User: Andrey Popov
 * Date: 24.12.10
 * Time: 16:09
 */
public class DocxView extends AbstractView {
    public static final String DEFAULT_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

    public DocxView() {
      setContentType(DEFAULT_CONTENT_TYPE);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setUnderline(UnderlinePatterns.DASH);
        tmpRun.setText("LALALALAALALAAAA");
        tmpRun.setFontSize(18);

        ServletOutputStream out = response.getOutputStream();
        document.write(out);
        out.flush();

    }
}
