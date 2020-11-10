package collection;

import junit.framework.TestCase;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest extends TestCase {

    public void testAdd() {
        Citizen citizen1 = new Citizen("1", "ilya");
        Citizen citizen2 = new Citizen("2", "ivan");
        PassportOffice passportOffice = new PassportOffice();
        assertThat(passportOffice.add(citizen1),is(true));
        assertThat(passportOffice.add(citizen2),is(true));
        assertThat(passportOffice.add(citizen1),is(false));
        assertThat(passportOffice.get(citizen1.getPassport()),is(citizen1));
        assertThat(passportOffice.get(citizen2.getPassport()),is(citizen2));
    }

}