package entities.personne.user;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import entities.personne.Personne;


@Entity
@Table(name="user")
@SequenceGenerator(sequenceName = "seqPersonne", name = "seq_user", initialValue = 1, allocationSize = 67000)
@AttributeOverrides({ @AttributeOverride(name = "pseudo", column = @Column(name = "pseudo", length = 255)),
					@AttributeOverride(name = "mdp", column = @Column(name = "password", length = 255)),
					@AttributeOverride(name = "registerDate", column = @Column(name = "registerDate", length = 255)),
					@AttributeOverride(name = "loginStatus", column = @Column(name = "loginStatus", length = 255)),
					@AttributeOverride(name = "mail", column = @Column(name = "email", length = 255)) })
public class User extends Personne{
	
	@Column(name = "name")
	private String name;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "balance")
	private Long solde;
//	@OneToMany(mappedBy = "owner")
//	private Set<Item> listiIems;
	
//	@OneToMany(mappedBy = "owner")
//	private Set<Avatar> listAvatare;
//	
//	@OneToOne
//	@JoinColumn(name="avatar_id")
//	private Avatar avatar;

	
	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}
	
}