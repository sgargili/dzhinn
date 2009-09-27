package processing.split;

import java.util.Arrays;

/**
 *
 * @author PAV
 */
public class StrSepCom {

    public static String[] SplitString(String sentence) {
        String[] tokens = null;
        String splitPattern = ",";
        if (!sentence.equals("")) {
            tokens = sentence.split(splitPattern);
        }
        Arrays.sort(tokens);

        return tokens;
    }
}
