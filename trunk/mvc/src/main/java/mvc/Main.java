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
        } catch (Exception ex) {
            System.out.println("Caught an: " + ex.getClass().getName());
            System.out.println("Message: " + ex.getMessage());
            System.out.println("Localised Message: " + ex.getLocalizedMessage());
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
            file = new File(documentFolder, "2" + documentName);
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
//        File file = new File("C://FancyFoot.docx");
//        FileInputStream fis = new FileInputStream(file);
//        XWPFDocument doc = new XWPFDocument(fis);
//        XWPFHeaderFooterPolicy policy = doc.getHeaderFooterPolicy();
////        XWPFNumbering numbering = doc.getNumbering();
////		BigInteger numId = BigInteger.valueOf(1);
////		XWPFNum num = numbering.getNum(numId);
////		BigInteger abstrNumId = num.getCTNum().getAbstractNumId().getVal();
////		XWPFAbstractNum abstractNum = numbering.getAbstractNum(abstrNumId);
////		BigInteger compareAbstractNum = numbering.getIdOfAbstractNum(abstractNum);
//        XWPFFooter footer = policy.getFooter(0);
//
//        System.out.println(footer.getParagraphs().get(0).getParagraphText());
        File file = new File("C://docx/Numbering.docx");
        FileInputStream fis = new FileInputStream(file);
        XWPFDocument doc = new XWPFDocument(fis);
        XWPFNumbering numbering = doc.getNumbering();
        BigInteger numId = BigInteger.valueOf(1);
        XWPFNum num = numbering.getNum(numId);
        BigInteger abstrNumId = num.getCTNum().getAbstractNumId().getVal();
        XWPFAbstractNum abstractNum = numbering.getAbstractNum(abstrNumId);
        BigInteger compareAbstractNum = numbering.getIdOfAbstractNum(abstractNum);
    }

    public static void sss() throws IOException {
        XWPFDocument doc = new XWPFDocument();
//        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy();

//        footer.
//           doc.createTOC();
//        doc.
        CTP ctP1 = CTP.Factory.newInstance();
        CTR ctR1 = ctP1.addNewR();
        CTText t = ctR1.addNewT();
        t.setStringValue("Paragraph in Footer");


        XWPFParagraph p1 = new XWPFParagraph(ctP1, doc);
        p1.setAlignment(ParagraphAlignment.CENTER);
        p1.setBorderBottom(Borders.DOUBLE);
        p1.setBorderTop(Borders.DOUBLE);

        p1.setBorderRight(Borders.DOUBLE);
        p1.setBorderLeft(Borders.DOUBLE);
        p1.setBorderBetween(Borders.SINGLE);

        p1.setVerticalAlignment(TextAlignment.TOP);

//        XWPFRun r1 = p1.createRun();
//        r1.setBold(true);
//        r1.setText("The quick brown fox");
//        r1.setBold(true);
//        r1.setFontFamily("Courier");
//        r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
//        r1.setTextPosition(100);

        XWPFFooter footer = new XWPFFooter();
        footer.getListParagraph().add(p1);
        doc.getFooterList().add(footer);

        XWPFParagraph p2 = doc.createParagraph();
        p2.setAlignment(ParagraphAlignment.RIGHT);

        //BORDERS
        p2.setBorderBottom(Borders.DOUBLE);
        p2.setBorderTop(Borders.DOUBLE);
        p2.setBorderRight(Borders.DOUBLE);
        p2.setBorderLeft(Borders.DOUBLE);
        p2.setBorderBetween(Borders.SINGLE);

        XWPFRun r2 = p2.createRun();
        r2.setText("jumped over the lazy dog");
        r2.setStrike(true);
        r2.setFontSize(20);

        XWPFRun r3 = p2.createRun();
        r3.setText("and went away");
        r3.setStrike(true);
        r3.setFontSize(20);
        r3.setSubscript(VerticalAlign.SUPERSCRIPT);


        XWPFParagraph p3 = doc.createParagraph();
        p3.setWordWrap(true);
        p3.setPageBreak(true);

        //p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
        p3.setAlignment(ParagraphAlignment.BOTH);
        p3.setSpacingLineRule(LineSpacingRule.EXACT);

        p3.setIndentationFirstLine(600);


        XWPFRun r4 = p3.createRun();
        r4.setTextPosition(20);
        r4.setText("To be, or not to be: that is the question: "
                + "Whether 'tis nobler in the mind to suffer "
                + "The slings and arrows of outrageous fortune, "
                + "Or to take arms against a sea of troubles, "
                + "And by opposing end them? To die: to sleep; ");
        r4.addBreak(BreakType.PAGE);
        r4.setText("No more; and by a sleep to say we end "
                + "The heart-ache and the thousand natural shocks "
                + "That flesh is heir to, 'tis a consummation "
                + "Devoutly to be wish'd. To die, to sleep; "
                + "To sleep: perchance to dream: ay, there's the rub; "
                + ".......");
        r4.setItalic(true);
//This would imply that this break shall be treated as a simple line break, and break the line after that word:

        XWPFRun r5 = p3.createRun();
        r5.setTextPosition(-10);
        r5.setText("For in that sleep of death what dreams may come");
        r5.addCarriageReturn();
        r5.setText("When we have shuffled off this mortal coil,"
                + "Must give us pause: there's the respect"
                + "That makes calamity of so long life;");
        r5.addBreak();
        r5.setText("For who would bear the whips and scorns of time,"
                + "The oppressor's wrong, the proud man's contumely,");

        r5.addBreak(BreakClear.ALL);
        r5.setText("The pangs of despised love, the law's delay,"
                + "The insolence of office and the spurns" + ".......");

        FileOutputStream out = new FileOutputStream("C://simple.docx");
        doc.write(out);
        out.close();

    }

    public static void eee() throws IOException {
        File file = new File("C://test.docx");
        FileInputStream fis = new FileInputStream(file);
        XWPFDocument doc = new XWPFDocument(fis);
        XWPFHeaderFooterPolicy policy = doc.getHeaderFooterPolicy();

//        CTP ctP1 = CTP.Factory.newInstance();
//        CTR ctR1 = ctP1.addNewR();
//        CTText t = ctR1.addNewT();
//        t.setStringValue("Paragraph in Footer");
//
//        CTP ctP2 = CTP.Factory.newInstance();
//        CTR ctR2 = ctP2.addNewR();
//        CTText t2 = ctR2.addNewT();
//        t2.setStringValue("Paragraph in Footer");
//
//
//        XWPFParagraph p1 = new XWPFParagraph(ctP1, doc);
//         XWPFParagraph p2 = new XWPFParagraph(ctP2, doc);
////        p1.setAlignment(ParagraphAlignment.CENTER);
////        p1.setBorderBottom(Borders.DOUBLE);
////        p1.setBorderTop(Borders.DOUBLE);
////
////        p1.setBorderRight(Borders.DOUBLE);
////        p1.setBorderLeft(Borders.DOUBLE);
////        p1.setBorderBetween(Borders.SINGLE);
////
////        p1.setVerticalAlignment(TextAlignment.TOP);
//
//
//        XWPFParagraph[] pars = new XWPFParagraph[2];
//        pars[0] = p1;
//        pars[1] = p2;
//
        XWPFFooter footer = policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);
        doc.getFooterList().add(footer);
//        System.out.println(doc.getHeaderFooterPolicy());
        FileOutputStream out = new FileOutputStream("C://simple.docx");
        doc.write(out);
        out.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        new Main().createDocument("ffff.docx", "C://");
        eee();

    }
}