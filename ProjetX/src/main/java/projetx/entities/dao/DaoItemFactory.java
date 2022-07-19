package projetx.entities.dao;

public class DaoItemFactory {
	private static DaoItem daoItem = null;

	public static DaoItem getInstance() {
		if (daoItem == null) {
			daoItem = new DaoItemJpaImpl();
		}
		return daoItem;
	}

	private DaoItemFactory() {

	}
}
