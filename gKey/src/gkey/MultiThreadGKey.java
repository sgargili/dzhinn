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

private static int i = 0;
    public void run() {
        System.out.println("Привет от потока "+i);
    }

    public static void main(String[] args) {
        MultiThreadGKey mt = new MultiThreadGKey();
        i = 1;
        mt.start();
        mt = new MultiThreadGKey();
        i=2;
        mt.start();
    }
}
