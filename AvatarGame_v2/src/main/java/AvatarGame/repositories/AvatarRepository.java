package AvatarGame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AvatarGame.entities.avatar.Avatar;

public interface AvatarRepository extends JpaRepository<Avatar, Long>{

}
