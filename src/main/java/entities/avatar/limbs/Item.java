package entities.avatar.limbs;


import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


import entities.personne.user.User;

@MappedSuperclass
public abstract class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItem")
	@Column(name = "id")
	private Long Id;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="craft")
	private Boolean craft;
	
	@ManyToOne
	@JoinColumn(name="Item_id_user", foreignKey = @ForeignKey(name="item_item_id_user_fk"))
	private User owner;
	
	public Item() {

	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Boolean getCraft() {
		return craft;
	}


	public void setCraft(Boolean craft) {
		this.craft = craft;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}

}
