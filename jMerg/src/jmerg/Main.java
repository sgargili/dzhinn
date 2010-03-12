/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmerg;

import dao.FactoryDAO;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import pojo.Article;
import pojo.Attribute;
import pojo.AttributeValue;
import pojo.Bank;
import pojo.Groupe;

/**
 *
 * @author APopov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank bank;
        Article art;
        Set articles;
        Groupe groupe;
        Set groupes;
        Attribute atr;
        Set attributes;
        Set attributeValues;
        AttributeValue artV;
//        List test = FactoryDAO.getInstance().getBankDAO().getAllBanks();
//        Iterator it = test.iterator();
//        int i = 1;
//        while (it.hasNext()) {
//            bank = (Bank) it.next();
//            System.out.println(i++);
//            groupes = bank.getGroupes();
//            Iterator itn = groupes.iterator();
//            while (itn.hasNext()) {
//                groupe = (Groupe) itn.next();
//                System.out.println(groupe.getGroupeId() + " - " + groupe.getGroupeName());
//            }
//        }
        bank = FactoryDAO.getInstance().getBankDAO().getBankById(222);

        articles = bank.getArticles();
        Iterator itn = articles.iterator();
        while (itn.hasNext()) {
            art = (Article) itn.next();
            //attributeValues = atr.getAttributeValues();
            System.out.println(art.getArticleId() + " - " + art.getArticleName());
//            Iterator itn2 = attributeValues.iterator();
//            while (itn2.hasNext()) {
//                artV = (AttributeValue) itn2.next();
//                System.out.println(atr.getAttributeId() + " - " + artV.getAttributeValue());
//            }
        }

    }
}
