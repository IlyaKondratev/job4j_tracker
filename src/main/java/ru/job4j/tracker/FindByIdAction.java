package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find an item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("The item:");
            out.println(item.toString());
        } else {
            out.println("=== An item with the id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        out.println("");
        return true;
    }
}
