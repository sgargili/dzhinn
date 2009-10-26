/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scaleimage;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin4DB2
 */
public class newClass1 {

    public static void main(String[] Arg) throws IOException {
        BufferedImage image = ImageIO.read(new File("C://111.jpg"));
        ResampleOp resampleOp = new ResampleOp(196, 196);
        resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
        BufferedImage rescaledTomato = resampleOp.filter(image, null);
        //BufferedImage rescaledTomato2 = mro.filter(image, null);
        ImageIO.write(rescaledTomato, "jpg", new File("C://115.jpg"));
        //ImageIO.write(rescaledTomato2, "jpg", new File("C://116.jpg"));
    }
}
