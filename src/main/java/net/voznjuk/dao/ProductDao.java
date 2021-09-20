package net.voznjuk.dao;

import java.util.List;

import net.voznjuk.models.Product;

public interface ProductDao extends UnifiedDao<Product> {
	
	public Product getByName(String login);
	
	public int delById(Long id);
	
	public List<Product> searchListByKey(String key);

}
