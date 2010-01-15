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
import javax.imageio.ImageIO;

/**
 *
 * @author Admin4DB2
 */
public class ResizePics {

//    public static void main(String[] arg) {
//        File imageLayer400;
//        File imageLayer200;
//        File imageLayer160;
//        File imageLayer75;
//
//        BufferedImage bi400;
//        BufferedImage bi200;
//        BufferedImage bi160;
//        BufferedImage bi75;
//        BufferedImage rescaledImg;
//
//        File outImage400;
//        File outImage200;
//        File outImage160;
//        File outImage75;
//
//        int resizeCountW, resizeCountH;
//
//        ResampleOp resampleOp;
//
//        boolean resize = true;
//
//        BorderFilter bf;
//
//        for (int i = 48085; i < 48086; i++) {
//            File inputImage = null;
//            BufferedImage biInput;
//
//            try {
//                inputImage = new File("C://keyPics/" + i + ".jpg");
//                biInput = ImageIO.read(inputImage);
//            } catch (Exception ex) {
//                continue;
//            }
//            try {
//                imageLayer400 = new File("C://400.jpg");
//                imageLayer200 = new File("C://200.jpg");
//                imageLayer160 = new File("C://160.jpg");
//                imageLayer75 = new File("C://75.jpg");
//
//                bi400 = ImageIO.read(imageLayer400);
//                bi200 = ImageIO.read(imageLayer200);
//                bi160 = ImageIO.read(imageLayer160);
//                bi75 = ImageIO.read(imageLayer75);
//
//                outImage400 = new File("C://keyOut/" + i + "-400.jpg");
//                outImage200 = new File("C://keyOut/" + i + "-200.jpg");
//                outImage160 = new File("C://keyOut/" + i + "-160.jpg");
//                outImage75 = new File("C://keyOut/" + i + "-75.jpg");
//
//                if (biInput.getHeight() >= biInput.getWidth()) {
//                    System.out.println(i + " -> H > W");
//                    if (biInput.getHeight() >= 300) {
//                        resizeCountH = 290;
//                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
//                        resize = true;
//                    } else {
//                        resize = false;
//                        resizeCountH = biInput.getHeight();
//                        resizeCountW = biInput.getWidth();
//                    }
//                } else {
//                    System.out.println(i + " -> H < W");
//                    if (biInput.getWidth() >= 400) {
//                        resizeCountW = 390;
//                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
//                        resize = true;
//                    } else {
//                        resize = false;
//                        resizeCountW = 0;
//                        //System.out.println(resizeCountW + "x" + resizeCountW * biInput.getHeight() / biInput.getWidth());
//                        resizeCountH = 0;
//                    }
//                }
//
//                if (resize) {
//                    resampleOp = new ResampleOp(resizeCountH, resizeCountW);
//                    resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
//                    rescaledImg = resampleOp.filter(biInput, bi400);
//                } else {
//                    rescaledImg = biInput;
//                }
//                bf = new BorderFilter();
//                System.out.println(rescaledImg.getWidth() + "x" + rescaledImg.getHeight());
//                bf.setLeftBorder((400 - rescaledImg.getWidth()) / 2);
//                bf.setRightBorder((300 - rescaledImg.getHeight()) / 2);
//                ImagesUtils.saveImage(bf.filter(rescaledImg, bi400), outImage400, ImagesUtils.IMAGE_JPEG);
//
//                if (biInput.getHeight() >= biInput.getWidth()) {
//                    if (biInput.getHeight() >= 150) {
//                        resizeCountH = 140;
//                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
//                        resize = true;
//                    } else {
//                        resizeCountH = 0;
//                        resizeCountW = 0;
//                        resize = false;
//                    }
//                } else {
//                    if (biInput.getWidth() >= 200) {
//                        resizeCountW = 190;
//                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
//                        resize = true;
//                    } else {
//                        resize = false;
//                        resizeCountW = 0;
//                        resizeCountH = 0;
//                    }
//                }
//                if (resize) {
//                    resampleOp = new ResampleOp(resizeCountH, resizeCountW);
//                    resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
//                    rescaledImg = resampleOp.filter(biInput, null);
//                } else {
//                    rescaledImg = biInput;
//                }
//                bf = new BorderFilter();
//                bf.setLeftBorder((200 - rescaledImg.getWidth()) / 2);
//                bf.setRightBorder((150 - rescaledImg.getHeight()) / 2);
//                ImagesUtils.saveImage(bf.filter(rescaledImg, bi200), outImage200, ImagesUtils.IMAGE_JPEG);
//
//                if (biInput.getHeight() >= biInput.getWidth()) {
//                    if (biInput.getHeight() >= 160) {
//                        resizeCountH = 150;
//                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
//                        resize = true;
//                    } else {
//                        resize = false;
//                        resizeCountH = 0;
//                        resizeCountW = 0;
//                    }
//                } else {
//                    if (biInput.getWidth() >= 160) {
//                        resizeCountW = 150;
//                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
//                        resize = true;
//                    } else {
//                        resizeCountW = 0;
//                        resizeCountH = 0;
//                        resize = false;
//                    }
//                }
//
//                if (resize) {
//                    resampleOp = new ResampleOp(resizeCountH, resizeCountW);
//                    resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
//                    rescaledImg = resampleOp.filter(biInput, null);
//                } else {
//                    rescaledImg = biInput;
//                }
//                bf = new BorderFilter();
//                bf.setLeftBorder((160 - rescaledImg.getWidth()) / 2);
//                bf.setRightBorder((160 - rescaledImg.getHeight()) / 2);
//                ImagesUtils.saveImage(bf.filter(rescaledImg, bi160), outImage160, ImagesUtils.IMAGE_JPEG);
//
//                if (biInput.getHeight() >= biInput.getWidth()) {
//                    if (biInput.getHeight() >= 56) {
//                        resizeCountH = 50;
//                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
//                        resize = true;
//                    } else {
//                        resizeCountH = 0;
//                        resizeCountW = 0;
//                        resize = false;
//                    }
//                } else {
//                    if (biInput.getWidth() >= 75) {
//                        resize = true;
//                        resizeCountW = 70;
//                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
//                    } else {
//                        resizeCountW = 0;
//                        resizeCountH = 0;
//                        resize = false;
//                    }
//                }
//
//                if (resize) {
//                    resampleOp = new ResampleOp(resizeCountH, resizeCountW);
//                    resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
//                    rescaledImg = resampleOp.filter(biInput, null);
//                } else {
//                    rescaledImg = biInput;
//                }
//                bf = new BorderFilter();
//                bf.setLeftBorder((75 - rescaledImg.getWidth()) / 2);
//                bf.setRightBorder((56 - rescaledImg.getHeight()) / 2);
//                ImagesUtils.saveImage(bf.filter(rescaledImg, bi75), outImage75, ImagesUtils.IMAGE_JPEG);
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
    public static void main(String[] arg) {
        File imageLayer400;
        File imageLayer200;
        File imageLayer160;
        File imageLayer75;

        BufferedImage bi400;
        //BufferedImage bi200;
        BufferedImage bi160;
        //BufferedImage bi75;
        BufferedImage rescaledImg;
        BufferedImage tempImg;

        File outImage400;
        File outImage200;
        File outImage160;
        File outImage75;

        int resizeCountW, resizeCountH;

        ResampleOp resampleOp;

        boolean resize = true;

        BorderFilter bf;

        for (int i = 47950; i < 48100; i++) {
            File inputImage = null;
            BufferedImage biInput;

            try {
                inputImage = new File("C://keyPics/" + i + ".jpg");
                biInput = ImageIO.read(inputImage);
            } catch (Exception ex) {
                continue;
            }
            try {
                imageLayer400 = new File("C://400.jpg");
                imageLayer200 = new File("C://200.jpg");
                imageLayer160 = new File("C://160.jpg");
                imageLayer75 = new File("C://75.jpg");

                bi400 = ImageIO.read(imageLayer400);
                // bi200 = ImageIO.read(imageLayer200);
                bi160 = ImageIO.read(imageLayer160);
                //bi75 = ImageIO.read(imageLayer75);

                outImage400 = new File("C://keyOut/" + i + "-400.jpg");
                outImage200 = new File("C://keyOut/" + i + "-200.jpg");
                outImage160 = new File("C://keyOut/" + i + "-160.jpg");
                outImage75 = new File("C://keyOut/" + i + "-75.jpg");

                if (biInput.getHeight() >= biInput.getWidth()) {
                    System.out.println(i + " -> H > W");
                    if (biInput.getHeight() >= 300) {
                        resizeCountH = 290;
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                        resize = true;
                    } else {
                        resize = false;
                        resizeCountH = biInput.getHeight();
                        resizeCountW = biInput.getWidth();
                    }
                } else {
                    System.out.println(i + " -> H < W");
                    if (biInput.getWidth() >= 400) {
                        resizeCountW = 390;
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                        resize = true;
                    } else {
                        resize = false;
                        resizeCountW = 0;
                        //System.out.println(resizeCountW + "x" + resizeCountW * biInput.getHeight() / biInput.getWidth());
                        resizeCountH = 0;
                    }
                }

                if (resize) {
                    resampleOp = new ResampleOp(resizeCountH, resizeCountW);
                    resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                    rescaledImg = resampleOp.filter(biInput, bi400);
                } else {
                    rescaledImg = biInput;
                }
                bf = new BorderFilter();
                //System.out.println(rescaledImg.getWidth() + "x" + rescaledImg.getHeight());
                bf.setLeftBorder((400 - rescaledImg.getWidth()) / 2);
                bf.setRightBorder((300 - rescaledImg.getHeight()) / 2);
                ImagesUtils.saveImage(bf.filter(rescaledImg, bi400), outImage400, ImagesUtils.IMAGE_JPEG);

                tempImg = ImageIO.read(outImage400);
                resampleOp = new ResampleOp(200, 150);
                resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                rescaledImg = resampleOp.filter(tempImg, null);
                ImagesUtils.saveImage(rescaledImg, outImage200, ImagesUtils.IMAGE_JPEG);

                tempImg = ImageIO.read(outImage400);
                resampleOp = new ResampleOp(75, 56);
                resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                rescaledImg = resampleOp.filter(tempImg, null);
                ImagesUtils.saveImage(rescaledImg, outImage75, ImagesUtils.IMAGE_JPEG);


                if (biInput.getHeight() >= biInput.getWidth()) {
                    if (biInput.getHeight() >= 160) {
                        resizeCountH = 150;
                        resizeCountW = resizeCountH * biInput.getWidth() / biInput.getHeight();
                        resize = true;
                    } else {
                        resize = false;
                        resizeCountH = 0;
                        resizeCountW = 0;
                    }
                } else {
                    if (biInput.getWidth() >= 160) {
                        resizeCountW = 150;
                        resizeCountH = resizeCountW * biInput.getHeight() / biInput.getWidth();
                        resize = true;
                    } else {
                        resizeCountW = 0;
                        resizeCountH = 0;
                        resize = false;
                    }
                }

                if (resize) {
                    resampleOp = new ResampleOp(resizeCountW, resizeCountH);
                    resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
                    rescaledImg = resampleOp.filter(biInput, null);
                } else {
                    rescaledImg = biInput;
                }
                bf = new BorderFilter();
                // System.out.println(rescaledImg.getWidth() + "x" + rescaledImg.getHeight());
                bf.setLeftBorder((160 - rescaledImg.getWidth()) / 2);
                bf.setRightBorder((160 - rescaledImg.getHeight()) / 2);
                ImagesUtils.saveImage(bf.filter(rescaledImg, bi160), outImage160, ImagesUtils.IMAGE_JPEG);

//

            } catch (Exception ex) {
                System.out.println(i + " -> Нету картинки...");
            }
        }
    }
}


