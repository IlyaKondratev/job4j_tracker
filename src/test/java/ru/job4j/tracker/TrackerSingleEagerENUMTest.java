package ru.job4j.tracker;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TrackerSingleEagerENUMTest extends TestCase {

    public void testGetInstance() {
        Tracker tracker1 = TrackerSingleEagerENUM.INSTANCE.getTracker();
        Tracker tracker2 = TrackerSingleEagerENUM.INSTANCE.getTracker();
        Tracker tracker3 = TrackerSingleEagerENUM.INSTANCE.getTracker();
        assertThat(tracker1, is(tracker2));
        assertThat(tracker1, is(tracker3));
        assertThat(tracker1, is(notNullValue()));
    }

}