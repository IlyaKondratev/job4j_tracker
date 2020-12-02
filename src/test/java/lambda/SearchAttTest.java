package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SearchAttTest {

    @Test
    public void testFilterTwo() {
        List<Attachment> list = Arrays.asList(new Attachment("debug", 10),
                new Attachment("de", 1000));
        List<Attachment> filterNameList = SearchAtt.filter(
                list, att -> att.getName().contains("bug")
        );
        List<Attachment> expect1 = Arrays.asList(new Attachment("debug", 10));
        assertThat(filterNameList, is(expect1));
        List<Attachment> filterSizeList = SearchAtt.filter(
                list, att -> att.getSize() > 100
        );
        List<Attachment> expect2 = Arrays.asList(new Attachment("de", 1000));
        assertThat(filterSizeList, is(expect2));
    }

}