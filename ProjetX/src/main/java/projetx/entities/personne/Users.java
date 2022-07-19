package projetx.entities.personne;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import projetx.entities.items.Item;

@Entity
@Table(name="users")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_users", allocationSize = 1, initialValue = 10000)
@AttributeOverrides({
	@AttributeOverride(name = "password", column = @Column(name="users_password")),
	@AttributeOverride(name = "statue", column = @Column(name="users_statue")),
	@AttributeOverride(name = "register_date", column = @Column(name="users_register_date")),
	@AttributeOverride(name = "email", column = @Column(name="users_email")),
	@AttributeOverride(name = "pseudo", column = @Column(name="users_pseudo"))
})
public class Users extends Personne {

	@Column(name="users_name")
	private String nom;
	@Column(name="users_firstname")
	private String prenom;
	@Column(name="balance")
	private double solde;
	@OneToMany (mappedBy = "owner")
	private Set<Item> items;
	
	public Users () {	
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	
	
}
