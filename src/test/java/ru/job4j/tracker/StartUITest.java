package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Create a new Item ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "=== A new Item has been created ===" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Create a new Item ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));

    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old item name"));
        String newName = "New item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0" ,"1", "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(newName));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Replace an item ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "=== The item has been replaced ===" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Replace an item ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("New item"));
        int itemId = tracker.findAll()[0].getId();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(itemId),is(nullValue()));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Delete an item ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "=== The item has been deleted ===" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Delete an item ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenPrintAllItems() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item name"));
        UserAction[] actions = {
                new PrintAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Print all the items ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Print all the items ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item name"));
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find an item by id ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "The item:" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find an item by id ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item name"));
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find items by name ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "The items with the name " + "\"" + item.getName() + "\"" + ":" + System.lineSeparator() +
                        item + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find items by name ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));

    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "-1", "0" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "%n"
                                + "Menu.%n"
                                + "0. === Exit ===%n"
                )
        ));
    }

    @Test (expected = NumberFormatException.class)
    public void whenNFEExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "asdasd", "0" }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
    }
}