package projetx.entities.avatar;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import projetx.entities.items.Item;
import projetx.entities.personne.Users;

@Entity
@Table(name="avatar")
@SequenceGenerator(name = "seqAvatar", sequenceName = "seq_avatar", allocationSize = 1, initialValue = 20000 )
public class Avatar {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAvatar" )
	private Long Id;
	@Column(name="name")
	private String nom;
	@Column(name="price")
	private Double price;
	
	@OneToMany(mappedBy = "avatar")
	private Set<Item> compose;
	
	@ManyToOne
	@JoinColumn(name="avatar_id_user", foreignKey = @ForeignKey(name="avatar_avatar_id_user_fk"))
	private Users owner;
	
	public Avatar() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Item> getCompose() {
		return compose;
	}

	public void setCompose(Set<Item> compose) {
		this.compose = compose;
	}

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avatar other = (Avatar) obj;
		return Objects.equals(Id, other.Id);
	}
	
	
	
}
