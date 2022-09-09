package formation.sopra.AvatarGameBoot.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.user.Users;
import formation.sopra.AvatarGameBoot.exceptions.AvatarException;
import formation.sopra.AvatarGameBoot.exceptions.UsersException;
import formation.sopra.AvatarGameBoot.repositories.UsersRepository;


@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepo;

	
	public Users create(Users users) {		
		users.setAvatar(null);
		users.setSolde(0);
		users.setItems(null);
		return usersRepo.save(users);	
	}
	
	public Users getById(Long id) {
		return usersRepo.findById(id).orElseThrow(UsersException::new);
	}

	
	public Users getByIdWithItems(Long id) {
		return usersRepo.findByKeyWithItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithAvatars(Long id) {
		return usersRepo.findByKeyWithAvatars(id).orElseThrow(UsersException::new);
	}
	
	
	public Users update(Users users) {
		Users clientEnBase = getById(users.getId());
		clientEnBase.setSolde(users.getSolde());
		//to DO
		return usersRepo.save(clientEnBase);
	}

	public List<Users> getAll() {
		return usersRepo.findAll();
	}

	public void delete(Users users) {
		//to DO
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
	
}

