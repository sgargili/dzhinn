/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package processing.split;

/**
 *
 * @author PAV
 */
public class StrSepNR {

    public static String[] SplitString(String sentence) {
        String[] tokens = null;
        sentence = sentence.replaceAll("\\r", "");
        String splitPattern = "\\n";
        if (!sentence.equals("")) {
            tokens = sentence.split(splitPattern);
        }
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
        }
        return tokens;
    }
}
