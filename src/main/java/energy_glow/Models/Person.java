package energy_glow.Models;

import jakarta.validation.constraints.*;
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

    // Country, City, Postal code (6 digits)
    @NotEmpty(message = "Address can't be empty")
    @Pattern(regexp = "[A-Z]\\w+,\\s[A-Z]\\w+,\\s\\d{6}", message = "Your address should be in this format: " +
            "Country, City, Postal Code (6 digits)")
    private String address;

    public Person(){

    }
    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }
}