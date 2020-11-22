package collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.equals(right)) {
            return 0;
        } else {
            int length = Math.min(left.length(), right.length());
            for (int i = 0; i < length; i++) {
                int compChar = Character.compare(left.charAt(i), right.charAt(i));
                if (compChar != 0) {
                    return compChar;
                }
            }
            return length == left.length() ? -1 : 1;
        }
    }
}