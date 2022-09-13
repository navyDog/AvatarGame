package formation.sopra.AvatarGameBoot.entities.item;

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
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.user.Users;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;

@Entity
@Table(name="items")
@SequenceGenerator(sequenceName = "seqItem", name = "seq_item", allocationSize = 1, initialValue = 1)
public class Item {
	@JsonView( {JsonViews.Item.class} )
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItem")
	@Column(name = "item_id")
	private Long id;
	@JsonView( {JsonViews.Base.class} )
	@NotEmpty()
	@Column(name="item_name", nullable = false)
	private String nom;
	@JsonView( {JsonViews.Base.class} )
	@Column(name="item_limb")
	@Enumerated(EnumType.ORDINAL)
	private Membres membre;
	@JsonView( {JsonViews.Base.class} )
	@Column(name="item_rarity")
	@Enumerated(EnumType.ORDINAL)
	private Rarity rarity;
	@Column(name="item_picture")
	@JsonView( {JsonViews.Base.class} )
	private String image;
	@Column(name="item_price")
	@JsonView( {JsonViews.Base.class} )
	private Double prix;
	@ManyToOne
	@JoinColumn(name="item_id_user", foreignKey = @ForeignKey(name="item_item_id_user_fk"))
	@JsonView( {JsonViews.Item.class} )
	private Users owner;
    
	@ManyToOne
	@JoinColumn(name="item_id_avatar", foreignKey = @ForeignKey(name="item_item_id_avatar_fk"))
	@JsonView( {JsonViews.Item.class} )
	private Avatar avatar;
	@Column(name="item_craft_stat")
	@JsonView( {JsonViews.Base.class} )
	private Boolean crafted;	//crafting stat
	@Version
	private int version;
	
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
	
	

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
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
