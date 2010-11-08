package ira;

import ira.dao.FactoryDao;
import ira.entity.Data;
import ira.httpclient.FactoryHttpData;
import ira.httpclient.HttpData;
import ira.Pics;

import java.io.IOException;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 28.10.2010
 * Time: 16:07:12
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    static String COL1 = "Автор или составитель";
    static String COL2 = "Артикул";
    static String COL3 = "Вес";
    static String COL4 = "Вид исполнения";
    static String COL5 = "Кол-во иллюстраций";
    static String COL6 = "Кол-во страниц";
    static String COL7 = "Номер";
    static String COL8 = "Описание книги";
    static String COL9 = "Полное описание";
    static String COL10 = "Рубрика";
    static String COL11 = "Серия";
    static String COL12 = "Товарная группа";
    static String COL13 = "Формат (размер)";
    static String COL14 = "Цена";
    static String COL15 = "Язык издания";
    static String COL16 = "Full Name";

    public static void main(String[] args) {

//        Links links = new Links();
//        links.getProductLinks();


//        FactoryHtml2Xml xml = FactoryHtml2Xml.getInstance();
//        xml.getHttpData2Xpp().getXpp("http://localhost:8080");
//        Descriptions desc = new Descriptions();
//        desc.getProductDescription();
//        FactoryHttpData http =  FactoryHttpData.getInstance();
//        System.out.println(http.getHttpData().DownloadBinaryFile("http://www.belygorod.ru/preface/N0010407229021.php", true, "C://temp/eee.jpg"));
        FactoryDao fd = FactoryDao.getInstance();
//        Pics pic = new Pics();
//        List<String> articles = fd.getDataDao().getArticles();
//        int iter = 1;
//        int count = articles.size();
//        for (String article : articles) {
//            pic.getNotExistPics(article, iter++, count);
//        }

        String article = "";
        List<Data> datas = fd.getDataDao().getOrderedAllData();
        CsvWriter csv = FactoryCsv.getInstance().getCsvWriter("D:/iraData.csv", ",", "utf-8");
        String[] column = new String[17];
        for (Data data : datas) {
            if (!article.equals(data.getArticle())) {
                try {
                    csv.writeRecord(column);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int k = 0; k < column.length; k++) {
                    column[k] = "";
                }
            }
            column[0] = data.getArticle();
            if (data.getAttribute().equals(COL1)) {
                column[1] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL2)) {
                column[2] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL3)) {
                column[3] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL4)) {
                column[4] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL5)) {
                column[5] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL6)) {
                column[6] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL7)) {
                column[7] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL8)) {
                column[8] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL9)) {
                column[9] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL10)) {
                column[10] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL11)) {
                column[11] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL12)) {
                column[12] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL13)) {
                column[13] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL14)) {
                column[14] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL15)) {
                column[15] = data.getValue().replaceAll("\n", " ");
            } else if (data.getAttribute().equals(COL16)) {
                column[16] = data.getValue().replaceAll("\n", " ");
            }

            article = data.getArticle();

        }
        csv.close();

    }
}
