/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pics;

import com.jhlabs.image.BorderFilter;
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
public class ResizePics {

    public static void main(String[] arg) throws IOException {
        for (int i = 47950; i < 49100; i++) {
            File inputImage = null;
            BufferedImage biInput;

            try {
                inputImage = new File("C://keyPics/" + i + ".jpg");
                biInput = ImageIO.read(inputImage);
            } catch (Exception ex) {
                //ex.printStackTrace();
                continue;
            }
            try {
                File imageLayer400 = new File("C://400.jpg");
                File imageLayer200 = new File("C://200.jpg");
                File imageLayer160 = new File("C://160.jpg");
                File imageLayer75 = new File("C://75.jpg");

                BufferedImage bi400 = ImageIO.read(imageLayer400);
                BufferedImage bi200 = ImageIO.read(imageLayer200);
                BufferedImage bi160 = ImageIO.read(imageLayer160);
                BufferedImage bi75 = ImageIO.read(imageLayer75);

                File outImage400 = new File("C://keyOut/" + i + "-400.jpg");
                File outImage200 = new File("C://keyOut/" + i + "-200.jpg");
                File outImage160 = new File("C://keyOut/" + i + "-160.jpg");
                File outImage75 = new File("C://keyOut/" + i + "-75.jpg");
                //System.out.println(i);

                int resizeCountW, resizeCountH;
                if (biInput.getHeight() >= biInput.getWidth()) {
                    System.out.println(i + " -> H > W");
                    if (biInput.getHeight() >= 300) {
                        resizeCountH = 290;
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    } else {
                        resizeCountH = biInput.getHeight();
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    }
                } else {
                    System.out.println(i + " -> H < W");
                    if (biInput.getWidth() >= 400) {
                        resizeCountW = 390;
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    } else {
                        resizeCountW = biInput.getWidth();
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    }
                }

                ResampleOp resampleOp = new ResampleOp(resizeCountH, resizeCountW);
                resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                BufferedImage rescaledImg = resampleOp.filter(biInput, null);
                BorderFilter bf = new BorderFilter();
                bf.setLeftBorder((400 - rescaledImg.getWidth()) / 2);
                bf.setRightBorder((300 - rescaledImg.getHeight()) / 2);
                ImagesUtils.saveImage(bf.filter(rescaledImg, bi400), outImage400, ImagesUtils.IMAGE_JPEG);

                if (biInput.getHeight() >= biInput.getWidth()) {
                    if (biInput.getHeight() >= 150) {
                        resizeCountH = 140;
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    } else {
                        resizeCountH = biInput.getHeight();
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    }
                } else {
                    if (biInput.getWidth() >= 200) {
                        resizeCountW = 190;
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    } else {
                        resizeCountW = biInput.getWidth();
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    }
                }

                resampleOp = new ResampleOp(resizeCountH, resizeCountW);
                resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                rescaledImg = resampleOp.filter(biInput, null);
                bf = new BorderFilter();
                bf.setLeftBorder((200 - rescaledImg.getWidth()) / 2);
                bf.setRightBorder((150 - rescaledImg.getHeight()) / 2);
                ImagesUtils.saveImage(bf.filter(rescaledImg, bi200), outImage200, ImagesUtils.IMAGE_JPEG);

                if (biInput.getHeight() >= biInput.getWidth()) {
                    if (biInput.getHeight() >= 160) {
                        resizeCountH = 150;
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    } else {
                        resizeCountH = biInput.getHeight();
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    }
                } else {
                    if (biInput.getWidth() >= 160) {
                        resizeCountW = 150;
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    } else {
                        resizeCountW = biInput.getWidth();
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    }
                }

                resampleOp = new ResampleOp(resizeCountH, resizeCountW);
                resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                rescaledImg = resampleOp.filter(biInput, null);
                bf = new BorderFilter();
                bf.setLeftBorder((160 - rescaledImg.getWidth()) / 2);
                bf.setRightBorder((160 - rescaledImg.getHeight()) / 2);
                ImagesUtils.saveImage(bf.filter(rescaledImg, bi160), outImage160, ImagesUtils.IMAGE_JPEG);

                if (biInput.getHeight() >= biInput.getWidth()) {
                    if (biInput.getHeight() >= 56) {
                        resizeCountH = 50;
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    } else {
                        resizeCountH = biInput.getHeight();
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                    }
                } else {
                    if (biInput.getWidth() >= 75) {
                        resizeCountW = 70;
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    } else {
                        resizeCountW = biInput.getWidth();
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                    }
                }

                resampleOp = new ResampleOp(resizeCountH, resizeCountW);
                resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                rescaledImg = resampleOp.filter(biInput, null);
                bf = new BorderFilter();
                bf.setLeftBorder((75 - rescaledImg.getWidth()) / 2);
                bf.setRightBorder((56 - rescaledImg.getHeight()) / 2);
                ImagesUtils.saveImage(bf.filter(rescaledImg, bi75), outImage75, ImagesUtils.IMAGE_JPEG);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}


