/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scaleimage;

/**
 *
 * @author APopov
 */
import com.imageresize4j.ImageResizeProcessor;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.ImageWriteParam;
import javax.imageio.IIOImage;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.File;
import java.util.Iterator;
import java.util.Arrays;

/**
 * Two-Phase speed & quality testing
 */
public class TwoPhaseDownscaling {

    //scale limit to when apply 2-phase downscaling or not
    public static final float SCALE_LIMIT = 0.25f;
    public static int[][] thumbnail_sizes = {{72, 96}, {96, 128}, {120, 160}};

    public static void main(String[] args) {
        try {
            //read an image
            BufferedImage source = ImageIO.read(new File("C://111.jpg"));
            int numOfTests = 10;

            long[] timeArray = new long[numOfTests];
            //test 1-phase Bicubic Java2D-native resize
            for (int sizeIdx = 0; sizeIdx < thumbnail_sizes.length; sizeIdx++) {
                int destWidth = thumbnail_sizes[sizeIdx][0];
                int destHeight = thumbnail_sizes[sizeIdx][1];
                BufferedImage result = null;
                for (int testNum = 0; testNum < numOfTests; testNum++) {
                    long start = System.nanoTime();
                    result = resizeJava2DNative(source, destWidth, destHeight,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                    timeArray[testNum] = System.nanoTime() - start;
                }
                //sort test results
                Arrays.sort(timeArray);
                //calculate average time except the best and the worst results
                long sum = 0;
                for (int i = 1; i < numOfTests - 1; i++) {
                    sum += timeArray[i] / 1000000;
                }
                System.out.println("Average time of 1-phase Java2D-BICUBIC - [" + destWidth + "x" + destHeight + "]: " + (sum / (numOfTests - 2)) + "ms");
                writeJPEG(result, "C:\\result_java2d_" + destWidth + "_" + destHeight + ".jpg");
            }

            //test 1-phase SHARP_5 resize
            ImageResizeProcessor nnProcessor =
                    new ImageResizeProcessor(ImageResizeProcessor.TYPE_NEAREST_NEIGHBOR);
            for (int sizeIdx = 0; sizeIdx < thumbnail_sizes.length; sizeIdx++) {
                int destWidth = thumbnail_sizes[sizeIdx][0];
                int destHeight = thumbnail_sizes[sizeIdx][1];
                BufferedImage result = null;
                for (int testNum = 0; testNum < numOfTests; testNum++) {
                    long start = System.nanoTime();
                    result = nnProcessor.resize(source, destWidth, destHeight);
                    timeArray[testNum] = System.nanoTime() - start;
                }
                //sort test results
                Arrays.sort(timeArray);
                //calculate average time except the best and the worst results
                long sum = 0;
                for (int i = 1; i < numOfTests - 1; i++) {
                    sum += timeArray[i] / 1000000;
                }
                System.out.println("Average time of 1-phase NEAREST_NEIGHBOR - [" + destWidth + "x" + destHeight + "]: " + (sum / (numOfTests - 2)) + "ms");
                writeJPEG(result, "C:\\result_ir4j_nn_" + destWidth + "_" + destHeight + ".jpg");
            }

            //test 1-phase SHARP_5 resize
            ImageResizeProcessor sharpProcessor = new ImageResizeProcessor(ImageResizeProcessor.TYPE_SHARP_5);
            for (int sizeIdx = 0; sizeIdx < thumbnail_sizes.length; sizeIdx++) {
                int destWidth = thumbnail_sizes[sizeIdx][0];
                int destHeight = thumbnail_sizes[sizeIdx][1];
                BufferedImage result = null;
                for (int testNum = 0; testNum < numOfTests; testNum++) {
                    long start = System.nanoTime();
                    result = sharpProcessor.resize(source, destWidth, destHeight);
                    timeArray[testNum] = System.nanoTime() - start;
                }
                //sort test results
                Arrays.sort(timeArray);
                //calculate average time except the best and the worst results
                long sum = 0;
                for (int i = 1; i < numOfTests - 1; i++) {
                    sum += timeArray[i] / 1000000;
                }
                System.out.println("Average time of 1-phase SHARP_5 - [" + destWidth + "x" + destHeight + "]: " + (sum / (numOfTests - 2)) + "ms");
                writeJPEG(result, "C:\\result_ir4j_sharp_" + destWidth + "_" + destHeight + ".jpg");
            }

            //test 2-phase resize - NEAREST_NEIGHBOR as the first phase and SHARP_5 the second
            for (int sizeIdx = 0; sizeIdx < thumbnail_sizes.length; sizeIdx++) {
                int destWidth = thumbnail_sizes[sizeIdx][0];
                int destHeight = thumbnail_sizes[sizeIdx][1];
                BufferedImage result = null;
                for (int testNum = 0; testNum < numOfTests; testNum++) {
                    long start = System.nanoTime();
                    result = resizeIn2PhasesViaIR4J(source, destWidth, destHeight,
                            ImageResizeProcessor.TYPE_NEAREST_NEIGHBOR,
                            ImageResizeProcessor.TYPE_SHARP_5);
                    timeArray[testNum] = System.nanoTime() - start;
                }
                //sort test results
                Arrays.sort(timeArray);
                //calculate average time except the best and the worst results
                long sum = 0;
                for (int i = 1; i < numOfTests - 1; i++) {
                    sum += timeArray[i] / 1000000;
                }
                System.out.println("Average time of 2-phase NEAREST_NEIGHBOR/SHARP_5 - [" + destWidth + "x" + destHeight + "]: " + (sum / (numOfTests - 2)) + "ms");
                writeJPEG(result, "C:\\result_ir4j_nn_sharp_" + destWidth + "_" + destHeight + ".jpg");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage resizeIn2PhasesViaIR4J(BufferedImage source,
            int destWidth, int destHeight,
            int firstInterpolation,
            int secondInterpolation) {
        if (source == null) {
            throw new NullPointerException("source image is NULL!");
        }
        if (destWidth <= 0 && destHeight <= 0) {
            throw new IllegalArgumentException("destination width & height are both <=0!");
        }
        //calculate scale factors
        float scaleX = (float) destWidth / source.getWidth();
        float scaleY = (float) destHeight / source.getHeight();
        //check if we really need 2-phase schema
        if (scaleX < SCALE_LIMIT && scaleY < SCALE_LIMIT) {
            //calculate the most appropriate intermediate image size
            int sizeMultiplier = 2;
            //if scale factors are too small then we need a larger intermediate image
            if (scaleX < SCALE_LIMIT / 2 || scaleY < SCALE_LIMIT / 2) {
                sizeMultiplier = 4;
            }
            //create the processor for the 1-st phase
            ImageResizeProcessor preProcessor = new ImageResizeProcessor(firstInterpolation);
            //generate an intermediate image
            BufferedImage intermediate = preProcessor.resize(source, destWidth * sizeMultiplier, destHeight * sizeMultiplier);
            //create the processor for the final phase
            ImageResizeProcessor postProcessor = new ImageResizeProcessor(secondInterpolation);
            //generate the final result
            return postProcessor.resize(intermediate, destWidth, destHeight);
        } else {
            //just simple resize with the specified interpolation
            ImageResizeProcessor processor = new ImageResizeProcessor(secondInterpolation);
            return processor.resize(source, destWidth, destHeight);
        }
    }

    public static BufferedImage resizeJava2DNative(BufferedImage source, int destWidth, int destHeight,
            Object interpolation) {
        if (source == null) {
            throw new NullPointerException("source image is NULL!");
        }
        if (destWidth <= 0 && destHeight <= 0) {
            throw new IllegalArgumentException("destination width & height are both <=0!");
        }
        int sourceWidth = source.getWidth();
        int sourceHeight = source.getHeight();
        double xScale = ((double) destWidth) / (double) sourceWidth;
        double yScale = ((double) destHeight) / (double) sourceHeight;
        if (destWidth <= 0) {
            xScale = yScale;
            destWidth = (int) Math.rint(xScale * sourceWidth);
        }
        if (destHeight <= 0) {
            yScale = xScale;
            destHeight = (int) Math.rint(yScale * sourceHeight);
        }
        GraphicsConfiguration gc = getDefaultConfiguration();
        BufferedImage result = gc.createCompatibleImage(destWidth, destHeight, source.getColorModel().getTransparency());
        Graphics2D g2d = null;
        try {
            g2d = result.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolation);
            AffineTransform at =
                    AffineTransform.getScaleInstance(xScale, yScale);
            g2d.drawRenderedImage(source, at);
        } finally {
            if (g2d != null) {
                g2d.dispose();
            }
        }
        return result;
    }

    public static GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        return gd.getDefaultConfiguration();
    }

    public static void writeJPEG(BufferedImage input, String name) throws IOException {
        Iterator iter =
                ImageIO.getImageWritersByFormatName("JPG");
        if (iter.hasNext()) {
            ImageWriter writer = (ImageWriter) iter.next();
            ImageWriteParam iwp =
                    writer.getDefaultWriteParam();
            iwp.setCompressionMode(
                    ImageWriteParam.MODE_EXPLICIT);
            iwp.setCompressionQuality(0.95f);
            File outFile = new File(name);
            FileImageOutputStream output =
                    new FileImageOutputStream(outFile);
            writer.setOutput(output);
            IIOImage image =
                    new IIOImage(input, null, null);
            writer.write(null, image, iwp);
            output.close();
        }
    }
}

