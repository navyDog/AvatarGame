package formation.sopra.AvatarGameBoot.restController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
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
		
		return usersService.getByIdWithItems(id);
	}
	
	@GetMapping("/{id}/items/solde")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithSItems(@PathVariable Long id) {
		
		return usersService.getByIdWithSItems(id);
	}
	
	@GetMapping("/{id}/items/head")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithHeadItems(@PathVariable Long id) {
		
		return usersService.getByIdWithHeadItems(id);
	}
	
	@GetMapping("/{id}/items/body")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithBodyItems(@PathVariable Long id) {
		
		return usersService.getByIdWithBodyItems(id);
	}
	
	@GetMapping("/{id}/items/lefthand")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithLeftHandItems(@PathVariable Long id) {
		
		return usersService.getByIdWithLeftHandItems(id);
	}
	
	@GetMapping("/{id}/items/righthand")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithRightHandItems(@PathVariable Long id) {
		
		return usersService.getByIdWithRightHandItems(id);
	}
	
	@GetMapping("/{id}/items/leftleg")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithLeftLegItems(@PathVariable Long id) {
		
		return usersService.getByIdWithLeftLegItems(id);
	}
	
	@GetMapping("/{id}/items/rightleg")
	@JsonView(JsonViews.UsersWithItems.class)
	public Users findByKeyWithRightLegItems(@PathVariable Long id) {
		
		return usersService.getByIdWithRightLegItems(id);
	}
	
	@GetMapping("/{id}/avatars")
	@JsonView(JsonViews.UsersWithAvatars.class)
	public Users findByKeyWithAvatars(@PathVariable Long id) {
		
		return usersService.getByIdWithAvatars(id);	
	}
	
	@GetMapping("/{id}/information")
	@JsonView(JsonViews.UsersInfo.class)
	public Users findByIdWithInfo(@PathVariable Long id) {
		return usersService.getByIdWithInfo(id);
	}
	
	
}
