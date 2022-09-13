package formation.sopra.AvatarGameBoot.entities.item;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "bank_item")
@NamedQueries({
	@NamedQuery(name="BankItem.findByRarity", 
		query = "SELECT id FROM BankItem WHERE rarity=:rarity"),
	@NamedQuery(name="BankItem.findByRarityAndMember", 
		query = "SELECT id FROM BankItem WHERE rarity=:rarity AND membre=:membre")
})
public class BankItem {
	@Id
	@Column(name = "bank_item_id")
	private Long id;
	@Column(name = "bank_item_membre")
	@Enumerated(EnumType.ORDINAL)
	private Membres membre;
	@Column(name = "bank_item_name")
	private String name;
	@Column(name = "bank_item_picture")
	private String picture;
	@Column(name = "bank_item_rarity")
	@Enumerated(EnumType.ORDINAL)
	private Rarity rarity;
	
	public BankItem() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Membres getMembre() {
		return membre;
	}

	public void setMembre(Membres membre) {
		this.membre = membre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankItem other = (BankItem) obj;
		return Objects.equals(id, other.id);
	}


}
