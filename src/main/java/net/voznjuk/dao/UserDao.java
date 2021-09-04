package net.voznjuk.dao;

import net.voznjuk.models.User;

public interface UserDao extends UnifiedDao<User>{
	
	public User getByLogin(String login);

}
