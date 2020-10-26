package ru.job4j.tracker;

public class TrackerSingleEagerSFF {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleEagerSFF() {

    }

    static Tracker getInstance() {
        return INSTANCE;
    }
}
