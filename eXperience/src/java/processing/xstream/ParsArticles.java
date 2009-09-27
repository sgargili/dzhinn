/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package processing.xstream;

import com.thoughtworks.xstream.XStream;

/**
 *
 * @author PAV
 */
public class ParsArticles {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        xstream.alias("Articles", Articles.class);
        xstream.alias("article", Article.class);
        //xstream.useAttributeFor(Person.class, "firstname");
        //xstream.useAttributeFor(Person.class, "lastname");
        //xstream.useAttributeFor(PhoneNumber.class, "code");
        //xstream.useAttributeFor(PhoneNumber.class, "number");
       // Person joe = new Person("Joe", "Walnes");
        //joe.setPhone(new PhoneNumber(123, "1234-456"));
       // joe.setFax(new PhoneNumber(123, "9999-999"));
        //String xml = xstream.toXML(joe);
        //System.out.println(xml);
        String xmlNew = "<article id='71129130756771332' classcat_id='71129130756721384' code='222' name='222' full_name='222 Maxim&apos;s Prestige tin of Chocolate powder pack в жести' author='Anton Dezhin ' status='Done' industry='Food' category='Meal' product_type='Sweeties' manufacturer='MAXIM&apos;S' product_family='' series='' model='222'>    <image classcat_id='71129130756721384' name='222' height='56' width='75' ext='jpg' type_id='50503111833075328' type_name='75x56 asb' file_id='71201183406400263' />    <image classcat_id='71129130756721384' name='222' height='160' width='160' ext='jpg' type_id='1' type_name='160x160 asb' file_id='71201183413648455' />    <image classcat_id='71129130756721384' name='222' height='150' width='200' ext='jpg' type_id='3' type_name='200x150 asb' file_id='71201183422111867' />    <image classcat_id='71129130756721384' name='222' height='195' width='260' ext='jpg' type_id='71016094742868208' type_name='260x195 A2Z' file_id='71201183431302332' />    <image classcat_id='71129130756721384' name='222' height='300' width='400' ext='jpg' type_id='2' type_name='400x300 asb' file_id='71201183441737912' />    <image classcat_id='71129130756721384' name='222' height='500' width='500' ext='jpg' type_id='70603182252047402' type_name='500x500 plaza' file_id='71201183450181082' />    <lang lang='en'>      <marketing text='A lovely black oval tin filled with a golden pouch of Maxim&apos;s chocolate powder for a better preservation.Chocolate powder with a high percentage of cocoa. Easy to use, ideal as a hot drink or for desserts.' src='' type='2' classcat_id='71129130756721384' />    </lang>    <lang lang='ru'>      <marketing text='Какао-порошок от Maxim&apos;s в очаровательной черной жестяной упаковке. Высокое содержание какао. Какао-порошок идеален для приготовления горячих напитков и десертов, легок в использовании.&lt;br&gt;&lt;br&gt;&lt;b&gt;Состав:&lt;/b&gt; сахар, какао-порошок минимум 34%.' src='' type='2' classcat_id='71129130756721384' />    </lang>  </article>  <elapsedTime msec='97' /></Articles>";
        Articles newJoe = (Articles) xstream.fromXML(xmlNew);
        System.out.println(newJoe.getArticle().getId());
    }

}
