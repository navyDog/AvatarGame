package formation.sopra.AvatarGameBoot.entities.user;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;

@Entity
@Table(name="users")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_users", allocationSize = 1, initialValue = 88810000)
@NamedQueries({
				@NamedQuery(name="Users.findByKeyWithItems", query = "select u from Users u left join fetch u.items where u.id=:id"),
				@NamedQuery(name="Users.findByKeyWithAvatars", query = "select u from Users u left join fetch u.avatar where u.id=:id") 
})
public class Users extends Personne {


	@Column(name="balance")
	private double solde;
	@OneToMany (mappedBy = "owner")
	private Set<Item> items;
	
	@OneToMany (mappedBy = "owner")
	private Set<Avatar> avatar;
	
	public Users () {	
		super();
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Avatar> getAvatar() {
		return avatar;
	}

	public void setAvatar(Set<Avatar> avatar) {
		this.avatar = avatar;
	}
	
	
	
	
}
