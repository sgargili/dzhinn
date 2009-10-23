/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pics;

import CSV.CsvReader;
import DAO.FactoryDAO4Imports;
import FTP.FTPClient;
import HttpClient.http;
import Pojo.PicsBean;
import Pojo.Products;
import com.jhlabs.image.BicubicScaleFilter;
import com.jhlabs.image.GaussianFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author APopov
 */
public class picsDownload {

    public static void main(String[] arg) throws IOException, XmlPullParserException, SQLException {
        File file = new File("/root/jImport/458.csv");
        List<String> art = new ArrayList();
        CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
        reader.readHeaders();
        while (reader.readRecord()) {
            art.add(reader.get(0).trim());
        }
        Products prod;
        List<PicsBean> pbl = new ArrayList();
        PicsBean pb;
        String artBuffer = "";
        http ht = new http();
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        //xpp.setInput(new InputStreamReader(FileUtils.openInputStream(new File("C:/test.xml")), "UTF-8"));
        xpp.setInput(new InputStreamReader(FileUtils.openInputStream(ht.DownloadContentAsFile("http://213.53.57.20/ShopIX/exportProductsImgXML.jsp?shopId=74")), "UTF-8"));
        int eventType = xpp.getEventType();
        int sIndex = 0, mIndex = 0, bIndex = 0;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("itemImage")) {
                if (!artBuffer.equals(xpp.getAttributeValue(0))) {
                    sIndex = 0;
                    mIndex = 0;
                    bIndex = 0;
                }
                pb = new PicsBean();
                pb.setId(Integer.parseInt(artBuffer = xpp.getAttributeValue(0)));
                pb.setSource(xpp.getAttributeValue(4));
                if (Integer.parseInt(xpp.getAttributeValue(1)) == 75) {
                    pb.setType("small");
                    pb.setIndex(sIndex);
                    sIndex++;
                } //                else if (Integer.parseInt(xpp.getAttributeValue(1)) > 75 && Integer.parseInt(xpp.getAttributeValue(1)) < 362) {
                //                    pb.setType("medium");
                //                    pb.setIndex(mIndex);
                //                    mIndex++;
                //                }
                else if (Integer.parseInt(xpp.getAttributeValue(1)) == 362 || //
                        Integer.parseInt(xpp.getAttributeValue(1)) == 600 || //
                        Integer.parseInt(xpp.getAttributeValue(1)) == 900 || //
                        Integer.parseInt(xpp.getAttributeValue(1)) == 800) {
                    pb.setType("big");
                    pb.setIndex(bIndex);
                    bIndex++;
                } else {
                    pb.setType("n/a");
                    pb.setIndex(0);
                    
                }
                pbl.add(pb);
            }
            eventType = xpp.next();
        }
        File fl2;
        File fl3;
        File fl;
        URL url;
        FTPClient ftp = new FTPClient();
        ftp.connect("188.40.103.13", 1021, "apache", "nthvtyfnjh1");
        ftp.bin();
        int i = 1;
        for (Iterator artic = art.iterator(); artic.hasNext();) {
            String tempart = (String) artic.next();
            for (Iterator it = pbl.iterator(); it.hasNext();) {
                PicsBean temp = (PicsBean) it.next();
                if ((tempart.equals(temp.getId() + ""))) { //pim8803.jpg
                    try {
                        if (temp.getType().equals("small")) {
                            fl = new File("/root/pics/" + "pim" + temp.getId() + ".jpg");
                            url = new URL(temp.getSource());
                            FileUtils.copyURLToFile(url, fl);
                            ftp.cwd("/img");
                            //ftp.stor(FileUtils.openInputStream(fl), fl.getName());
                            System.out.println(i + " " + temp.getId() + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ")");
                            fl.delete();
                            prod = FactoryDAO4Imports.getProductsDAO().getProductById(temp.getId());
                            prod.setProductsImage("../img/" + "pim" + temp.getId() + ".jpg");
                            FactoryDAO4Imports.getProductsDAO().addProducts(prod);
                        } else if (temp.getType().equals("big")) {
                            fl2 = new File("/root/pics/" + temp.getId() + "_big_" + temp.getIndex() + ".jpg");
                            fl3 = new File("/var/www/html/imgLib/"+temp.getId() + "_big_" + temp.getIndex() + ".jpg");
                            ftp.cwd("/imgLib");
                            url = new URL(temp.getSource());
                            FileUtils.copyURLToFile(url, fl2);
                            BufferedImage bi = ImageIO.read(fl2);
                            ImagesUtils.saveImage(bi, fl3, 0);
                            //ftp.stor(FileUtils.openInputStream(fl2), fl2.getName());
                            //FileUtils.copyFile(fl2, new File("/var/www/html/imgLib/"+temp.getId() + "_big_" + temp.getIndex() + ".jpg"));
                            System.out.println(i + " " + temp.getId() + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ") -> big...");
//                            prod = FactoryDAO4Imports.getProductsDAO().getProductById(temp.getId());
//                            prod.setProductsImageMed("../imgLib/" + temp.getId() + "_big_" + temp.getIndex() + ".jpg");
                            BicubicScaleFilter bf = new BicubicScaleFilter(196, 196);
                            GaussianFilter gf = new GaussianFilter((float) 1);
                            fl3 = new File("/var/www/html/imgLib/"+temp.getId() + "_medium_" + temp.getIndex() + ".jpg");
                            ImagesUtils.saveImage(bf.filter(gf.filter(bi, null), null), fl3, 0);
                            //ftp.stor(FileUtils.openInputStream(fl2), fl2.getName());
                            //FileUtils.copyFile(fl2, new File("/var/www/html/imgLib/"+temp.getId() + "_medium_" + temp.getIndex() + ".jpg"));
                            System.out.println(i + " " + temp.getId() + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ") - > med");
                            if (temp.getIndex() == 0) {
                                prod = FactoryDAO4Imports.getProductsDAO().getProductById(temp.getId());
                                
                                prod.setProductsImageMed("../imgLib/" + temp.getId() + "_medium_" + temp.getIndex() + ".jpg");
                                FactoryDAO4Imports.getProductsDAO().addProducts(prod);
                            }
                            bf = new BicubicScaleFilter(65, 65);
                            gf = new GaussianFilter((float) 10);
                            fl3 = new File("/var/www/html/imgLib/"+temp.getId() + "_small_" + temp.getIndex() + ".jpg");

                            ImagesUtils.saveImage(bf.filter(gf.filter(bi, null), null), fl3, 0);
                            //FileUtils.copyFile(fl2, new File("/var/www/html/imgLib/"+temp.getId() + "_small_" + temp.getIndex() + ".jpg"));
                            //ftp.stor(FileUtils.openInputStream(fl2), fl2.getName());
                            System.out.println(i + " " + temp.getId() + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ") - > small");
                            fl2.delete();
//                            prod = FactoryDAO4Imports.getProductsDAO().getProductById(temp.getId());
//                            prod.setProductsImageMed("../imgLib/" + temp.getId() + "_small_" + temp.getIndex() + ".jpg");
//                            FactoryDAO4Imports.getProductsDAO().addProducts(prod);
                        }
                        //break;
                    } catch (Exception e) {
                        System.out.println(i + " " + e);
                    }
                }
            }
            i++;
        }
        ftp.disconnect();
    }
}
