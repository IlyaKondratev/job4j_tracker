package collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ilya");
        names.add("Ivan");
        names.add("Alexandr");
        for (String el : names) {
            System.out.println(el);
        }
    }
}
