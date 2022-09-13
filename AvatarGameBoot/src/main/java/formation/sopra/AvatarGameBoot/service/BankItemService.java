package formation.sopra.AvatarGameBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.AvatarGameBoot.entities.item.BankItem;
import formation.sopra.AvatarGameBoot.exceptions.BankItemException;
import formation.sopra.AvatarGameBoot.repositories.BankItemRepository;

@Service
public class BankItemService {

	@Autowired
	private BankItemRepository bankItemRepo;
	
	public BankItem getById(Long id) {
		return bankItemRepo.findById(id).orElseThrow(BankItemException::new);
	}
	
	public BankItem getBankItemRandomByMembre(int membre) {
		//récupère la liste d'ID correspondant à cette rarity random
		List<Long> listId = new ArrayList<>(bankItemRepo.findByRarityAndMembre(random(), membre));
		//défini un nombre random à partir de la taille de la list
		int random = randomDef(listId.size());
		Long id = listId.get(random);
		return bankItemRepo.findById(id).orElseThrow(BankItemException::new);
	}
	
	public BankItem getBankItemRandom() {
		//récupère la liste d'ID correspondant à cette rarity random
		List<Long> listId = new ArrayList<>(bankItemRepo.findByRarity(random()));
		//défini un nombre random à partir de la taille de la list
		int random = randomDef(listId.size());
		Long id = listId.get(random);
		return bankItemRepo.findById(id).orElseThrow(BankItemException::new);
	}
	
	public int random() {
		int random = (int)Math.random()*100;
		return random;
	}
	
	public int randomDef(int def) {
		int random = (int)Math.random()*def;
		return random;
	}
}