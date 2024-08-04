package spring.env.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Item")
public class Item
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "person_id", referencedColumnName = "id")
  private Person owner;

  @NotEmpty(message = "Item Name shouldn't be empty")
  @Column(name = "item_name")
  private String itemName;

  public Item()
  {

  }

  public Item(String itemName)
  {
    this.itemName = itemName;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public Person getOwner()
  {
    return owner;
  }

  public void setOwner(Person owner)
  {
    this.owner = owner;
  }

  public String getItemName()
  {
    return itemName;
  }

  public void setItemName(String itemName)
  {
    this.itemName = itemName;
  }

  @Override
  public String toString()
  {
    return "Item{" +
      "owner=" + owner +
      ", itemName='" + itemName + '\'' +
      '}';
  }
}
