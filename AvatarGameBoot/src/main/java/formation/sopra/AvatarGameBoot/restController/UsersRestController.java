package formation.sopra.AvatarGameBoot.restController;

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
	
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Users getById(@PathVariable Long id) {
		return usersService.getById(id);
	}
	
}
