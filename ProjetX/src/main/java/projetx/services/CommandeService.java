package projetx.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.entities.Client;
import eshop.entities.Commande;
import eshop.entities.LigneCommande;
import eshop.entities.LigneCommandeKey;
import eshop.entities.Produit;
import eshop.repositories.CommandeRepository;
import eshop.repositories.LigneCommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepo;
	@Autowired
	private LigneCommandeRepository lCRepo;
	@Autowired
	private ClientService clientService;

	public Commande create(Commande commande) {
		commandeRepo.save(commande);
		lCRepo.saveAll(commande.getLignes());
		return commande;
	}

	public Commande create(Map<Produit, Integer> panier, Client client) {
		Client clientBase = clientService.getById(client.getId());
		Commande commande = new Commande(clientBase);
		commandeRepo.save(commande);
		panier.forEach((k, v) -> {
			lCRepo.save(new LigneCommande(new LigneCommandeKey(commande, k), v));
		});
		return commande;
	}
}
