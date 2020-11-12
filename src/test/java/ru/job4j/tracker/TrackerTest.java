package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        List<Item> result = tracker.findByName(item1.getName());
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);
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
        List<Item> result = tracker.findAll();
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
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
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Output output = new StubOutput();
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction action = new CreateAction(output);
        action.execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        UserAction action = new ReplaceAction(output);
        action.execute(input, tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
        List<Item> testNewItem = tracker.findByName(item.getName());
        assertThat(testNewItem.isEmpty(), is(true));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        Input input = new StubInput(answers);
        Output output = new StubOutput();
        UserAction action = new DeleteAction(output);
        action.execute(input, tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }
}