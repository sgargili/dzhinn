/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author APopov
 */
public class gc {

    public static void main(String[] args) {
        int SIZE = 2000000;
        //String s;
        for (int i = 0; i < SIZE; i++) {
            String s = new String(i + "");
            s = null;
        }
        System.out.println("Garbage Collection started explicitly.");
        long time = System.nanoTime();
        System.gc();
        System.out.println("It took " + (System.nanoTime() - time) / 1000 + " ns");

    }
}
