package formation.sopra.AvatarGameBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.sopra.AvatarGameBoot.entities.item.BankItem;

public interface BankItemRepository extends JpaRepository<BankItem, Long>{

	@Query("SELECT id FROM BankItem WHERE rarity=:rarity")
	List<Long> findByRarity(int rarity);
	
	@Query("SELECT id FROM BankItem WHERE rarity=:rarity AND membre=:membre")
	List<Long> findByRarityAndMembre(int rarity, int membre);
}
