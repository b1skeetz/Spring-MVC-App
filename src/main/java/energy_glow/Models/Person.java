package energy_glow.Models;

import energy_glow.DAO.PersonDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;
    private String name;

    public Person(){

    }
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
