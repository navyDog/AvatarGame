package entities.avatar.limbs;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//@MappedSuperclass
//public abstract class Item {
//
@Entity
@javax.persistence.Table(name="item")
@SequenceGenerator(sequenceName = "seqItem", name = "seq_item", initialValue = 1, allocationSize = 10000)
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqItem")
	@Column(name = "id")
	private Long Id;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="craft")
	private Boolean craft;
	
//	@ManyToOne
//	@JoinColumn(name="Item_id_user", foreignKey = @ForeignKey(name="item_item_id_user_fk"))
//	private User owner;
	
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
		Item other = (Item) obj;
		return Objects.equals(Id, other.Id);
	}

//
//	public User getOwner() {
//		return owner;
//	}
//
//
//	public void setOwner(User owner) {
//		this.owner = owner;
//	}

	
	
}
