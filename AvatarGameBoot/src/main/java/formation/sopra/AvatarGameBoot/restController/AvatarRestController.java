package formation.sopra.AvatarGameBoot.restController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;
import formation.sopra.AvatarGameBoot.restController.Param.Param;
import formation.sopra.AvatarGameBoot.service.AvatarService;
import formation.sopra.AvatarGameBoot.service.ItemService;


@RestController
@RequestMapping("/api/avatar")
@CrossOrigin(origins = "*")
public class AvatarRestController {

	@Autowired
	private AvatarService avatarService;


	
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Avatar.class)
	public Avatar getById(@PathVariable Long id) {
		return avatarService.getById(id);
	}
	
	@GetMapping("/{id}/items")
	@JsonView(JsonViews.AvatarWithItem.class)
	public Avatar getByIdWithItems(@PathVariable Long id) {
		return avatarService.getByIdWithItems(id);
	}
	
	@GetMapping("")
	@JsonView(JsonViews.Avatar.class)
	public List<Avatar> getAll() {
		return avatarService.getAll();
	}
	
	@PostMapping("/{id}/{id1}/{id2}/{id3}/{id4}/{id5}/{id6}")
	@JsonView(JsonViews.Avatar.class)
	public Avatar create(@Valid @RequestBody Param param,@PathVariable Long id,			
			@PathVariable Long id1,@PathVariable Long id2,@PathVariable Long id3,
			@PathVariable Long id4,@PathVariable Long id5,@PathVariable Long id6,
			BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	param.getUser().setId(id);
	param.getAvatar().setOwner(param.getUser());
	
	
	Set<Item> items = new HashSet<>();
	param.getH().setId(id1);items.add(param.getH());
	param.getB().setId(id2);items.add(param.getB());
	param.getLh().setId(id3);items.add(param.getLh());
	param.getRh().setId(id4);items.add(param.getRh());
	param.getLl().setId(id5);items.add(param.getLl());
	param.getRl().setId(id6);items.add(param.getRl());
	

	//return avatarService.setItems(avatarService.create(param.getAvatar()),items);
	return avatarService.setItems(avatarService.create(param.getAvatar()),items);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.Avatar.class)
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
