package energy_glow.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private int age;
    private String email;

    public Person(){

    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
