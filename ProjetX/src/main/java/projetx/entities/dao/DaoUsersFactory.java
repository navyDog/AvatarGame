package projetx.entities.dao;

public class DaoUsersFactory {
	private static DaoUsers daoUsers = null;

	public static DaoUsers getInstance() {
		if (daoUsers == null) {
			daoUsers = new DaoUsersJpaImpl();
		}
		return daoUsers;
	}

	private DaoUsersFactory() {

	}
}
