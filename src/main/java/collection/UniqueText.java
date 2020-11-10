package collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rslDir = true;
        boolean rslRev = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        HashSet<String> checkRev = new HashSet<>(Arrays.asList(text));
        for (String el : text) {
            if (!check.contains(el)) {
                rslDir = false;
                break;
            }
        }
        for (String el : origin) {
            if (!checkRev.contains(el)) {
                rslRev = false;
                break;
            }
        }
        return rslDir || rslRev;
    }
}