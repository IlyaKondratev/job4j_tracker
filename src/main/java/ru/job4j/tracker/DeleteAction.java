package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete an item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        if (tracker.delete(id)) {
            System.out.println("=== The item has been deleted ====");
        } else {
            System.out.println("=== An item with id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        System.out.println();
        return true;
    }
}
