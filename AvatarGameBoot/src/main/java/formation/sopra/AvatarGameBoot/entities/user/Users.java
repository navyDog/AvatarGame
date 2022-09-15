package formation.sopra.AvatarGameBoot.entities.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.view.JsonViews;

@Entity
@Table(name="users")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_users", allocationSize = 1, initialValue = 88810000)
@NamedQueries({
				@NamedQuery(name="Users.findByKeyWithItems", 
						query = "select u from Users u left join fetch u.items where u.id=:id"),
				@NamedQuery(name="Users.findByKeyWithAvatars", 
						query = "select u from Users u left join fetch u.avatar where u.id=:id"),
				@NamedQuery(name="Users.findByKeyWithSItems", 
				query = "select u from Users u left join fetch u.items i where u.id=:id and i.prix<>0"),
				@NamedQuery(name="Users.findInfo",
						query = "select u from Users u left join fetch u.utilisateur where u.id=:id"),
				
				@NamedQuery(name="Users.findByKeyWithNoCraftItems",
						query = "select u from Users u left join fetch u.items i where u.id=:id and i.crafted=false"),
				//
				@NamedQuery(name="Users.findNoCraftItems",
						query = "select distinct u from Users u right join fetch u.items i where i.crafted=false"),
				
				@NamedQuery(name="Users.findAvatar",
					query = "select distinct u from Users u right join fetch u.avatar"),
				//
				
				
				@NamedQuery(name="Users.findByKeyWithHeadItems", 
				query = "select u from Users u left join fetch u.items i where u.id=:id and i.membre=0"),
				@NamedQuery(name="Users.findByKeyWithBodyItems", 
				query = "select u from Users u left join fetch u.items i where u.id=:id and i.membre=1"),
				@NamedQuery(name="Users.findByKeyWithLeftHandItems", 
				query = "select u from Users u left join fetch u.items i where u.id=:id and i.membre=2"),
				@NamedQuery(name="Users.findByKeyWithRightHandItems", 
				query = "select u from Users u left join fetch u.items i where u.id=:id and i.membre=3"),
				@NamedQuery(name="Users.findByKeyWithLeftLegItems", 
				query = "select u from Users u left join fetch u.items i where u.id=:id and i.membre=4"),
				@NamedQuery(name="Users.findByKeyWithRightLegItems", 
				query = "select u from Users u left join fetch u.items i where u.id=:id and i.membre=5"),
				
})
public class Users extends Personne {

	@JsonView(JsonViews.Base.class)
	@Column(name="balance")
	private double solde;
	@OneToMany (mappedBy = "owner")
	@JsonView(JsonViews.UsersWithItems.class)
	private Set<Item> items;
	@OneToOne (mappedBy = "users")
	@JsonView(JsonViews.UsersInfo.class)
	private Utilisateur utilisateur;
	@OneToMany (mappedBy = "owner")
	@JsonView(JsonViews.UsersWithAvatars.class)
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
}
