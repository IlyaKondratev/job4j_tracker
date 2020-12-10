package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {

    @Test
    public void testCollect() {
        List<Profile> profiles = new ArrayList<>();
        Address adr1 = new Address("Moscow",
                                    "Pavlova",
                                    90,
                                5);
        Address adr2 = new Address("Klin",
                                    "Lenina",
                                    9,
                                50);
        profiles.add(new Profile(adr1));
        profiles.add(new Profile(adr2));
        List<Address> addresses = Profile.collect(profiles);
        List<Address> expect = List.of(adr1, adr2);
        assertThat(addresses, is(expect));
    }
}