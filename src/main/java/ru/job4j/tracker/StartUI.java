package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("=== A new Item has been created ====");
        System.out.println();
    }

    public static void printAllItems(Input input, Tracker tracker) {
        System.out.println("=== Printing all the items ====");
        Item[] allItems = tracker.findAll();
        for (Item i : allItems) {
            System.out.println(i.toString());
        }
        System.out.println();
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit an item ====");
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        String name = input.askStr("Please enter a new name: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("=== The item has been edited ====");
        } else {
            System.out.println("=== An item with id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        System.out.println();
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete an item ====");
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        if (tracker.delete(id)) {
            System.out.println("=== The item has been deleted ====");
        } else {
            System.out.println("=== An item with id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        System.out.println();
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find an item by id ====");
        int id = Integer.parseInt(input.askStr("Please enter an id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("The item:");
            System.out.println(item.toString());
        } else {
            System.out.println("=== An item with the id " + "\"" + id + "\"" + " hasn't been found ====");
        }
        System.out.println();
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
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
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1){
                StartUI.printAllItems(input, tracker);
            } else if (select == 2){
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}