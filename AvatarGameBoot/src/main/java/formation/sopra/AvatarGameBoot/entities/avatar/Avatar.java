package formation.sopra.AvatarGameBoot.entities.avatar;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.user.Users;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;

@Entity
@Table(name="avatar")
@SequenceGenerator(name = "seqAvatar", sequenceName = "seq_avatar", allocationSize = 1, initialValue = 20000 )
@NamedQueries({
	@NamedQuery(name="Avatar.findByKeyWithItems", 
			query = "select a from Avatar a left join fetch a.compose c where a.id=:id order by c.membre"),
})
public class Avatar {
	@JsonView( {JsonViews.Base.class} )
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAvatar" )
	@Column(name="avatar_id")
	private Long id;
	@JsonView( {JsonViews.Base.class} )
	@Column(name="name", nullable = false)
	@NotEmpty(message = "nom obligatoire")
	private String nom;
	@Column(name="price")
	@JsonView( {JsonViews.Base.class} )
	private Double price;
	@JsonView( {JsonViews.AvatarWithItem.class} )
	@OneToMany(mappedBy = "avatar")
	private Set<Item> compose;
	@JsonView( {JsonViews.Avatar.class} )
	@ManyToOne
	@JoinColumn(name="avatar_id_user", foreignKey = @ForeignKey(name="avatar_avatar_id_user_fk"))
	//@NotEmpty(message ="owner obligatoire")
	private Users owner;
	@Version
	private int version;
	
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
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		Avatar other = (Avatar) obj;
		return Objects.equals(id, other.id);
	}
	
	


	
	
	
}
