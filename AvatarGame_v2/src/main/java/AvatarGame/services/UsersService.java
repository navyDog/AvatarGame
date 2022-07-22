package AvatarGame.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AvatarGame.entities.personne.Users;
import AvatarGame.exceptions.UsersException;
import AvatarGame.repositories.UsersRepository;
import java.util.List;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepo;
	
	public Users create(Users users) {
		if (users.getNom() == null || users.getPrenom() == null || users.getNom().isEmpty() || users.getNom().isEmpty()) {
			throw new UsersException();
		}
		users.setAvatar(null);
		return usersRepo.save(users);
	}
	
	public Users create(String prenom, String nom) {
		Users users = new Users();
		users.setPrenom(prenom);
		users.setNom(nom);
		users.setSolde(1000);
		return create(users);
	}
	
	public Users createPremium(String prenom, String nom, Double solde) {
		Users users = new Users();
		users.setPrenom(prenom);
		users.setNom(nom);
		users.setSolde(solde);
		return create(users);
	}
	
	public Users getById(Long id) {
		return usersRepo.findById(id).orElseThrow(UsersException::new);
	}

	public Users update(Users users) {
		Users clientEnBase = getById(users.getId());
		clientEnBase.setPrenom(users.getPrenom());
		clientEnBase.setNom(users.getNom());
		clientEnBase.setEmail(users.getEmail());
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
	
	public Users inscription() {
		
		return null;
		}
	
}

