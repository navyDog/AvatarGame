package projetx.entities.personne;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersonne")
	private Long id;
	@Column(name="password")
	private String mdp;
	@Column(name="statue")
	private String loginStatue;
	@Column(name="register_date")
	private LocalDate registerDate;
	@Column(name="email")
	private String email;
	@Column(name="pseudo")
	private String pseudo;
	
	public Personne() {
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getLoginStatue() {
		return loginStatue;
	}

	public void setLoginStatue(String loginStatue) {
		this.loginStatue = loginStatue;
	}

	public LocalDate getLocalDate() {
		return registerDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.registerDate = localDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
		Personne other = (Personne) obj;
		return Objects.equals(id, other.id);
	}
	
}
