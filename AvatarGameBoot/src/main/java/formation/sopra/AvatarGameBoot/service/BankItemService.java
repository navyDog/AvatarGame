package formation.sopra.AvatarGameBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public BankItem getBankItemRandomByMembre(int xmembre) {
		//récupère la liste d'ID correspondant à cette rarity random
		List<BankItem> listBankItem = new ArrayList<>(bankItemRepo.findByRarityAndMembre(interval(random()), xmembre));
		//défini un nombre random à partir de la taille de la list
		int random = randomDef(listBankItem.size());
		BankItem bankItem = new BankItem();
		bankItem = listBankItem.get(random);
		return bankItem;
	}
	
	public BankItem getBankItemRandom() {
		//récupère la liste d'ID correspondant à cette rarity random
		List<BankItem> listBankItem = new ArrayList<>(bankItemRepo.findByRarity(interval(random())));
		//défini un nombre random à partir de la taille de la list
		int random = randomDef(listBankItem.size());
		BankItem bankItem = new BankItem();
		bankItem = listBankItem.get(random);
		return bankItem;
	}
	
	public int random() {
		int random = (int)(Math.random()*100);
		return random;
	}
	
	public int randomDef(int def) {
		Random randomDef = new Random();
		int random = randomDef.nextInt(def);
		return random;
	}
	
	public int interval(int random) {
		int xrarity;
		if (random<=72) {
			xrarity = 72;
		} else if (random<=94) {
			xrarity = 22;
		} else if (random<=99) {
			xrarity = 5;
		} else {
			xrarity = 1;
		}
		System.out.println(xrarity);
		return xrarity;
	}

}