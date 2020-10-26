package ru.job4j.tracker;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TrackerSingleLazySFTest extends TestCase {

    public void testGetInstance() {
        Tracker tracker1 = TrackerSingleLazySF.getInstance();
        Tracker tracker2 = TrackerSingleLazySF.getInstance();
        assertThat(tracker1, is(tracker2));
        assertThat(tracker1, is(notNullValue()));
    }
}