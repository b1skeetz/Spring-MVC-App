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
                new Person(++PEOPLE_COUNT, "Tom"),
                new Person(++PEOPLE_COUNT, "Mike"),
                new Person(++PEOPLE_COUNT, "Bob"),
                new Person(++PEOPLE_COUNT, "Katy")
                ));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

}
