package AvatarGame.entities.items;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@DiscriminatorValue("B")
@SequenceGenerator(sequenceName = "seqItem", name = "seq_body", allocationSize = 3, initialValue = 3)
public class Corps extends Item {

	public Corps() {
		super();
		// TODO Auto-generated constructor stub
	}

}
