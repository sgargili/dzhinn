/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gkey;

/**
 *
 * @author APopov
 */
public class Class4Test {

    public static void main(String[] args) {
        String first, second, third;
        for (int i = 10000; i < 100000; i++) {
            first = (i + "").substring(0, 1);
            second = (i + "").substring(1, 2);
            third = (i + "").substring(2);
            System.out.print(i);
            System.out.print(" - " + first);
            System.out.print(" - " + second);
            System.out.println(" - " + third);
        }
    }
}
