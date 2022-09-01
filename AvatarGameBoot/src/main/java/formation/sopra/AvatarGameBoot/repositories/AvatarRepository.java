package formation.sopra.AvatarGameBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{
	
	Optional<Avatar> findByKeyWithItems(@Param("id") Long id);

}
