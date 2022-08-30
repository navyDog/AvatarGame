package AvatarGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AvatarGame.entities.items.Item;


public interface ItemRepository extends JpaRepository<Item, Long>{

}
