package entities.avatar.limbs;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="body")
@SequenceGenerator(sequenceName = "seqItem", name = "seq_body", initialValue = 1, allocationSize = 10000)
@AttributeOverrides({ @AttributeOverride(name = "price", column = @Column(name = "body_price")),
					@AttributeOverride(name = "craft", column = @Column(name = "body_craft")), 
					@AttributeOverride(name = "owner", column = @Column(name = "body_owner", length = 255)) })
public class Body extends Item{

	public Body() {
		super();
		// TODO Auto-generated constructor stub
	}

}
