/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package value4it;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author Apopov
 */
public class Class4Test {

    public static void main(String[] args) {

//        List lst = new ArrayList();
//        int k = 0;
//        for (int i = 1; i <= 100; i++) {
//            lst.add(i);
//        }
//        System.out.println(lst.size());
//        if (lst.size() % 10 == 0) {
//            k = lst.size() / 10;
//        } else {
//            k = lst.size() / 10 + 1;
//        }
//        System.out.println(k);
//
//            for (int j = 0; j < k; j++) {
//                for (int l = j * 10; l < (j + 1) * 10; l++) {
//                    try{
//                    System.out.println(lst.get(l));
//                    } catch(IndexOutOfBoundsException ex){}
//                    }
//                System.out.println("Далее...");
//            }
        final Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        //cal.roll(Calendar.HOUR_OF_DAY, 24);
//        cal.
        System.out.println(cal.get(Calendar.DATE) + "/"//
                + cal.get(Calendar.MONTH) + "/"//
                + cal.get(Calendar.YEAR) + " "//
                + cal.get(Calendar.HOUR_OF_DAY) + ":"//
                + cal.get(Calendar.MINUTE) + ":"//
                + cal.get(Calendar.SECOND));

    }
}