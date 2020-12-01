package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterNameUn(List<Attachment> list,
                                                    Predicate<String> condition) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (condition.test(att.getName())) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterSizeUn(List<Attachment> list,
                                                    Predicate<Integer> condition) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (condition.test(att.getSize())) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static <P> List<Attachment> filter(List<Attachment> list,
                                                Predicate<P> condition,
                                                    Function<Attachment, P> function) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (condition.test(function.apply(att))) {
                rsl.add(att);
            }
        }
        return rsl;
    }

}