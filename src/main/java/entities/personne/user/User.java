package entities.personne.user;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import entities.avatar.Avatar;
import entities.avatar.limbs.Item;
import entities.personne.Personne;


@Entity
@Table(name="Person")
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
	@OneToMany(mappedBy = "owner")
	private Set<Item> listiIems;
	
	@OneToMany(mappedBy = "owner")
	private Set<Avatar> listAvatare;
	
	@OneToOne
	@JoinColumn(name="avatar_id")
	private Avatar avatar;
	
	

	
	public User() {
		super();
	}

}