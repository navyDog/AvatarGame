package entities.avatar.limbs;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@AttributeOverrides({ @AttributeOverride(name = "price", column = @Column(name = "body_price")),
					@AttributeOverride(name = "craft", column = @Column(name = "body_craft")), 
					@AttributeOverride(name = "owner", column = @Column(name = "body_owner", length = 255)) })
public class Body extends Item{

	public Body() {
		super();
		// TODO Auto-generated constructor stub
	}

}
