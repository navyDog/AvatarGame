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

import AvatarGame.entities.items.Item;
import AvatarGame.services.ItemService;
import AvatarGame.view.JsonViews;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Base.class)
	public Item getById(@PathVariable Long id) {
		return itemService.getById(id);
	}
	
	@GetMapping("")
	@JsonView(JsonViews.Base.class)
	public List<Item> getAll() {
		return itemService.getAll();
	}
	
	@PostMapping("")
	@JsonView(JsonViews.Base.class)
	public Item create(@Valid @RequestBody Item item, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	return itemService.create(item);
	}
}
