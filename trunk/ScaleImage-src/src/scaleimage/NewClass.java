/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scaleimage;

import com.imageresize4j.ImageResizeProcessor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author APopov
 */
public class NewClass {

    public static void main(String[] args) throws IOException {
        BufferedImage sourceImage = ImageIO.read(new File("C://111.jpg"));


//Create an instance of ImageResizeProcessor class
//with the "Sharp Light" interpolation filter of length=5
        ImageResizeProcessor processor =
                new ImageResizeProcessor(ImageResizeProcessor.TYPE_SHARP_LIGHT_5);

//resize BufferedImage to the width=300px with maintaining
//the aspect ratio of the original image dimension
        BufferedImage resizedImage_1 = processor.resize(sourceImage, 300, -1);

//resize BufferedImage to the width=300px and height=200px
        BufferedImage resizedImage_2 = processor.resize(sourceImage, 196, 200);
        ImageIO.write(resizedImage_2, "jpg", new File("C://112.jpg"));
        ImageIO.write(resizedImage_1, "jpg", new File("C://1122.jpg"));
    }
}
