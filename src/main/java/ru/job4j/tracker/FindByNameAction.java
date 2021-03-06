package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Please enter a name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            out.println("The items with the name " + "\"" + name + "\"" + ":");
            for (Item i : items) {
                out.println(i.toString());
            }
        } else {
            out.println("=== No items with the name " + "\"" + name
                            + "\"" + " have been found ===");
        }
        out.println("");
        return true;
    }
}
