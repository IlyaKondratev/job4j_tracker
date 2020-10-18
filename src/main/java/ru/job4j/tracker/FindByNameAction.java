package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Please enter a name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            System.out.println("The items with the name " + "\"" + name + "\"" + ":");
            for (Item i : items) {
                System.out.println(i.toString());
            }
        } else {
            System.out.println("=== No items with the name " + "\"" + name + "\"" + " have been found ====");
        }
        System.out.println();
        return true;
    }
}
