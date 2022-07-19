package Test;

import entities.dao.DaoUser;
import entities.dao.DaoUserFactory;
import entities.personne.user.User;
import entities.util.Context;

public class TestApp {
	public static void main(String[] args) {
		
		Context.getEntityManagerFactory();
		
		User user1 = new User();
//		Avatar avatar = new Avatar();
//		Body body1 = new Body();
		
		DaoUser daoUser = DaoUserFactory.getInstance();
		daoUser.insert(user1);
		
		Context.destroy();
	}
}
