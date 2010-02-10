/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package value4it;

import java.util.Arrays;
import java.util.TimeZone;

/**
 *
 * @author APopov
 */
public class Test {

    public Test() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        TimeZone tz = TimeZone.getDefault();
        int rawOffset = tz.getRawOffset();
        System.out.println("Current TimeZone" + tz.getDisplayName() + tz.getID() + "\n\n");
        // Dispaly all available TimeZones
        System.out.println("All Available TimeZones \n");
        String[] idArr = TimeZone.getAvailableIDs();
        for (int cnt = 0; cnt < idArr.length; cnt++) {
            tz = TimeZone.getTimeZone(idArr[cnt]);
            System.out.println(test.padr(tz.getDisplayName() +
                    tz.getID(), 64) + " raw offset=" + tz.getRawOffset() +
                    ";hour offset=(" + tz.getRawOffset() / (1000 * 60 * 60) + ")");
        }
        // Dispaly all available TimeZones same as for Moscow
        System.out.println("\n\n TimeZones same as for Moscow \n");
        idArr = TimeZone.getAvailableIDs(rawOffset);
        for (int cnt = 0; cnt < idArr.length; cnt++) {
            tz = TimeZone.getTimeZone(idArr[cnt]);
            System.out.println(test.padr(tz.getDisplayName() +
                    tz.getID(), 64) + " raw offset=" + tz.getRawOffset() +
                    ";hour offset=(" + tz.getRawOffset() / (1000 * 60 * 60) + ")");
        }
    }

    String padr(String str, int len) {
        if (len - str.length() > 0) {
            char[] buf = new char[len - str.length()];
            Arrays.fill(buf, ' ');
            return str + new String(buf);
        } else {
            return str.substring(0, len);
        }
    }
}

