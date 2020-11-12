package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item el : items) {
            if (el.getName().equals(key)) {
                rsl.add(el);
            }
        }
        return rsl;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        int indexRep = indexOf(id);
        boolean rslDel = (indexRep != -1);
        if (rslDel) {
            item.setId(id);
            items.set(indexRep, item);
        }
        return rslDel;
    }

    public boolean delete(int id) {
        int indexDel = indexOf(id);
        boolean rslDel = (indexDel != -1);
        if (rslDel) {
            items.remove(indexDel);
        }
        return rslDel;
    }
}