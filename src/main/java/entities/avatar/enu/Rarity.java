package entities.avatar.enu;

//Enumeration to define the different types of rarity 

public enum Rarity {
	
	C("Common",72), R("Rare",22), E("Epic",5), L("Legendary",1);
	
	private String titre;
	private Integer stat; //statistic to pocket the item in a random draw
	
	//Constructor
	private Rarity(String titre, Integer stat) { 
		this.titre = titre;
		this.stat = stat;
	}
	 
	public String getTitre() {
		return titre;
	}

	public Integer getStat() {
		return stat;
	}
		
}
