/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author APopov
 */
public class Main {

    public static void main(String args[]) throws Exception {
        Runnable r = new MyRunnable();
        for (Integer i = 1; i <= 10; i++) {
            Thread t = new Thread(r, i.toString());
            t.start();
        }
    }
}

