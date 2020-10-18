package ru.job4j.tracker;

public class PrintAction implements UserAction {
    @Override
    public String name() {
        return "=== Print all the items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (Item i : allItems) {
            System.out.println(i.toString());
        }
        System.out.println();
        return true;
    }
}
