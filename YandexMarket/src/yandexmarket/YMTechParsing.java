/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yandexmarket;

import CSV.CsvWriter;
import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Articles;
import Pojo.Matching;
import Pojo.Newarticles;
import Proxy.IpChange;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author IRozhkov
 */
public class YMTechParsing {

    private static String theOutputEncoding = "UTF-8";

    public static void main(String[] args) throws XmlPullParserException, SQLException, UnsupportedEncodingException, IOException {
        // Инициализация...
        String dst = "C://javaTemp/new.xhtml";
        OutputStream os = null;
        XMLReader r;
        Writer w = null;
        ContentHandler h;
        http ht = new http();
        File fl;
        IpChange ip = new IpChange();

        // Шаблоны регекспов для определения кидалово со стороны яндекса.
        Pattern p = Pattern.compile("captcha.yandex.net");
        Matcher m;
        Pattern p2 = Pattern.compile(".title.404");
        Matcher m2;
        Pattern p3 = Pattern.compile("Connect to market.yandex.ru:80 failed");
        Matcher m3;

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);

        Matching mtch;

        int pageCount = 1;
        String[] stringContent;
        FactoryDAO fd = FactoryDAO.getInstance();


        // Выбор нужных данных с яндекса...

        // Грузим список артиклей кея из базы...
        List<Newarticles> articles = (List<Newarticles>) fd.getnewArticlesDAO().getAllArticles();

        // int i = 1;
        int wordsCount = 1;
        String tempDesc = "";
        String yandexData = "";
        Set<String> codes;
        String code;
        String url;
        File temp;
        String tempURL = "";
        String DldURL = "";
        boolean finded = false,
                lstBool = false,
                URLBool = false;
        String[] testArt = new String[4];

        CsvWriter wrtr = new CsvWriter("C://1/KeyProdsNew.csv", ',', Charset.forName("WINDOWS-1251"));

        // Цикл по всем артиклям выгруженным из базы
        for (Iterator iter = articles.iterator(); iter.hasNext();) {
            Newarticles art = (Newarticles) iter.next();
            tempDesc = "";
            finded = false;

            tempDesc = art.getSearchdesc();
            System.out.println("*******************************************");
            System.out.print(art.getId() + ") " + tempDesc);
            System.out.println(" <"+art.getKeyart()+">");

            // Если описание русское, то его переводим в формат юникода,
            // чтобы URL была хорошая.
            tempDesc = URLEncoder.encode(tempDesc.trim(), "UTF-8");

            // Бесконечный цикл созднынный для того, чтобы бегать тором
            // по яндексу пока он нас не пустит, как только пустит, то выход
            // из цикла брейком.
            while (true) {
                try {
                    int pageCounts = 1;
                    // Говорим яндексу, что мы из москвы
                    ht.setCookie("http://tune.yandex.ru/region/save2.xml?fretpath=http://market.yandex.ru&domain=yandex.ru&retpath=http://market.yandex.ru&region_id=213", true);

                    // Строка запрос яндексу
                    url = "http://market.yandex.ru/search.xml?text=" +//
                            tempDesc//
                            + "&nopreciser=1&page=" +//
                            pageCounts;
                    System.out.println(url);
                    fl = ht.DownloadContentAsFile(url, true);

                    // Пара регекспов для определния того, что яндекс
                    // нас отбросил. Если они оба не находятся на странице,
                    // то значит что яндекс нас пустил, запоминаем
                    // содержимое странички и выходим из цикла брейком.
                    m = p.matcher(FileUtils.readFileToString(fl, theOutputEncoding));
                    m2 = p2.matcher(FileUtils.readFileToString(fl, theOutputEncoding));
                    m3 = p3.matcher(FileUtils.readFileToString(fl, theOutputEncoding));
                    if (!m.find() & !m2.find() & !m3.find()) {
                        temp = new File("C://javaTemp/" + art.getKeyart() + ".xhtml");
                        FileUtils.writeStringToFile(temp, FileUtils.readFileToString(fl, theOutputEncoding), "UTF-8");
                        break;
                    }

                    // Если регекспы сработали, то значит надо поменять IP
                    // и начать по-новой...
                    ip.setChange();
                    System.out.println("Сменился Ip...");

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

            // Разбор полученой странички.
            try {
                os = new FileOutputStream(dst);
                r = new Parser();
                w = new OutputStreamWriter(os, theOutputEncoding);
                h = new XMLWriter(w);


                String artURL = "",
                        yaDesc = "";
                r.setContentHandler(h);
                r.parse(fl.toURI().toString());
                xml = new File(dst);
                xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "UTF-8"));

                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {

//                    if (eventType == XmlPullParser.START_TAG && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals("b-offers__title")) {
//                        URLBool = true;
//                    }

                    if (eventType == XmlPullParser.START_TAG && xpp.getName().equals("a") && xpp.getAttributeCount() == 2) {
                        URLBool = false;
                        tempURL = xpp.getAttributeValue(0);
                        System.out.print(tempURL);
                        System.out.println(" | " + tempURL.indexOf("show-uid"));
                        //System.out.println("вроде нашли ссылку: " + tempURL);
                        //&& xpp.getAttributeValue(1).indexOf("model.xml?hid")>-1
                        //&& xpp.getAttributeValue(0).indexOf("model.xml?hid") != -1
                    }

                    if (eventType == XmlPullParser.TEXT) {
                        finded = true;
                        System.out.println("нашлось (страница с описанием)");
                        System.out.println("текст: "+xpp.getText().trim());
                        // && xpp.getText().trim().equals("все характеристики")
                    }

                    if (eventType == XmlPullParser.START_TAG && !finded && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals("b-model-actioins__cnt")) {
                        finded = true;
                        System.out.println("нашлось (список)");
                        lstBool = true;
                        DldURL = "http://market.yandex.ru" + tempURL;
                        System.out.println("Ссылка на описание товара: " + DldURL);
                    }

                    
                    testArt[0] = art.getKeyart();
                    testArt[1] = art.getSearchdesc();
                    testArt[2] = "";
                    if (finded) {
                        testArt[2] = "true";
                    } else {
                        testArt[2] = "false";
                    }
                    testArt[3] = url;

                    eventType = xpp.next();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                os.close();
                w.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            xml.delete();
            System.out.println("Продукт нашелся в маркете? - " + testArt[2]);
            try {

                wrtr.writeRecord(testArt);
                wrtr.flush();
                System.out.println("Записано в файл...");

            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Записать не удалось");
            }
        }
        wrtr.close();
    }
}
