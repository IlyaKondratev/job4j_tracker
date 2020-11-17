package collection;

import java.util.Comparator;

public class JobSortByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }

    @Override
    public Comparator<Job> reversed() {
        return ((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
}
