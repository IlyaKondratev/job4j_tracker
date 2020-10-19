package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete an item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        if (tracker.delete(id)) {
            out.println("=== The item has been deleted ===");
        } else {
            out.println("=== An item with id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        out.println("");
        return true;
    }
}
