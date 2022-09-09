package formation.sopra.AvatarGameBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.AvatarGameBoot.entities.user.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Optional<Utilisateur> findByLogin(String login);
	Optional<Utilisateur> findByEmail(String email);
}
