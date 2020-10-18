package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find an item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("The item:");
            System.out.println(item.toString());
        } else {
            System.out.println("=== An item with the id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        System.out.println();
        return true;
    }
}
