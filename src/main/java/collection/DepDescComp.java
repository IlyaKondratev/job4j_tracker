package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Spl = o1.split("/");
        String[] o2Spl = o2.split("/");
        int firstComp = o2Spl[0].compareTo(o1Spl[0]);
        if (firstComp != 0) {
            return firstComp;
        } else {
            return o1.compareTo(o2);
        }
    }
}
