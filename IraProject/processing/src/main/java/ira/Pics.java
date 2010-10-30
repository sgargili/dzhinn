package ira;

import ira.httpclient.FactoryHttpData;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: PAV
 * Date: 30.10.2010
 * Time: 2:32:51
 * To change this template use File | Settings | File Templates.
 */
public class Pics {
    private FactoryHttpData http = FactoryHttpData.getInstance();

    public void getPics(String article, int iter, int count) {
        try {
            int i = 1;
            boolean isDirCreated = new File("d://iraPics/" + article).mkdirs();
            while (http.getHttpData().DownloadBinaryFile("http://belygorod.ru/book_images/" + article + "-" + i++ + ".jpg",
                    true,
                    "d://iraPics/" + article + "/стр." + (i - 1) + ".jpg")) {
                System.out.println(iter + " из " + count + " - " + article + " - Скачана картинка: " + (i - 1));
            }
            if (i == 2) {
                http.getHttpData().DownloadBinaryFile("http://belygorod.ru/book_images/" + article + ".jpg",
                        true,
                        "d://iraPics/" + article + "/" + article + ".jpg");
                System.out.println(iter + " из " + count + " - " + article + " - Больших картинок нет, только основная...");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void getNotExistPics(String article, int iter, int count) {
        try {
            int i = 1;
            if (!new File("d://iraPics/" + article + "/" + article + ".jpg").exists()) {
                http.getHttpData().DownloadBinaryFile("http://belygorod.ru/book_images/" + article + ".jpg",
                        true,
                        "d://iraPics/" + article + "/" + article + ".jpg");
                System.out.println(iter + " из " + count + " - " + article + " - Такого нету, загрузили...");
            } else {
                System.out.println(iter + " из " + count + " - " + article + " - Уже есть...");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
