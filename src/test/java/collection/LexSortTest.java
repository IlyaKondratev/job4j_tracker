package collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNum1and1andDiffTasks() {
        String[] input = {
                "1. TaskB.",
                "1. TaskA."
        };
        String[] out = {
                "1. TaskA.",
                "1. TaskB."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}