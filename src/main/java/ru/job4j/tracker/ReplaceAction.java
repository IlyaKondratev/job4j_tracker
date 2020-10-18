package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Replace an item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        String name = input.askStr("Please enter a new name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("=== The item has been replaced ====");
        } else {
            System.out.println("=== An item with id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        System.out.println();
        return true;
    }
}
