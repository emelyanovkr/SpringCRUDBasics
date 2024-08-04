package spring.env.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.env.models.Item;
import spring.env.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer>
{
  List<Item> findByItemName(String itemName);

  List<Item> findByOwner(Person owner);
}
