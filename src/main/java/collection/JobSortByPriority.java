package collection;

import java.util.Comparator;

public class JobSortByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }

    @Override
    public Comparator<Job> reversed() {
        return ((o2, o1) -> Integer.compare(o2.getPriority(), o1.getPriority()));
    }

}
