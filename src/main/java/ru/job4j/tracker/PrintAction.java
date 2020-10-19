package ru.job4j.tracker;

public class PrintAction implements UserAction {
    private final Output out;

    public PrintAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Print all the items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (Item i : allItems) {
            out.println(i.toString());
        }
        out.println("");
        return true;
    }
}
