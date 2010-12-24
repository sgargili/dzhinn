package mvc.controller.view.word;

import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: Andrey Popov
 * Date: 24.12.10
 * Time: 16:44
 */
public class WordView extends AbstractWordView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      XWPFDocument document,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        XWPFParagraph tmpParagraph = document.createParagraph();
        XWPFRun tmpRun = tmpParagraph.createRun();
        tmpRun.setUnderline(UnderlinePatterns.DASH);
        tmpRun.setText("LALALALAALALAAAA");
        tmpRun.setFontSize(18);
    }
}
