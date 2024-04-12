package energy_glow.DAO;

import energy_glow.Models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>(Arrays.asList(
                new Person(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"),
                new Person(++PEOPLE_COUNT, "Mike", 52, "mike@mail.ru"),
                new Person(++PEOPLE_COUNT, "Bob", 18, "bob@mail.ru"),
                new Person(++PEOPLE_COUNT, "Katy", 34, "katy@mail.ru")
                ));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }
    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}