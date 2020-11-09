package collection;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person el : persons) {
            if (el.getName().contains(key)
                    || el.getSurname().contains(key)
                        || el.getAddress().contains(key)
                            || el.getPhone().contains(key)) {
                result.add(el);
            }
        }
        return result;
    }
}