package collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("ilya.kondratev@phystech.edu", "ilya kondratev");
        for (String key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue());
//        }
    }

}
