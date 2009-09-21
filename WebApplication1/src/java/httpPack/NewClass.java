/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package httpPack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class NewClass {

    public static void main(String[] str) throws IOException, XmlPullParserException {
//        File outFile = new File("c://out.xml");
//        FileWriter out = new FileWriter(outFile);
        HttpDAO hdao = new HttpDAO();
//        out.write(hdao.DownloadContent("http://www.nix.ru/autocatalog/pda/hp_iPAQ_hx2190b_FA673B_ABB_ACB_312MHz_192MbROM_64MbRAM_BT_CFII_SD_MMC_SDIO_3.5320x240_52417.html"));
//        out.close();
        File outFile1 = new File("c://out1.xml");
        FileWriter out1 = new FileWriter(outFile1);
        out1.write(hdao.DownloadContentPT("http://www.nix.ru/price/price.html"));
        out1.close();
//        hdao.DownloadContentPTURL("http://www.nix.ru/autocatalog/cc/asus_notebook.html");
    }
}
