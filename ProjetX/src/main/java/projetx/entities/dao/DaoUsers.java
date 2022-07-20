package projetx.entities.dao;

import projetx.entities.personne.Users;

public interface DaoUsers extends DaoGeneric<Users, Long> {

	public Users findByKeyWithItems(Long key);
}

