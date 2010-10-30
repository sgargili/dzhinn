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
    public static void main(String[] args) {
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
        List<Data> datas = fd.getDataDao().getAllData();
        CsvWriter csv = FactoryCsv.getInstance().getCsvWriter("D:/iraData.csv", ",", "utf-8");
        String[] column = new String[3];
        for (Data data : datas) {
            column[0] = data.getArticle();
            column[1] = data.getAttribute();
            column[2] = data.getValue().replaceAll("\n"," ");
            try {
                csv.writeRecord(column);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        csv.close();

    }
}
