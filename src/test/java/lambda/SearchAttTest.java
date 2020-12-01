package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SearchAttTest {

    @Test
    public void testFilterNameUn() {
        List<Attachment> List = Arrays.asList(new Attachment("debug", 10),
                                                new Attachment("de", 1000));
        List<Attachment> filterNameList = SearchAtt.filterNameUn(List, s -> s.contains("bug"));
        List<Attachment> expect = Arrays.asList(new Attachment("debug", 10));
        assertThat(filterNameList, is(expect));
    }

    @Test
    public void testFilterSizeUn() {
        List<Attachment> List = Arrays.asList(new Attachment("debug", 10),
                                                new Attachment("de", 1000));
        List<Attachment> filterNameList = SearchAtt.filterSizeUn(List, n -> n > 100);
        List<Attachment> expect = Arrays.asList(new Attachment("de", 1000));
        assertThat(filterNameList, is(expect));
    }

    @Test
    public void testFilter() {
        List<Attachment> List = Arrays.asList(new Attachment("debug", 10),
                                                new Attachment("de", 1000));
        List<Attachment> filterNameList = SearchAtt.filter(List, s -> s.contains("bug"), f -> f.getName());
        List<Attachment> expect1 = Arrays.asList(new Attachment("debug", 10));
        assertThat(filterNameList, is(expect1));
        List<Attachment> filterSizeList = SearchAtt.filter(List, n -> n > 100, f -> f.getSize());
        List<Attachment> expect2 = Arrays.asList(new Attachment("de", 1000));
        assertThat(filterSizeList, is(expect2));
    }


}