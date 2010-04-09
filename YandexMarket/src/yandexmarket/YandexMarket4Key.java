package yandexmarket;

import CSV.CsvWriter;
import DAO.FactoryDAO;
import HttpClient.http;
import Pojo.Articles;
import Pojo.Matching;
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
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 *
 * @author Admin4DB2
 */
// Программа для матчинга артиклей кея по их описанию в системе яндекс-маркет.
public class YandexMarket4Key {

    private static String theOutputEncoding = "UTF-8";

    public static void main(String[] arg) throws FileNotFoundException, UnsupportedEncodingException, IOException, SAXException, XmlPullParserException, SQLException {

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

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        File xml = new File(dst);

        Matching mtch;

        int pageCount = 1;
        String[] stringContent;
        FactoryDAO fd = FactoryDAO.getInstance();



        // Выбор нужных данных с яндекса...

        // Грузим список артиклей кея из базы...
        List<Articles> articles = (List<Articles>) fd.getArticlesDAO().getAllArticles();

        // int i = 1;
        int wordsCount = 1;
        String tempDesc = "";
        String yandexData = "";
        Set<String> codes;
        String code;
        String url;
        File temp;
        boolean finded = false,
                hrefBool = false;
        String[] testArt = new String[4];

        CsvWriter wrtr = new CsvWriter("C://1/KeyProds3.csv", ',', Charset.forName("WINDOWS-1251"));

        // Цикл по всем артиклям выгруженным из базы
        for (Iterator iter = articles.iterator(); iter.hasNext();) {
            Articles art = (Articles) iter.next();
            tempDesc = "";
            finded = false;
            // Тупая реализация устранения избыточности описания кея. :)
            // Берем не все описание, а только не больше (n/2)+2 слова из описания.
            // И слово должно быть не больше 16 символов.

            // Создаем список типа TreeSet, это список уникальных строк,
            // дубли автоматически не добавляются в список.
            codes = new TreeSet<String>();

            // Определяем массив слов
            stringContent = art.getDescription().split("\\s");

            System.out.print(art.getDescription() + " -> ");
            System.out.print(wordsCount = stringContent.length);

            // Определяем нужное описание.
            if (wordsCount > 3) {
                for (int wr = 0; wr < (wordsCount / 2) + 1; wr++) {//Тут изменил +2 на +1!!!*******************
                    if (stringContent[wr].length() <= 16) {
                        tempDesc += " " + stringContent[wr];
                    }
                }
            } else {
                tempDesc = art.getDescription();
            }

            System.out.println(" " + tempDesc);

            // Если описание русское, то его переводим в формат юникода,
            // чтобы URL была хорошая.
            tempDesc = URLEncoder.encode(tempDesc.trim(), "UTF-8");

            // Количество страниц найденных на сайте, сначала берем одну,
            // потом когда страница откроется возьмем из нее.
            pageCount = 1;

            // Цикл по всем страницам.
            for (int pageCounts = 1; pageCounts <= pageCount; pageCounts++) {

                // Бесконечный цикл созднынный для того, чтобы бегать тором
                // по яндексу пока он нас не пустит, как только пустит, то выход
                // из цикла брейком.
                while (true) {
                    try {

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
                        if (!m.find() & !m2.find()) {
                            temp = new File("C://javaTemp/" + art.getArticle() + ".xhtml");
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
                    xpp.setInput(new InputStreamReader(FileUtils.openInputStream(xml), "WINDOWS-1251"));
                    boolean bool = false, pageBool = false;

                    int eventType = xpp.getEventType();
                    //p = Pattern.compile("Код.*теля:(.*)");
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        if (eventType == XmlPullParser.START_TAG && xpp.getAttributeCount() == 1 && xpp.getAttributeValue(0).equals("b-model-actioins__cnt")) {
                            finded = true;
                            System.out.println("нашлось (список)");
                        }

                        if (eventType == XmlPullParser.TEXT && xpp.getText().trim().equals("все характеристики")) {
                            finded = true;
                            System.out.println("нашлось (страница с описанием)");
                        }

                        testArt[0] = art.getArticle();
                        testArt[1] = art.getDescription();
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
