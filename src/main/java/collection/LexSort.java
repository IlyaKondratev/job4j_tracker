package collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftNum = Integer.parseInt(left.substring(0, left.indexOf(".")));
        int rightNum = Integer.parseInt(right.substring(0, right.indexOf(".")));
        return Integer.compare(leftNum, rightNum);
    }
}
