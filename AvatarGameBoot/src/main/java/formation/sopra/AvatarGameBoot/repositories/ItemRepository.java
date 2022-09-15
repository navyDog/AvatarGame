package formation.sopra.AvatarGameBoot.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.user.Users;



public interface ItemRepository extends JpaRepository<Item, Long>{
	@Transactional
	@Modifying
	@Query("delete Item i where i.avatar=:avatar")
	void deleteItemByAvatar(@Param("avatar") Avatar avatar);
	Optional<List<Item>> findAllSaleable();
}
