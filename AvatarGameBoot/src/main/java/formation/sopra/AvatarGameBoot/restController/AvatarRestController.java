package formation.sopra.AvatarGameBoot.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;
import formation.sopra.AvatarGameBoot.service.AvatarService;


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
	
	@GetMapping("/{id}/items")
	@JsonView(JsonViews.AvatarWithItem.class)
	public Avatar getByIdWithItems(@PathVariable Long id) {
		return avatarService.getByIdWithItems(id);
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
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Avatar update(@Valid @RequestBody Avatar avatar, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		avatar.setId(id);
		return avatarService.update(avatar);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		avatarService.deleteById(id);
	}
	
}
