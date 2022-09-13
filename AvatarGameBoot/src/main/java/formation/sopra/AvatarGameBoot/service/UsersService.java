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
		users.setSolde(1000); 
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
	
	public Users getByIdWithInfo(Long id) {
		return usersRepo.findInfo(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithSItems(Long id) {
		return usersRepo.findByKeyWithSItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithHeadItems(Long id) {
		return usersRepo.findByKeyWithHeadItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithBodyItems(Long id) {
		return usersRepo.findByKeyWithBodyItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithLeftHandItems(Long id) {
		return usersRepo.findByKeyWithLeftHandItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithRightHandItems(Long id) {
		return usersRepo.findByKeyWithRightHandItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithLeftLegItems(Long id) {
		return usersRepo.findByKeyWithLeftLegItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithRightLegItems(Long id) {
		return usersRepo.findByKeyWithRightLegItems(id).orElseThrow(UsersException::new);
	}
	
	public Users getByIdWithNoCraftItems(Long id) {
		return usersRepo.findByKeyWithNoCraftItems(id).orElseThrow(UsersException::new);
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

