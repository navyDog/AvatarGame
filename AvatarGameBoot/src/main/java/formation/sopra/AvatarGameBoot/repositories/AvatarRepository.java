package formation.sopra.AvatarGameBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{

}
