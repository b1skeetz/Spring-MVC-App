package energy_glow.DAO;

import energy_glow.Models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PersonDAO {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public PersonDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        EntityManager manager = entityManagerFactory.createEntityManager();

//            List<Person> people = manager.createQuery("select p from Person p", Person.class).getResultList();
//
//            for (Person person : people) {
//                System.out.println("Person " + person.getName() + " has: " + person.getItems());
//            }

        List<Person> people = manager.createQuery("select p from Person p left join fetch p.items",
                Person.class).getResultList();

        for (Person person : people) {
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }
    }
}
