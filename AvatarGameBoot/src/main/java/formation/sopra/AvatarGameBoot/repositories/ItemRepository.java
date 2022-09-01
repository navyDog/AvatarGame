package formation.sopra.AvatarGameBoot.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;



public interface ItemRepository extends JpaRepository<Item, Long>{
	@Transactional
	@Modifying
	@Query("delete Item i where i.avatar=:avatar")
	void deleteItemByAvatar(@Param("avatar") Avatar avatar);
}
