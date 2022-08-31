package formation.sopra.AvatarGameBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.AvatarGameBoot.entities.item.Item;


public interface ItemRepository extends JpaRepository<Item, Long>{

}
