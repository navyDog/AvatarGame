package projetx.entities.items;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import projetx.entities.personne.Users;

@Entity
@Table(name="items")
@SequenceGenerator(sequenceName = "seqItem", name = "seq_item", allocationSize = 1, initialValue = 1)
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItem")
	private Long id;
	@Column(name="item_name")
	private String nom;
	@Column(name="item_limb")
	@Enumerated(EnumType.ORDINAL)
	private Membres membre;
	@Column(name="item_rarity")
	@Enumerated(EnumType.ORDINAL)
	private Rarity rarity;
	@Column(name="item_picture")
	private String image;
	@Column(name="item_price")
	private Double prix;
	@ManyToOne
	@JoinColumn(name="item_id_user", foreignKey = @ForeignKey(name="item_item_id_user_fk"))
	private Users owner;
//	private Avatar avatar;
	@Column(name="item_craft_stat")
	private Boolean crafted;	//crafting stat
	
	public Item() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Boolean getCrafted() {
		return crafted;
	}

	public void setCrafted(Boolean crafted) {
		this.crafted = crafted;
	}

	public Membres getMembre() {
		return membre;
	}

	public void setMembre(Membres membre) {
		this.membre = membre;
	}

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
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
		Item other = (Item) obj;
		return Objects.equals(id, other.id);
	}

}
