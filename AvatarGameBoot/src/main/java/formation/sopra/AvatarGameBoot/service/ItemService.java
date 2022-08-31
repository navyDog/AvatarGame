package formation.sopra.AvatarGameBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.user.Users;
import formation.sopra.AvatarGameBoot.exceptions.ItemException;
import formation.sopra.AvatarGameBoot.repositories.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepo;
	@Autowired
	private AvatarService avatarService;
	@Autowired
	private UsersService usersService;
	
	public Item create(Item item) {
		item.setCrafted(false);
		return itemRepo.save(item);
	}
	
	public Item getById(Long id) {
		return itemRepo.findById(id).orElseThrow(ItemException::new);
	}
	
	public Item update(Item item) {
		Item itemEnBase = getById(item.getId());
		itemEnBase.setNom(item.getNom());
		itemEnBase.setMembre(item.getMembre());
		itemEnBase.setRarity(item.getRarity());
		itemEnBase.setImage(item.getImage());
//		itemEnBase.setPrix(item.getPrix()); WIP
		Avatar avatar = item.getAvatar();
		if (avatar != null) {
			avatar = avatarService.getById(avatar.getId());
			itemEnBase.setAvatar(avatar);
		}
		itemEnBase.setAvatar(item.getAvatar());
		Users user = item.getOwner();
		if (user != null) {
			user = usersService.getById(user.getId());
			itemEnBase.setOwner(user);
		}
		itemEnBase.setOwner(item.getOwner());
		itemEnBase.setCrafted(item.getCrafted());
		//to DO
		return itemRepo.save(itemEnBase);
	}
	
	public List<Item> getAll() {
		return itemRepo.findAll();
	}
	
	public void delete(Item item) {
		//to DO
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
}
