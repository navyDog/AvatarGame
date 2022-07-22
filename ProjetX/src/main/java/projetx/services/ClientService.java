package projetx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.entities.Client;
import eshop.exceptions.ClientException;
import eshop.repositories.ClientRepository;
import eshop.repositories.CommandeRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepo;
	@Autowired
	private CommandeRepository commandeRepo;

	public Client create(Client client) {
		if (client.getPrenom() == null || client.getPrenom().isEmpty()) {
			throw new ClientException();
		}
		if (client.getNom() == null || client.getNom().isEmpty()) {
			throw new ClientException();
		}
		return clientRepo.save(client);
	}

	public Client create(String prenom, String nom) {
		Client client = new Client();
		client.setPrenom(prenom);
		client.setNom(nom);
		return create(client);
	}

	public List<Client> getByNom(String nom) {
		return null;
	}

	public Client getById(Long id) {
		// return clientRepo.findById(id).orElseThrow(ClientException::new);
		Optional<Client> opt = clientRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new ClientException();
	}

	public Client getByIdWithCommandes(Long id) {
		return clientRepo.findByKeyWithCommandes(id).orElseThrow(() -> {
			throw new ClientException();
		});
	}

	public Client update(Client client) {
		Client clientEnBase = getById(client.getId());
		clientEnBase.setPrenom(client.getPrenom());
		clientEnBase.setNom(client.getNom());
		clientEnBase.setAdresse(client.getAdresse());
		clientEnBase.setMail(client.getMail());
		return clientRepo.save(clientEnBase);
	}

	public List<Client> getAll() {
		return clientRepo.findAll();
	}

	public void delete(Client client) {
		commandeRepo.setClientToNullByClient(client);
		clientRepo.delete(client);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

}
