package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int rslSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                rsl[rslSize++] = items[i];
            }
        }
        rsl = Arrays.copyOf(rsl,rslSize);
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items,size);
    }

    public boolean replace(int id, Item item) {
        int indexRep = indexOf(id);
        boolean rslDel = (indexRep != -1);
        if (rslDel) {
            item.setId(id);
            items[indexRep] = item;
        }
        return rslDel;
    }

    public boolean delete(int id) {
        int indexDel = indexOf(id);
        boolean rslDel = (indexDel != -1);
        if (rslDel) {
            System.arraycopy(items, indexDel + 1, items, indexDel, size - (indexDel + 1));
            items[size - 1] = null;
            size--;
        }
        return rslDel;
    }
}