package net.voznjuk.dao;

import net.voznjuk.models.User;

public interface UserDao extends UnifiedDao<User>{
	
	public User getByLogin(String login);
	
	public boolean delById(Long id);
	
	public String getAuthByRole(Long id);
	
	public boolean checkLoginPassword(String login, String password);

}
