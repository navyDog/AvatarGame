package test;

import projetx.entities.dao.DaoItem;
import projetx.entities.dao.DaoItemFactory;
import projetx.entities.dao.DaoUsers;
import projetx.entities.dao.DaoUsersFactory;
import projetx.entities.items.Item;
import projetx.entities.items.Membres;
import projetx.entities.personne.Users;

public class AppTest {
	public static void main(String[] args) {
	
		projetx.util.Context.getEntityManagerFactory();
		DaoUsers daoUser = DaoUsersFactory.getInstance();
		DaoItem daoItem = DaoItemFactory.getInstance();
		Users golem = new Users();
		Item casque = new Item();
		Item corps = new Item();
		
		daoUser.insert(golem);
		golem.setEmail("titi@kikou.ru");
		daoUser.update(golem);
		daoItem.insert(casque);
		casque.setMembre(Membres.H);
		daoItem.update(casque);
		corps.setMembre(Membres.B);
		daoItem.insert(corps);
		
//		Set<Item> stuff = new HashSet<Item>();
//		stuff.add(casque);
//		stuff.add(corps);
//		golem.setItems(stuff);
		
		daoUser.update(golem);
		corps.setOwner(golem);
		daoItem.update(corps);
		
		
		projetx.util.Context.destroy();
	}
}
