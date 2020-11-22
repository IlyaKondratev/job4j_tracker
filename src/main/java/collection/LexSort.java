package collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftNum = Integer.parseInt(left.substring(0,left.indexOf(".")));
        int rightNum = Integer.parseInt(right.substring(0,right.indexOf(".")));
        String leftStr = left.substring(left.indexOf(".") + 1);
        String rightStr = right.substring(right.indexOf(".") + 1);
        int compNum = Integer.compare(leftNum, rightNum);
        if (compNum == 0) {
            return leftStr.compareTo(rightStr);
        } else {
            return compNum;
        }
    }
}
