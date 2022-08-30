package AvatarGame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AvatarGame.entities.avatar.Avatar;
import AvatarGame.exceptions.AvatarException;
import AvatarGame.repositories.AvatarRepository;



@Service
public class AvatarService {
	
	@Autowired
	private AvatarRepository avatarRepo;
	
	public Avatar create(Avatar avatar) {

		return avatarRepo.save(avatar);
	}
	
	public Avatar getById(Long id) {
		return avatarRepo.findById(id).orElseThrow(AvatarException::new);
	}

	public Avatar update(Avatar avatar) {
		Avatar clientEnBase = getById(avatar.getId());
		clientEnBase.setNom(avatar.getNom());
		clientEnBase.setPrice(avatar.getPrice());
	
		//to DO
		return avatarRepo.save(clientEnBase);
	}

	public List<Avatar> getAll() {
		return avatarRepo.findAll();
	}

	public void delete(Avatar avatar) {
		//to DO
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
}

