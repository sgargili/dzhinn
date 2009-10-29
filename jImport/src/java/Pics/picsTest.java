/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pics;

import HttpClient.http;
import com.jhlabs.image.BicubicScaleFilter;
import com.jhlabs.image.GaussianFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Admin4DB2
 */
public class picsTest {

    public static void main(String[] arg) throws IOException {
        http ht = new http();
        File fltemp = new File("C://pics.xml");
        File fl = ht.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportProductsImgXML.jsp?shopId=71");
        FileUtils.copyFile(fltemp, fl);
        File fl2 = new File("C://123.jpg");
        File fl3 = new File("C://1234.jpg");
        BufferedImage bi = ImageIO.read(fl2);
        ImagesUtils.saveImage(bi, fl3, 0);
        BicubicScaleFilter bf = new BicubicScaleFilter(320, 240);
        GaussianFilter gf = new GaussianFilter((float) 1);
        ImagesUtils.saveImage(bf.filter(gf.filter(bi, null), null), fl3, 0);
    }
}
