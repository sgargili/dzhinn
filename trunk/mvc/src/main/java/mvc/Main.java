package mvc;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.model.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import java.io.*;
import java.math.BigInteger;
import java.util.List;

/**
 * @author win user
 */
public class Main {
    public void createDocument1(String documentName, String documentFolder) {
        File file = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        XWPFDocument document = null;
        XWPFHeaderFooterPolicy hfPolicy = null;
        XWPFFooter footer = null;
        List<XWPFParagraph> footerParas = null;
        XWPFParagraph para = null;
        XWPFRun run = null;

        try {
            file = new File(documentFolder, documentName);
            fis = new FileInputStream(file);

            document = new XWPFDocument(fis);

            hfPolicy = document.getHeaderFooterPolicy();

            footer = hfPolicy.getFooter(1);

            footerParas = footer.getParagraphs();

            para = footerParas.get(0);

            CTP ctP1 = para.getCTP();

            CTR ctR1 = ctP1.addNewR();
            CTText t = ctR1.addNewT();
            t.setStringValue("Paragraph in footer");

            CTR ctR2 = ctP1.addNewR();
            CTText t2 = ctR2.addNewT();
            t2.setStringValue("Another Run in Paragraph in footer");

            CTR ctR3 = ctP1.addNewR();
            CTText t3 = ctR3.addNewT();
            t3.setStringValue("Yet another Run in Paragraph in footer");

            XWPFParagraph p1 = new XWPFParagraph(ctP1);
            XWPFParagraph[] pars = new XWPFParagraph[1];
            pars[0] = p1;

            hfPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, pars);

            documentName = "Populated Footer " + documentName;

            file = new File(documentFolder, documentName);
            fos = new FileOutputStream(file);
            document.write(fos);
        }
        catch(Exception ex) {
            System.out.println("Caught an: " + ex.getClass().getName());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Localised Message: " + ex.getLocalizedMessage());
            System.out.println("Stacktrace follows:.....");
            ex.printStackTrace(System.out);
        }
        finally {
            if(fos != null) {
                try {
                    fos.close();
                }
                catch(IOException ioEx) {
                    // I G N O R E
                }
            }
        }
    }

    public void createDocument(String documentName, String documentFolder) throws FileNotFoundException {
        File file = new File(documentFolder + documentName);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = null;
        XWPFDocument document = null;
        XWPFHeaderFooterPolicy hfPolicy = null;
        XWPFFooter footer = null;
        XWPFParagraph[] footerParas = null;
        XWPFParagraph para = null;
        XWPFRun run = null;

        try {
            document = new XWPFDocument();

            para = document.createParagraph();
            run = para.createRun();
            run.setText("This should contain the text for the first XWPFRun " +
                    "in the newly created Paragraph.");
            run.setBold(true);
            run = para.createRun();
            run.setText("It is my hope that this XWPFRun will contain the "
                    +
                    "text for the second paragraph that I have just added - " +
                    "with luck - to the newly created document.");

            hfPolicy = document.getHeaderFooterPolicy();
//           document.getDocument().getBody().setSectPr(new org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSectPrImpl(org.apache.xmlbeans.impl));
            if (hfPolicy == null) {
                hfPolicy = new XWPFHeaderFooterPolicy(document);
//                hfPolicy = document.getHeaderFooterPolicy();
            }
               hfPolicy.createFooter(XWPFHeaderFooterPolicy.FIRST);
//            hfPolicy.createFooter(
//
//                    org.openxmlformats.schemas.wordprocessingml.x2006.main.STHdrFtr.Enum.forString("Footer.")
//            );
//             hfPolicy.createWatermark("ddddddddd");
//            hfPolicy.getDefaultFooter()._getHdrFtr();
            file = new File(documentFolder, "2"+documentName);
            fos = new FileOutputStream(file);
            document.write(fos);
        } catch (Exception ex) {
            System.out.println("Caught an: " + ex.getClass().getName());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Stacktrace follows:.....");
            ex.printStackTrace(System.out);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ioEx) {
                    // I G N O R E
                }
            }
        }

    }

    public static void fff() throws IOException {
        File file = new File("C://ffff.docx");
        FileInputStream fis = new FileInputStream(file);
        XWPFDocument doc = new XWPFDocument(fis);
        XWPFHeaderFooterPolicy policy = doc.getHeaderFooterPolicy();
//        XWPFNumbering numbering = doc.getNumbering();
//		BigInteger numId = BigInteger.valueOf(1);
//		XWPFNum num = numbering.getNum(numId);
//		BigInteger abstrNumId = num.getCTNum().getAbstractNumId().getVal();
//		XWPFAbstractNum abstractNum = numbering.getAbstractNum(abstrNumId);
//		BigInteger compareAbstractNum = numbering.getIdOfAbstractNum(abstractNum);
        XWPFFooter footer = policy.getFooter(0);

        System.out.println(footer.getParagraphs().get(0).getParagraphText());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        new Main().createDocument("ffff.docx", "C://");
        fff();
    }
}