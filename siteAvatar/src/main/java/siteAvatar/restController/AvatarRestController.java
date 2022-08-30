package siteAvatar.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import AvatarGame.entities.avatar.Avatar;
import AvatarGame.services.AvatarService;
import AvatarGame.view.JsonViews;

@RestController
@RequestMapping("/api/avatar")
public class AvatarRestController {

	@Autowired
	private AvatarService avatarService;
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Avatar getById(@PathVariable Long id) {
		return avatarService.getById(id);
	}
	
}
