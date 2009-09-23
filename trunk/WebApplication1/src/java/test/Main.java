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
        Thread t = new Thread(r);
        t.start();
    }
}

