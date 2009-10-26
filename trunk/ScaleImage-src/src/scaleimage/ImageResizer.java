/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scaleimage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.geom.AffineTransform;
import java.util.Map;
import java.util.HashMap;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author CyranoVR
 */
public class ImageResizer {

    public static void main(String args[]) {

        if (args.length != 3) {
            System.out.println("Usage: ImageResizer <input> <output><scale>");
            System.exit(0);
        }

        String inFile = args[0];
        String outFile = args[1];

        FileInputStream fs = null;

        try {

            float scale = Float.parseFloat(args[2]);

            fs = new FileInputStream(inFile);
            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(fs);
            BufferedImage srcImg = decoder.decodeAsBufferedImage();
            fs.close();

            AffineTransform af =
                    AffineTransform.getScaleInstance(scale, scale);

            Map hints = new HashMap();
            hints.put(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            RenderingHints rh = new RenderingHints(hints);

            AffineTransformOp transform = new AffineTransformOp(af, rh);

            BufferedImage destImg =
                    transform.createCompatibleDestImage(srcImg, srcImg.getColorModel());
            transform.filter(srcImg, destImg);

            FileOutputStream out = new FileOutputStream(outFile);

            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out,
                    JPEGCodec.getDefaultJPEGEncodeParam(destImg));

            encoder.encode(destImg);
            out.close();
            System.out.println("Saved file " + outFile);

        } catch (FileNotFoundException fnfe) {
            System.out.println("File " + inFile + " does not exist!");

        } catch (NumberFormatException nfe) {
            System.out.println("You entered " + args[2] + ". Please enter a decimal expression.");

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());

        } catch (ImageFormatException ife) {
            System.out.println("Image Format Excpetion: Could not decode " + inFile);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (fs != null) {
                    fs.close();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
