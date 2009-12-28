/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

/**
 *
 * @author Apopov
 */
public class MyRunnable implements Runnable {

    public String getName() {
        return Thread.currentThread().getName();
    }

    public void run() {
        if (getName().equals("1")) {
            for (int i = 1500; i < 10000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("1", i);
            }
        } else if (getName().equals("2")) {
            for (int i = 10001; i < 20000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("2", i);
            }
        } else if (getName().equals("3")) {
            for (int i = 20001; i < 30000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("3", i);
            }
        } else if (getName().equals("4")) {
            for (int i = 30001; i < 40000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("4", i);
            }
        } else if (getName().equals("5")) {
            for (int i = 40001; i < 50000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("5", i);
            }
        } else if (getName().equals("6")) {
            for (int i = 50001; i < 60000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("6", i);
            }
        } else if (getName().equals("7")) {
            for (int i = 60001; i < 70000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("7", i);
            }
        } else if (getName().equals("8")) {
            for (int i = 70001; i < 80000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("8", i);
            }
        } else if (getName().equals("9")) {
            for (int i = 80001; i < 90000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("9", i);
            }
        } else if (getName().equals("10")) {
            for (int i = 90001; i < 100000; i++) {
                DownloadContent dc = new DownloadContent();
                dc.load("10", i);
            }
        }
    }
}
