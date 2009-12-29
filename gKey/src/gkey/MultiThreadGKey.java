/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

/**
 *
 * @author root
 */
public class MultiThreadGKey extends Thread {

    public static void main(String args[]) throws Exception {
        Runnable r = new MyRunnable();
        for (Integer i = 10; i <= 10; i++) {
            Thread t = new Thread(r, i.toString());
            t.start();
        }
    }
}
