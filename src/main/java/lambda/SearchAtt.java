package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
public class SearchAtt {

    public static List<Attachment> filter(List<Attachment> list,
                                            Predicate<Attachment> condition) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (condition.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

}