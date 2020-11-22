package collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompatorByName() {
        Comparator<Job> cmpName = new JobSortByName();
        int rsl = cmpName.compare(
                new Job("B task", 0),
                new Job("A bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameRev() {
        Comparator<Job> cmpNameRev = new JobSortByNameRev();
        int rsl = cmpNameRev.compare(
                new Job("A task", 0),
                new Job("B bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriority() {
        Comparator<Job> cmpPriority = new JobSortByPriority();
        int rsl = cmpPriority.compare(
                new Job("A task", 0),
                new Job("B bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityRev() {
        Comparator<Job> cmpPriorityRev = new JobSortByPriorityRev();
        int rsl = cmpPriorityRev.compare(
                new Job("A task", 1),
                new Job("B bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobSortByName().thenComparing(
                                                                new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        int rsl2 = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
        assertThat(rsl2, lessThan(0));
    }

    @Test
    public void whenCompatorByNameRevAndPrority() {
        Comparator<Job> cmpNameRevPriority = new JobSortByNameRev().thenComparing(
                                                new JobSortByPriority());
        int rsl = cmpNameRevPriority.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        int rsl2 = cmpNameRevPriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
        assertThat(rsl2, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityRev() {
        Comparator<Job> cmpNamePriorityRev = new JobSortByName().thenComparing(
                                                new JobSortByPriorityRev());
        int rsl = cmpNamePriorityRev.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        int rsl2 = cmpNamePriorityRev.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
        assertThat(rsl2, lessThan(0));
    }

    @Test
    public void whenCompatorByNameRebAndProrityRev() {
        Comparator<Job> cmpNameRevPriorityRev = new JobSortByNameRev().thenComparing(
                                                    new JobSortByPriorityRev());
        int rsl = cmpNameRevPriorityRev.compare(
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
        );
        int rsl2 = cmpNameRevPriorityRev.compare(
                new Job("Impl task", 1),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
        assertThat(rsl2, lessThan(0));
    }
}