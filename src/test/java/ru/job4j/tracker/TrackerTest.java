package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenAddThreeItemsThenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("test1");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("test2");
        tracker.add(item2);
        Item item3 = new Item();
        item3.setName("test1");
        tracker.add(item3);
        Item[] result = tracker.findByName(item1.getName());
        Item[] expected = new Item[2];
        expected[0] = item1;
        expected[1] = item3;
        assertThat(result, is(expected));
    }
}