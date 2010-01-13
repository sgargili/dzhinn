/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

import http.Http;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.io.FileUtils;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author APopov
 */
public class picsDownload {

    @SuppressWarnings("static-access")
    public static void main(String[] arg) throws IOException, XmlPullParserException, SQLException {
//        File file = new File("/root/NetBeansProjects/jImport/458.csv");
//        List<String> art = new ArrayList();
//        CsvReader reader = new CsvReader(file.getAbsolutePath(), ',', Charset.forName("UTF-8"));
//        reader.readHeaders();
//        while (reader.readRecord()) {
//            art.add(reader.get(0).trim());
//        }
//        List art = FactoryDAO4Imports.getInstance().getPcProductsAvailableDAO().getPcProductsAvailable();
//        Products prod;
//        ProductImgLib prodImg;
//        List<PicsBean> pbl;
//        PicsBean pb;
//        String artBuffer = "";
//        http ht = new http();
//        long tempLong;
//        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//        XmlPullParser xpp = factory.newPullParser();
//        int i = 1;
//        for (Iterator artic = art.iterator(); artic.hasNext();) {
//            PcProductsAvailable tempart = (PcProductsAvailable) artic.next();
//            pbl = new ArrayList();
//            //xpp.setInput(new InputStreamReader(FileUtils.openInputStream(new File("C:/test.xml")), "UTF-8"));
////        File fileTemp = new File("allPics.xml");
////
//            tempLong = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getIt4PidByShopPid(FactoryDAO4Imports.getInstance().getPcSyncProductsDAO().getPcSyncProductsByModel(tempart.getModel()));
//            File fileTemp = ht.DownloadContentAsFile("http://213.53.57.20/CatExp/productimg.exml?shop=74&product=" + tempLong);
//
//            //   File fileTemp2 = new File("/root/allPics.xml");
//            // FileUtils.copyFile(fileTemp, fileTemp2);
//            xpp.setInput(new InputStreamReader(FileUtils.openInputStream(fileTemp), "UTF-8"));
//            int eventType = xpp.getEventType();
//            int sIndex = 0, mIndex = 0, bIndex = 0;
//            while (eventType != XmlPullParser.END_DOCUMENT) {
//                if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("itemImage")) {
//                    if (!artBuffer.equals(xpp.getAttributeValue(0))) {
//                        sIndex = 0;
//                        mIndex = 0;
//                        bIndex = 0;
//                    }
//                    pb = new PicsBean();
//                    pb.setId(Long.parseLong(artBuffer = xpp.getAttributeValue(0)));
//                    pb.setSource(xpp.getAttributeValue(4));
//                    if (Integer.parseInt(xpp.getAttributeValue(1)) == 75) {
//                        pb.setType("small");
//                        pb.setIndex(sIndex);
//                        sIndex++;
//                    } //                else if (Integer.parseInt(xpp.getAttributeValue(1)) > 75 && Integer.parseInt(xpp.getAttributeValue(1)) < 362) {
//                    //                    pb.setType("medium");
//                    //                    pb.setIndex(mIndex);
//                    //                    mIndex++;
//                    //                }
//                    else if (Integer.parseInt(xpp.getAttributeValue(1)) == 362 || //
//                            Integer.parseInt(xpp.getAttributeValue(1)) == 600 || //
//                            Integer.parseInt(xpp.getAttributeValue(1)) == 900 || //
//                            Integer.parseInt(xpp.getAttributeValue(1)) == 800) {
//                        pb.setType("big");
//                        pb.setIndex(bIndex);
//                        bIndex++;
//                    } else {
//                        pb.setType("n/a");
//                        pb.setIndex(0);
//
//                    }
//                    pbl.add(pb);
//                }
//                eventType = xpp.next();
//            }
//            File fl2;
//            File fl3;
//            File fl, fl1;
//            URL url;
//            //FTPClient ftp = new FTPClient();
//            // ftp.connect("188.40.103.13", 1021, "apache", "nthvtyfnjh1");
//            //ftp.bin();
//
//            ResampleOp resampleOp;
////            for (Iterator artic = art.iterator(); artic.hasNext();) {
////                String tempart = (String) artic.next();
//            for (Iterator it = pbl.iterator(); it.hasNext();) {
//                PicsBean temp = (PicsBean) it.next();
//                tempLong = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getShopPidByIt4Pid(temp.getId());
//                if ((true)) { //pim8803.jpg
//                    try {
//                        if (temp.getType().equals("small")) {
//                            fl = new File("/root/pics/" + "pim" + tempLong + ".jpg");
//                            fl1 = new File("/var/www/html/img/" + "pim" + tempLong + ".jpg");
//                            url = new URL(temp.getSource());
//                            FileUtils.copyURLToFile(url, fl);
//                            BufferedImage bi = ImageIO.read(fl);
//                            ImagesUtils.saveImage(bi, fl1, 0);
//                            // ftp.cwd("/img");
//                            //ftp.stor(FileUtils.openInputStream(fl), fl.getName());
//                            System.out.println(i + " " + tempLong + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ")");
//                            fl.delete();
//                            //tempLong = FactoryDAO4Imports.getInstance().getPcSyncIdsDAO().getShopPidByIt4Pid(temp.getId());
//                            prod = FactoryDAO4Imports.getInstance().getProductsDAO().getProductById(tempLong);
//                            prod.setProductsImage("../img/" + "pim" + tempLong + ".jpg");
//                            FactoryDAO4Imports.getInstance().getProductsDAO().addProducts(prod);
//                        } else if (temp.getType().equals("big")) {
//                            prodImg = new ProductImgLib();
//                            prodImg.setPid(tempLong);
//                            prodImg.setSmall("../imgLib/" + tempLong + "_small_" + temp.getIndex() + ".jpg");
//                            prodImg.setMedium("../imgLib/" + tempLong + "_medium_" + temp.getIndex() + ".jpg");
//                            prodImg.setBig("../imgLib/" + tempLong + "_big_" + temp.getIndex() + ".jpg");
//                            prodImg.setName(tempLong + "(" + temp.getIndex() + ")");
//                            FactoryDAO4Imports.getInstance().getProductImgLibDAO().addProductImgLib(prodImg);
//                            fl2 = new File("/root/pics1/" + tempLong + "_big_" + temp.getIndex() + ".jpg");
//                            fl3 = new File("/var/www/html/imgLib/" + tempLong + "_big_" + temp.getIndex() + ".jpg");
////                            ftp.cwd("/imgLib");
//                            url = new URL(temp.getSource());
//                            FileUtils.copyURLToFile(url, fl2);
//                            BufferedImage bi = ImageIO.read(fl2);
////                            ImagesUtils.saveImage(bi, fl3, 0);
//                            //ftp.stor(FileUtils.openInputStream(fl2), fl2.getName());
//                            // FileUtils.copyFile(fl2, new File("/var/www/html/imgLib/" + temp.getId() + "_big_" + temp.getIndex() + ".jpg"));
//                            ImagesUtils.saveImage(bi, new File("/var/www/html/imgLib/" + tempLong + "_big_" + temp.getIndex() + ".jpg"), ImagesUtils.IMAGE_JPEG);
//                            System.out.println(i + " " + tempLong + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ") -> big...");
//                            if (temp.getIndex() == 0) {
//                                prod = FactoryDAO4Imports.getInstance().getProductsDAO().getProductById(tempLong);
//
//                                prod.setProductsImageLrg("../imgLib/" + tempLong + "_big_" + temp.getIndex() + ".jpg");
//                                FactoryDAO4Imports.getInstance().getProductsDAO().addProducts(prod);
//                            }
//                            prod = FactoryDAO4Imports.getInstance().getProductsDAO().getProductById(tempLong);
////                            prod.setProductsImageMed("../imgLib/" + temp.getId() + "_big_" + temp.getIndex() + ".jpg");
////                            BicubicScaleFilter bf = new BicubicScaleFilter(196, 196);
////                            GaussianFilter gf = new GaussianFilter((float) 5);
//                            resampleOp = new ResampleOp(196, 196);
//                            resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
//                            BufferedImage rescaledImg = resampleOp.filter(bi, null);
//                            fl3 = new File("/var/www/html/imgLib/" + tempLong + "_medium_" + temp.getIndex() + ".jpg");
//                            ImagesUtils.saveImage(rescaledImg, fl3, ImagesUtils.IMAGE_JPEG);
//                            //ftp.stor(FileUtils.openInputStream(fl2), fl2.getName());
//                            //FileUtils.copyFile(fl2, new File("/var/www/html/imgLib/"+temp.getId() + "_medium_" + temp.getIndex() + ".jpg"));
//                            System.out.println(i + " " + tempLong + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ") - > med");
//                            if (temp.getIndex() == 0) {
//                                prod = FactoryDAO4Imports.getInstance().getProductsDAO().getProductById(tempLong);
//
//                                prod.setProductsImageMed("../imgLib/" + tempLong + "_medium_" + temp.getIndex() + ".jpg");
//                                FactoryDAO4Imports.getInstance().getProductsDAO().addProducts(prod);
//                            }
////                            bf = new BicubicScaleFilter(65, 65);
////                            gf = new GaussianFilter((float) 10);
//                            resampleOp = new ResampleOp(65, 65);
//                            resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
//                            rescaledImg = resampleOp.filter(bi, null);
//                            fl3 = new File("/var/www/html/imgLib/" + tempLong + "_small_" + temp.getIndex() + ".jpg");
//
//                            ImagesUtils.saveImage(rescaledImg, fl3, ImagesUtils.IMAGE_JPEG);
//                            //FileUtils.copyFile(fl2, new File("/var/www/html/imgLib/"+temp.getId() + "_small_" + temp.getIndex() + ".jpg"));
//                            //ftp.stor(FileUtils.openInputStream(fl2), fl2.getName());
//                            System.out.println(i + " " + tempLong + " -> " + temp.getSource() + " -> " + temp.getType() + "(" + temp.getIndex() + ") - > small");
//                            fl2.delete();
//                            prod = FactoryDAO4Imports.getInstance().getProductsDAO().getProductById(tempLong);
//                            prod.setProductsImageMed("../imgLib/" + tempLong + "_small_" + temp.getIndex() + ".jpg");
//                            FactoryDAO4Imports.getInstance().getProductsDAO().addProducts(prod);
//                        }
//                        //break;
//                        } catch (Exception e) {
//                        System.out.println(i + " " + e);
//                    }
//                }
//
//            }
//            //}
//            // ftp.disconnect();
//            i++;
//        }
//        List<ProductImgLib> pi = new ArrayList();
//        List<ProductImgLib> pi2 = new ArrayList();
//        pi = (List<ProductImgLib>) FactoryDAO4Imports.getInstance().getProductImgLibDAO().getAllProductImgLib();
//        for (Iterator imgit = pi.iterator(); imgit.hasNext();) {
//            ProductImgLib tempart2 = (ProductImgLib) imgit.next();
//            pi2 = (List<ProductImgLib>) FactoryDAO4Imports.getInstance().getProductImgLibDAO().getProductImgLibById(tempart2.getPid());
//            try {
//                if (pi2.size() == 1) {
//                    FactoryDAO4Imports.getInstance().getProductImgLibDAO().deleteProductImgLib(tempart2);
//                }
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
        Http ht = new Http();
        File flTemp;
        for (int i = 83183; i < 83190; i++) {
            flTemp = ht.DownloadContentAsFile("http://shop.key.ru/photo/items/" + i + ".jpg", true);
            FileUtils.copyFile(flTemp, new File(i + ".jpg"));
        }
    }
}
