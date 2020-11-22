package ru.job4j.tracker;

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
    public void whenSortByIdStraightAndReversed() {
        List<Item> list = new ArrayList<>(5);
        list.add(new Item(5, "five"));
        list.add(new Item(4, "four"));
        list.add(new Item(2, "two"));
        list.add(new Item(1, "one"));
        list.add(new Item(3, "three"));
        list.sort(new SortByIdItem());
        assertThat(list, is(List.of(new Item(1, "one"),
                                    new Item(2, "two"),
                                    new Item(3, "three"),
                                    new Item(4, "four"),
                                    new Item(5, "five"))));
        list.sort(new SortByIdItem().reversed());
        assertThat(list, is(List.of(new Item(5, "five"),
                                    new Item(4, "four"),
                                    new Item(3, "three"),
                                    new Item(2, "two"),
                                    new Item(1, "one"))));
    }

    @Test
    public void whenSortByIdReversed() {
        List<Item> list = new ArrayList<>(5);
        list.add(new Item(5, "five"));
        list.add(new Item(4, "four"));
        list.add(new Item(2, "two"));
        list.add(new Item(1, "one"));
        list.add(new Item(3, "three"));
        list.sort(new SortByIdItemReversed());
        assertThat(list, is(List.of(new Item(5, "five"),
                                    new Item(4, "four"),
                                    new Item(3, "three"),
                                    new Item(2, "two"),
                                    new Item(1, "one"))));
    }
}