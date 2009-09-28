/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author APopov
 */
import DAO.FactoryNixDAO;
import Pojo.Nixlinks;
import Proxy.IpChange;
import Threads.DownloadContent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public class MyRunnable implements Runnable {

    static int bayan = 0;

    private void sss(String str) {
        System.out.println(str);
    }

    public String getName() {
        return Thread.currentThread().getName();
    }

    public void run() {

        // System.out.println(getName());
        if (getName().equals("1")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(0, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //   System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 1 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "1");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("2")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(5486, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //   System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 2 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "2");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }
        } else if (getName().equals("3")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(10971, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 3 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "3");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("4")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(16456, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 4 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "4");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("5")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(24941, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 5 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "5");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("6")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(27426, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 6 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "6");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("7")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(32911, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 7 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "7");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("8")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(38396, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 8 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "8");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("9")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(43881, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;

            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 9 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "9");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        } else if (getName().equals("10")) {

            List<Nixlinks> nixlist = null;
            try {
                nixlist = FactoryNixDAO.getInstance().getNixlinksDAO().getAllNixlinkByCounts(49336, 5485);
            } catch (SQLException ex) {
            }
            int i = 0;
            //
            IpChange ip = new IpChange();
            //  System.out.println(nixlist.size());
            for (Iterator it = nixlist.iterator(); it.hasNext();) {
                Nixlinks str = (Nixlinks) it.next();
                System.out.println("Поток 10 -> " + i + " -> " + str.getProductType() + " -> " + str.getProductUrl());
                try {
                    DownloadContent dc = new DownloadContent();
                    dc.DownloadContent(str.getProductUrl(), str.getProductType(), "10");
                } catch (IOException ex) {
                } catch (XmlPullParserException ex) {
                } catch (SQLException ex) {
                }
                if (bayan == 17) {
                    bayan = 0;
                    try {
                        ip.setChange();
                        System.out.println("Ip Сменился...");
                    } catch (UnknownHostException ex) {
                    } catch (IOException ex) {
                    }
                    // System.out.println("Ip Сменился...");
                }
                i++;
                bayan++;
            }

        }
    }
}
