package energy_glow.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Item")
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Item name should not be empty")
    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    public Item(){

    }

    public Item(String itemName, Person owner) {
        this.itemName = itemName;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                ", itemName='" + itemName + '\'' +
                ", person=" + owner +
                '}';
    }
}
