package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("=== A new Item has been created ====");
                System.out.println();
            } else if (select == 1){
                System.out.println("=== Printing all the items ====");
                Item[] allItems = tracker.findAll();
                for (Item i : allItems) {
                    System.out.println(i.toString());
                }
                System.out.println();
            } else if (select == 2){
                System.out.println("=== Edit an item ====");
                System.out.println("Please enter an id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Please enter a new name: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("=== The item has been edited ====");
                } else {
                    System.out.println("=== An item with id " + "\"" + id + "\"" + " hasn't been found ====");
                }
                System.out.println();
            } else if (select == 3) {
                System.out.println("=== Delete an item ====");
                System.out.println("Please enter an id: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("=== The item has been deleted ====");
                } else {
                    System.out.println("=== An item with id " + "\"" + id + "\"" + " hasn't been found ====");
                }
                System.out.println();
            } else if (select == 4) {
                System.out.println("=== Find an item by id ====");
                System.out.println("Please enter an id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println("The item:");
                    System.out.println(item.toString());
                } else {
                    System.out.println("=== An item with the id " + "\"" + id + "\"" + " hasn't been found ====");
                }
                System.out.println();
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.println("Please enter a name: ");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}