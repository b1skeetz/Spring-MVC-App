package energy_glow.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private int id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 2, max = 30, message = "Length of name should be greater than 2 and lower than 30")
    private String name;

    @Min(value = 0, message = "Age can't be negative")
    private int age;

    @NotEmpty(message = "Email can't be empty")
    @Email
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
