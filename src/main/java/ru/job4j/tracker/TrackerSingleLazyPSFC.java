package ru.job4j.tracker;

public class TrackerSingleLazyPSFC {
    private static Tracker instance;

    private TrackerSingleLazyPSFC() {

    }

    static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

}
