package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Intro {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = -9; i < 10; i++) {
            list.add(i);
        }
        List<Integer> posList = list.stream().filter(
                x -> x > 0
        ).collect(Collectors.toList());
        posList.forEach(System.out::println);
    }
}
