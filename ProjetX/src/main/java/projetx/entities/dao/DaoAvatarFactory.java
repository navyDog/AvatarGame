package projetx.entities.dao;

public class DaoAvatarFactory {
	private static DaoAvatar daoAvatar = null;

	public static DaoAvatar getInstance() {
		if (daoAvatar == null) {
			daoAvatar = new DaoAvatarJpaImpl();
		}
		return daoAvatar;
	}

	private DaoAvatarFactory() {

	}
}
