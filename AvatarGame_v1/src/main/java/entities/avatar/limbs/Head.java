package entities.avatar.limbs;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("H")
@AttributeOverrides({ @AttributeOverride(name = "price", column = @Column(name = "head_price")),
					@AttributeOverride(name = "craft", column = @Column(name = "head_craft")),
					@AttributeOverride(name = "owner", column = @Column(name = "head_owner", length = 255)) })
public class Head extends Item {

	public Head() {
		super();

	}
}
