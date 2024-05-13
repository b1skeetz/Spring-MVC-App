package energy_glow.DAO;

import energy_glow.Models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final EntityManagerFactory managerFactory;

    @Autowired
    public PersonDAO(EntityManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        EntityManager manager = managerFactory.createEntityManager();

        return manager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(Long id) {
        EntityManager manager = managerFactory.createEntityManager();
        return manager.createQuery("select p from Person p where p.id = :personId", Person.class)
                .setParameter("personId", id).getSingleResult();
    }

    @Transactional
    public void save(Person person) {
        EntityManager manager = managerFactory.createEntityManager();
        manager.persist(person);
    }

    @Transactional
    public void update(Long id, Person updatedPerson) {
        EntityManager manager = managerFactory.createEntityManager();
        Query updatePerson = manager.createQuery("update Person p set " +
                " p.age = :age," +
                " p.name = :name," +
                " p.address = :address," +
                " p.email = :email where p.id = :id");

        updatePerson.setParameter("age", updatedPerson.getAge());
        updatePerson.setParameter("name", updatedPerson.getName());
        updatePerson.setParameter("address", updatedPerson.getAddress());
        updatePerson.setParameter("email", updatedPerson.getEmail());
        updatePerson.setParameter("email", updatedPerson.getEmail());
        updatePerson.setParameter("id", id);

        updatePerson.executeUpdate();
    }

    @Transactional
    public void delete(Long id) {
        EntityManager manager = managerFactory.createEntityManager();
        Person person = manager.createQuery("select p from Person p where p.id = :personId", Person.class)
                .setParameter("personId", id).getSingleResult();
        manager.remove(person);
    }

}