package formation.sopra.AvatarGameBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.item.Membres;
import formation.sopra.AvatarGameBoot.entities.item.Rarity;
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
	@Autowired
	private BankItemService bankItemService;
	
	public Item create(Item item) {
		item.setAvatar(null);
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
		itemRepo.delete(item);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
	
	public void InscriptionCreation(Users users) {
			creationHead(users);
	}
	
	public void creationHead(Users users) {
		Item head = new Item();
		head.setMembre(Membres.H);
		head.setRarity(Rarity.C);
		head.setNom("Caskecool");
		head.setOwner(users);
		head.setImage("");
		head.setPrix(null);
		create(head);
	}
	//1/trouver un moyen de creer directement un item avec le BankItem
	//2/gérer compatibilité int et Long
	public void creationStart(Users users) {
		for (int i = 1; i<7 ; i++) {
			Item item = new Item();
			bankItemService.getBankItemRandomByMembre(i);
			item.setMembre(bankItemService.getMembre());
			item.setRarity(bankItemService.getById(i).getRarity());
			item.setNom(bankItemService.getById(i).getName());
			item.setOwner(users);
			item.setImage(bankItemService.getById(i).getPicture());
			item.setPrix(null);
			create(item);
		}
	}
	
}
