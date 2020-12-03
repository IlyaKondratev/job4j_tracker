package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DiapasonFunction {
    static public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        if (start >= end) {
            return null;
        } else {
            List<Double> rsl = new ArrayList<>(end - start);
            for (int i = start; i < end; i++) {
                rsl.add(func.apply((double)i));
            }
            return rsl;
        }
    }
}
