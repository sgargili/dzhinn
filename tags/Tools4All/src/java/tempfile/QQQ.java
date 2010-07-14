/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tempfile;

import factories.FactoryDAO4Grabli;

/**
 *
 * @author APOPOV
 */
public class QQQ {
public static void main(String[] args){
    System.out.println(FactoryDAO4Grabli.getInstance().getProductTypeDAO().getProductTypeWithGroupesByNativeSQL().size());
}
}
