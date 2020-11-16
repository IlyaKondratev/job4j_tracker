package collection.bank;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortByIdItem;
import ru.job4j.tracker.SortByIdItemReversed;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortByIdItemTest {

    @Test
    public void WhenSortByIdStraightAndReversed() {
        List<Item> list = new ArrayList<>(5);
        list.add(new Item(5, "five"));
        list.add(new Item(4, "four"));
        list.add(new Item(2, "two"));
        list.add(new Item(1, "one"));
        list.add(new Item(3, "three"));
        list.sort(new SortByIdItem());
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).getId(), is(i + 1));
        }
        list.sort(new SortByIdItem().reversed());
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).getId(), is(list.size() - i));
        }
    }

    @Test
    public void WhenSortByIdReversed() {
        List<Item> list = new ArrayList<>(5);
        list.add(new Item(5, "five"));
        list.add(new Item(4, "four"));
        list.add(new Item(2, "two"));
        list.add(new Item(1, "one"));
        list.add(new Item(3, "three"));
        list.sort(new SortByIdItemReversed());
        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).getId(), is(list.size() - i));
        }
    }
}