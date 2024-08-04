package spring.env.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.env.models.Item;
import spring.env.models.Person;
import spring.env.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional
public class ItemService
{

  private final ItemsRepository itemsRepository;

  @Autowired
  public ItemService(ItemsRepository itemsRepository)
  {
    this.itemsRepository = itemsRepository;
  }

  public List<Item> findByItemName(String itemName)
  {
    return itemsRepository.findByItemName(itemName);
  }

  public List<Item> findByOwner(Person owner)
  {
    return itemsRepository.findByOwner(owner);
  }
}
