package AvatarGame.entities.items;

public enum Rarity {

	C("common", 72), R("rare", 22), E("epic", 5), L("legendary", 1);
	
	private String titre;
	private Integer stat;
	
	private Rarity(String titre, Integer stat) {
		this.titre = titre;
		this.stat = stat;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

}
