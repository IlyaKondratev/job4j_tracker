package ru.job4j.tracker;

public class TrackerSingleLazySF {
    private static Tracker instance;

    private TrackerSingleLazySF() {

    }

    static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
