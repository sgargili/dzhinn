/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author APopov
 */
public class NewClass {

    public static void main(String[] arg) {
        Double num = new Double(2.3);
        long iPart;
        double fPart;

        // Get user input
        num = 50850./50.;

        System.out.println(num);
        String str = num.toString();
        String[] strl = str.split("[.]");
        for (int k = 0; k < strl.length; k++) {
            System.out.println(strl[k]);
        }
//        BigInteger bi = BigInteger.valueOf(num.longValue());
//        System.out.println(bi);
//        String Text = num.toString();
//        BigDecimal result = new BigDecimal(Text);
//        bi = result.toBigInteger();
//        System.out.println(result);
//        System.out.println("Integer part = " + iPart);
//        System.out.println("Fractional part = " + fPart);
//        int k = 1;
//        for (int i = 1; i <= 580; i = i + 30) {
//            System.out.println(k + " = " + i);
//        }

    }
}
