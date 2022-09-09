package formation.sopra.AvatarGameBoot.restController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.user.Users;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;
import formation.sopra.AvatarGameBoot.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersRestController {

	@Autowired
	private UsersService usersService;
	
	private final static Logger LOGGER=LoggerFactory.getLogger(UtilisateurRestController.class);
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Users> getAll() {
		return usersService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Users getById(@PathVariable Long id) {
		return usersService.getById(id);
	}
	
	@GetMapping("/{id}/items")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithItems(@PathVariable Long id) {
		LOGGER.info("jjjjj");
		return usersService.getByIdWithItems(id);
	}
	
	@GetMapping("/{id}/avatars")
	@JsonView(JsonViews.UsersWithAvatars.class)
	public Users findByKeyWithAvatars(@PathVariable Long id) {
		
		return usersService.getByIdWithAvatars(id);	
	}
}
