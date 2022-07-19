package projetx.entities.items;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@DiscriminatorValue("H")
@SequenceGenerator(sequenceName = "seqItem", name = "seq_head", allocationSize = 2, initialValue = 2)
public class Tete extends Item {

	public Tete() {
		super();
		// TODO Auto-generated constructor stub
	}

}
