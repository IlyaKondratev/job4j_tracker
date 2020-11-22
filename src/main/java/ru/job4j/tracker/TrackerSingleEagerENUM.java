package ru.job4j.tracker;

public enum TrackerSingleEagerENUM {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
    
}
