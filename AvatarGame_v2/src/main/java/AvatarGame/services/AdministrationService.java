package AvatarGame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AvatarGame.entities.personne.Users;

//Methode de service pour gerer les méthodes administratives SQL

@Service
public class AdministrationService {

	@Autowired
	private UsersService userService;
	
	public Users inscription(Users users) {
		return userService.create(users);	
	}
}
