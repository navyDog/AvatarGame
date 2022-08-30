package siteAvatar.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Avatar> getAll() {
		return avatarService.getAll();
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Avatar create(@Valid @RequestBody Avatar avatar, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	return avatarService.create(avatar);
	}
	
	
}
