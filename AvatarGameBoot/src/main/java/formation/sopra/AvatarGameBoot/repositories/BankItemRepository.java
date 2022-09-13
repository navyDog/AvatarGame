package formation.sopra.AvatarGameBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import formation.sopra.AvatarGameBoot.entities.item.BankItem;

public interface BankItemRepository extends JpaRepository<BankItem, Long>{

	@Query("SELECT b FROM BankItem b WHERE b.xrarity=:xrarity")
	List<BankItem> findByRarity(int xrarity);
	
	@Query("SELECT b FROM BankItem b WHERE b.xrarity=:xrarity AND b.xmembre=:xmembre")
	List<BankItem> findByRarityAndMembre(int xrarity, int xmembre);

}
