package energy_glow.repositories;

import energy_glow.Models.Item;
import energy_glow.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {
    List<Item> findByOwner(Person owner);
    List<Item> findByItemName(String itemName);
}