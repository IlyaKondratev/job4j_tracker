package lambda;

import java.util.Comparator;

public class LambdaBlock {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("comparing " + left + " " + right);
            return left.compareTo(right);
        };
        System.out.println(cmpText.compare("asds", "rfhgsdf"));
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("comparing " + left + " " + right);
            return Integer.compare(right.length(), left.length());
        };
        System.out.println(cmpDescSize.compare("aads", "rfhgsdf"));
    }
}
