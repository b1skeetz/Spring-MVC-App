package energy_glow.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 2, max = 30, message = "Length of name should be greater than 2 and lower than 30")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age can't be negative")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Email can't be empty")
    @Email
    @Column(name = "email")
    private String email;

    // Country, City, Postal code (6 digits)
    @NotEmpty(message = "Address can't be empty")
    @Pattern(regexp = "[A-Z]\\w+,\\s[A-Z]\\w+,\\s\\d{6}", message = "Your address should be in this format: " +
            "Country, City, Postal Code (6 digits)")
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<Item> items;

    public Person() {

    }

    public Person(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }
}