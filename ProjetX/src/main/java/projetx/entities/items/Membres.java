package projetx.entities.items;

public enum Membres {
	
	H("head"), B("body"), LH("left_hand"), RH("right_hand"), LL("left_leg"), RL("right_leg");
	
	private String membre;

	private Membres(String membre) {
		this.membre = membre;
	}

	public String getMembre() {
		return membre;
	}

	public void setMembre(String membre) {
		this.membre = membre;
	}
}
