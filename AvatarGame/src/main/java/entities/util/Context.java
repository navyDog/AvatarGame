package entities.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {

	private static EntityManagerFactory emf = null;

	private Context() {

	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("AvatarGame");
		}
		return emf;
	}

	public static void destroy() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}
}