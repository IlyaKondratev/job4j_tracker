package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

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

    @Test
    public void whenAddThreeItemsThenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("test1");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("test2");
        tracker.add(item2);
        Item item3 = new Item();
        item3.setName("test3");
        tracker.add(item3);
        Item[] result = tracker.findAll();
        Item[] expected = new Item[3];
        expected[0] = item1;
        expected[1] = item2;
        expected[2] = item3;
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDeleteOneOfThreeItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setName("test1");
        tracker.add(item1);
        Item item2 = new Item();
        item2.setName("test2");
        tracker.add(item2);
        Item item3 = new Item();
        item3.setName("test3");
        tracker.add(item3);
        tracker.delete(item2.getId());
        Item[] expected = new Item[2];
        expected[0] = item1;
        expected[1] = item3;
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
}