package AvatarGame.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import AvatarGame.entities.personne.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	List<Users> findBySolde(Double solde);
	
	Optional<Users> findByKeyWithItems(@Param("id") Long id);
}






