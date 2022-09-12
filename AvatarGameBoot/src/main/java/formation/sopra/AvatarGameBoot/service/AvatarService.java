package formation.sopra.AvatarGameBoot.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.exceptions.AvatarException;
import formation.sopra.AvatarGameBoot.repositories.AvatarRepository;
import formation.sopra.AvatarGameBoot.repositories.ItemRepository;



@Service
public class AvatarService {
	
	@Autowired
	private AvatarRepository avatarRepo;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemService itemService;
	
	public Avatar setItems(Avatar avatar, Set<Item> items) {
		
		items.forEach(t -> t.setAvatar(avatar));
		items.forEach(t -> t.setCrafted(true));
		items.forEach(t -> itemService.update(t));	
		return avatarRepo.save(avatar);
	}
	
	public Avatar create(Avatar avatar) {
		return avatarRepo.save(avatar);
	}
	
	public Avatar getById(Long id) {
		return avatarRepo.findById(id).orElseThrow(AvatarException::new);
	}
	
	public Avatar getByIdWithItems(Long id) {
		return avatarRepo.findByKeyWithItems(id).orElseThrow(AvatarException::new);
	}

	public Avatar update(Avatar avatar) {
		Avatar avatarEnBase = getById(avatar.getId());
		avatarEnBase.setNom(avatar.getNom());
		avatarEnBase.setPrice(avatar.getPrice());
		avatarEnBase.setOwner(avatar.getOwner());
		return avatarRepo.save(avatarEnBase);
	}

	public List<Avatar> getAll() {
		return avatarRepo.findAll();
	}

	public void delete(Avatar avatar) {
		itemRepository.deleteItemByAvatar(avatar);
		avatarRepo.delete(avatar);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
}

