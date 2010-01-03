/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import dao.FactoryDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import pojo.TempPojo;
import pojo.TempPojo2;

/**
 *
 * @author Apopov
 */
public class MyRunnable implements Runnable {

    public String getName() {
        return Thread.currentThread().getName();
    }

// Parsing ukradenogo HTML s sayta key.ru
    public void run() {
        Set temp = new HashSet();
        TempPojo2 tp;
        try {
            List lst = FactoryDAO.getInstance().getTempPojoDAO2().getAllTempPojo2();
            for (Iterator it = lst.iterator(); it.hasNext();) {
                tp = (TempPojo2) it.next();
                temp.add(tp.getKeyarticle());
            }
        } catch (Exception ex) {
        }
        if (getName().equals("1")) {
            for (int i = 1500; i < 10000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("1", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("2")) {
            for (int i = 10001; i < 20000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("2", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("3")) {
            for (int i = 20001; i < 30000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("3", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("4")) {
            for (int i = 30001; i < 40000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("4", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("5")) {
            for (int i = 40001; i < 50000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("5", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("6")) {
            for (int i = 50001; i < 60000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("6", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("7")) {
            for (int i = 60001; i < 70000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("7", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("8")) {
            for (int i = 70001; i < 80000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("8", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("9")) {
            for (int i = 80001; i < 90000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("9", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        } else if (getName().equals("10")) {
            for (int i = 90001; i < 100000; i++) {
                if (!temp.contains(i + "")) {
                    DownloadContentv2 dc = new DownloadContentv2();
                    dc.load("10", i);
                } else {
                    System.out.println(i + " - > Takoy uzhe est'...");
                }
            }
        }
    }
    // Zalivaem HTML s sayta key.ru
//    public void run() {
//        List temp = new ArrayList();
//        try {
//            List lst = FactoryDAO.getInstance().getTempPojoDAO().getAllTempPojo();
//            TempPojo tp;
//            for (Iterator it = lst.iterator(); it.hasNext();) {
//                tp = (TempPojo) it.next();
//                temp.add(tp.getKeyarticle());
//            }
//        } catch (Exception ex) {
//        }
//        if (getName().equals("1")) {
//            for (int i = 1500; i < 10000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("1", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("2")) {
//            for (int i = 10001; i < 20000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("2", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("3")) {
//            for (int i = 20001; i < 30000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("3", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("4")) {
//            for (int i = 30001; i < 40000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("4", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("5")) {
//            for (int i = 40001; i < 50000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("5", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("6")) {
//            for (int i = 50001; i < 60000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("6", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("7")) {
//            for (int i = 60001; i < 70000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("7", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("8")) {
//            for (int i = 70001; i < 80000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("8", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("9")) {
//            for (int i = 80001; i < 90000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("9", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        } else if (getName().equals("10")) {
//            for (int i = 90001; i < 100000; i++) {
//                if (!temp.contains(i + "")) {
//                    JustDownload dc = new JustDownload();
//                    dc.load("10", i);
//                } else {
//                    System.out.println(i + " - > Takoy uzhe est'...");
//                }
//            }
//        }
//    }
}
