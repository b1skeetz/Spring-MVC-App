package energy_glow.services;

import energy_glow.Models.Person;
import energy_glow.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(Long id){
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public Optional<Person> findByEmail(String email){
        return peopleRepository.findByEmail(email);
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update(Long id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson); // save и для сохранения, и для обновления
    }

    @Transactional
    public void delete(Long id){
        peopleRepository.deleteById(id);
    }

    public void test(){
        System.out.println("Testing here with debug inside Hibernate Transaction");
    }
}
