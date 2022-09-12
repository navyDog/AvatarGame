package formation.sopra.AvatarGameBoot.restController;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;
import formation.sopra.AvatarGameBoot.service.ItemService;

@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins = "*")
public class ItemRestController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.ItemUpdate.class)
	public Item getById(@PathVariable Long id) {
		return itemService.getById(id);
	}
	
	@GetMapping("")
	@JsonView(JsonViews.ItemUpdate.class)
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
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.ItemUpdate.class)
	public Item update(@PathVariable Long id, @Valid @RequestBody Item item, BindingResult br) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		item.setId(id);
		return itemService.update(item);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		itemService.deleteById(id);
	}
	
}
