package formation.sopra.AvatarGameBoot.restController.Param;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.AvatarGameBoot.entities.view.JsonViews;

public class JeuUN {
	@JsonView(JsonViews.Base.class)
	private String  coin;
	
	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public JeuUN() {
		super();
	}
	
	
}
