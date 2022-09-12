package formation.sopra.AvatarGameBoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import formation.sopra.AvatarGameBoot.entities.user.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	List<Users> findBySolde(Double solde);
	
	Optional<Users> findByKeyWithItems(@Param("id") Long id);
	Optional<Users> findByKeyWithAvatars(@Param("id") Long id);
//	Optional<Users> findByKeyWithCommonItems(@Param("id") Long id);
	Optional<Users> findInfo(@Param("id") Long id);
}






