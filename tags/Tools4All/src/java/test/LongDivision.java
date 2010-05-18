/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author APopov
 */
public class LongDivision {

    public static void main(String[] args) {
        Set<Short> s = new HashSet<Short>();
        for(short i = 0; i<100; i++){
            s.add(i);
            s.remove(i-1);
        }
        System.out.println(s.size());
    }
}
