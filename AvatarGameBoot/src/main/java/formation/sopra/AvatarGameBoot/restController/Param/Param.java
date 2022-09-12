package formation.sopra.AvatarGameBoot.restController.Param;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.user.Users;

public class Param {
	
	private Users user;
	private Avatar avatar;
	private Item H;
	private Item B;
	private Item LH;
	private Item RH;
	private Item LL;
	private Item RL;
	
	
	
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Param() {
		super();
	}
	public Avatar getAvatar() {
		return avatar;
	}
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	public Item getLL() {
		return LL;
	}
	public void setLL(Item lL) {
		LL = lL;
	}
	public Item getH() {
		return H;
	}
	public void setH(Item h) {
		H = h;
	}
	public Item getB() {
		return B;
	}
	public void setB(Item b) {
		B = b;
	}
	public Item getLH() {
		return LH;
	}
	public void setLH(Item lH) {
		LH = lH;
	}
	public Item getRH() {
		return RH;
	}
	public void setRH(Item rH) {
		RH = rH;
	}
	public Item getRL() {
		return RL;
	}
	public void setRL(Item rL) {
		RL = rL;
	}

	
}
