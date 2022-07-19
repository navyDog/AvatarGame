package entities.avatar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import entities.avatar.limbs.Body;
import entities.avatar.limbs.Head;
import entities.avatar.limbs.LeftFoot;
import entities.avatar.limbs.LeftHand;
import entities.avatar.limbs.RightFoot;
import entities.avatar.limbs.RightHand;
import entities.personne.user.User;

@Entity
@Table(name = "avatar")
@SequenceGenerator(sequenceName = "seqAvatar", name = "seq_avatar", initialValue = 1, allocationSize = 10000)
public class Avatar{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAvatar")
	@Column(name = "id")
	private Long Id;
	
	@OneToOne
	@JoinColumn(name="head_id")
	private Head head;
	@OneToOne
	@JoinColumn(name="body_id")
	private Body body;
	@OneToOne
	@JoinColumn(name="leftHand_id")
	private LeftHand leftHand;
	@OneToOne
	@JoinColumn(name="rightHand_id")
	private RightHand rightHand;
	@OneToOne
	@JoinColumn(name="leftFoot_id")
	private LeftFoot leftFoot;
	@OneToOne
	@JoinColumn(name="rightFoot_id")
	private RightFoot rightFoot;

	@Column(name="price")
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="avatar_id_user", foreignKey = @ForeignKey(name="avatar_avatar_id_user_fk"))
	private User owner;
	
	public Avatar(Long id) {

	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public LeftHand getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(LeftHand leftHand) {
		this.leftHand = leftHand;
	}

	public RightHand getRightHand() {
		return rightHand;
	}

	public void setRightHand(RightHand rightHand) {
		this.rightHand = rightHand;
	}

	public LeftFoot getLeftFoot() {
		return leftFoot;
	}

	public void setLeftFoot(LeftFoot leftFoot) {
		this.leftFoot = leftFoot;
	}

	public RightFoot getRightFoot() {
		return rightFoot;
	}

	public void setRightFoot(RightFoot rightFoot) {
		this.rightFoot = rightFoot;
	}




	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
