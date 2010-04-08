/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author APopov
 */
public class NewClass2 {

    protected static Set nicknames = new TreeSet();

    public static void addNickname(String aNickname) {
        nicknames.add(aNickname);
    }

    public static void main(String[] args) {
        Map mp = new HashMap();
        int i = 2;
        mp.put(i, "444");
        System.out.println(mp);
//        NewClass2.addNickname("Bobby");
//        NewClass2.addNickname("Bob");
//        NewClass2.addNickname("Bobby");
//        System.out.println(NewClass2.nicknames);
//        List source = new ArrayList();
//        source.add("one");
//        source.add("two");
//        List target = new ArrayList();
//        target.add("three");
//        target.add("four");
//
//        Collections.copy(target, source);
//        System.out.println(target);
    }
}
