package lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> addressTest = x -> x.getAddress().contains(key);
        Predicate<Person> nameTest = x -> x.getName().contains(key);
        Predicate<Person> phoneTest = x -> x.getPhone().contains(key);
        Predicate<Person> surnameTest = x -> x.getSurname().contains(key);
        Predicate<Person> combine = addressTest.or(nameTest).or(phoneTest).or(surnameTest);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}