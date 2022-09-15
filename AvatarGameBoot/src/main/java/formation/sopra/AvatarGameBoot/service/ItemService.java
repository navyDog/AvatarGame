package formation.sopra.AvatarGameBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.BankItem;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.item.Membres;
import formation.sopra.AvatarGameBoot.entities.item.Rarity;
import formation.sopra.AvatarGameBoot.entities.user.Users;
import formation.sopra.AvatarGameBoot.exceptions.ItemException;
import formation.sopra.AvatarGameBoot.exceptions.UsersException;
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
	
	public List<Item> getAllSaleable() {
		return itemRepo.findAllSaleable().orElseThrow(UsersException::new);
	}
	
	public Item update(Item item) {
		Item itemEnBase = getById(item.getId());
		itemEnBase.setNom(item.getNom());
		itemEnBase.setMembre(item.getMembre());
		itemEnBase.setRarity(item.getRarity());
		itemEnBase.setImage(item.getImage());
		itemEnBase.setPrix(item.getPrix()); 
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
		creationStart(users);
		for (int i = 0; i<10; i++) {
			creationRandom(users);
		}
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

	public void creationStart(Users users) {
		for (int i = 0; i<6 ; i++) {
			Item item = new Item();
			BankItem bankItem = new BankItem();
			bankItem = bankItemService.getBankItemRandomByMembre(i);
			item.setMembre(bankItem.getMembre());
			item.setRarity(bankItem.getRarity());
			item.setNom(bankItem.getName());
			item.setOwner(users);
			item.setImage(bankItem.getPicture());
			item.setPrix(null);
			create(item);
		}
	}
	
	public Item creationRandom(Users users) {
			Item item = new Item();
			BankItem bankItem = new BankItem();
			bankItem = bankItemService.getBankItemRandom();
			item.setMembre(bankItem.getMembre());
			item.setRarity(bankItem.getRarity());
			item.setNom(bankItem.getName());
			item.setOwner(users);
			item.setImage(bankItem.getPicture());
			item.setPrix(null);
			create(item);
			return item;
	}
	
	public void creationLegendary(Users users) {
		Item item = new Item();
		BankItem bankItem = new BankItem();
		bankItem = bankItemService.getBankItemLegendaryRandom();
		item.setMembre(bankItem.getMembre());
		item.setRarity(bankItem.getRarity());
		item.setNom(bankItem.getName());
		item.setOwner(users);
		item.setImage(bankItem.getPicture());
		item.setPrix(null);
		create(item);
	}
	
}
