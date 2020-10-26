package ru.job4j.tracker;

public enum TrackerSingleEagerENUM {
    INSTANCE;

    Tracker tracker = new Tracker();
}
