package server.server;

import java.util.regex.*;

public class BasicReplace {
    
    public static void main(String[] args) {
        
        String inputStr = "{\"product\":{\"datatype\":\"ArticleID\",\"language\":[\"All\"],\"status\":\"A]]]ll\",\"newnew\":\"222\",\"submit\":\"Export\"}}";
        String patternStr = "[\\[\\]]";
        String replacementStr = "";
        
        // Compile regular expression
        Pattern pattern = Pattern.compile(patternStr);
        
        // Replace all occurrences of pattern in input
        Matcher matcher = pattern.matcher(inputStr);
        String output = matcher.replaceAll(replacementStr);
		System.out.println(inputStr);
		System.out.println(output);
        // p s r p s r
    }
} 