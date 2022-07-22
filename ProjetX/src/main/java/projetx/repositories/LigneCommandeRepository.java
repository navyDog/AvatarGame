package projetx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eshop.entities.LigneCommande;
import eshop.entities.LigneCommandeKey;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandeKey> {

}
