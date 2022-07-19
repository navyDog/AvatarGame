package entities.root;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Root {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqId")
	@Column(name = "id")
	private Long Id;

	public Root(Long id) {
		super();
		Id = id;
	}
	
	

}
