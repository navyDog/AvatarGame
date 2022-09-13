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
		query = "SELECT b FROM BankItem b WHERE b.xrarity=:xrarity"),
	@NamedQuery(name="BankItem.findByRarityAndMember", 
		query = "SELECT b FROM BankItem b WHERE b.xrarity=:xrarity AND b.xmembre=:xmembre")
})
public class BankItem {
	@Id
	@Column(name = "bank_item_id")
	private Long id;
	@Column(name = "bank_item_membre")
	@Enumerated(EnumType.STRING)
	private Membres membre;
	@Column(name = "bank_item_name")
	private String name;
	@Column(name = "bank_item_picture")
	private String picture;
	@Column(name = "bank_item_rarity")
	@Enumerated(EnumType.STRING)
	private Rarity rarity;
	@Column(name = "bank_item_xmembre")
	private int xmembre;
	@Column(name = "bank_item_xrarity")
	private int xrarity;
	
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

	public int getXmembre() {
		return xmembre;
	}

	public void setXmembre(int xmembre) {
		this.xmembre = xmembre;
	}

	public int getXrarity() {
		return xrarity;
	}

	public void setXrarity(int xrarity) {
		this.xrarity = xrarity;
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
