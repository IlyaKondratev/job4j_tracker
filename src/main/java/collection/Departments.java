package collection;

import java.util.*;
import java.util.List;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String el : deps) {
            StringBuilder start = new StringBuilder();
            for (String sp : el.split("/")) {
                start.append(sp);
                tmp.add(start + "");
                start.append("/");
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}