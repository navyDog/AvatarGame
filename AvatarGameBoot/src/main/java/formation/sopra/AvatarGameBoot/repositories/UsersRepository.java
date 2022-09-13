package formation.sopra.AvatarGameBoot.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import formation.sopra.AvatarGameBoot.entities.user.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	List<Users> findBySolde(Double solde);
	
	Optional<Users> findByKeyWithItems(@Param("id") Long id);
	Optional<Users> findByKeyWithAvatars(@Param("id") Long id);
	Optional<Users> findByKeyWithSItems(@Param("id") Long id);
	Optional<Users> findByKeyWithHeadItems(@Param("id") Long id);
	Optional<Users> findByKeyWithBodyItems(@Param("id") Long id);
	Optional<Users> findByKeyWithLeftHandItems(@Param("id") Long id);
	Optional<Users> findByKeyWithRightHandItems(@Param("id") Long id);
	Optional<Users> findByKeyWithLeftLegItems(@Param("id") Long id);
	Optional<Users> findByKeyWithRightLegItems(@Param("id") Long id);
	
	

	Optional<List<Users>> findAvatar();
	
	Optional<List<Users>> findNoCraftItems();
	Optional<Users> findByKeyWithNoCraftItems(@Param("id") Long id);
	
	Optional<Users> findInfo(@Param("id") Long id);
}






