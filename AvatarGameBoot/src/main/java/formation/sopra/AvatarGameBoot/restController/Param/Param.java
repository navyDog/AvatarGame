package formation.sopra.AvatarGameBoot.restController.Param;

import formation.sopra.AvatarGameBoot.entities.avatar.Avatar;
import formation.sopra.AvatarGameBoot.entities.item.Item;
import formation.sopra.AvatarGameBoot.entities.user.Users;

public class Param {
	
	private Users user;
	private Avatar avatar;
	private Item h;
	private Item b;
	private Item lh;
	private Item rh;
	private Item ll;
	private Item rl;
	
	
	
	
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

	public Item getH() {
		return this.h;
	}
	public void setH(Item h) {
		this.h = h;
	}
	public Item getB() {
		return this.b;
	}
	public void setB(Item b) {
		this.b = b;
	}
	public Item getLh() {
		return lh;
	}
	public void setLh(Item lh) {
		this.lh = lh;
	}
	public Item getRh() {
		return rh;
	}
	public void setRh(Item rh) {
		this.rh = rh;
	}
	public Item getLl() {
		return ll;
	}
	public void setLl(Item ll) {
		this.ll = ll;
	}
	public Item getRl() {
		return rl;
	}
	public void setRl(Item rl) {
		this.rl = rl;
	}


	
}
