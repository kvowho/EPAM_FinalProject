package net.voznjuk.dao;

import net.voznjuk.models.Product;

public interface ProductDao extends UnifiedDao<Product> {
	
	public Product getByName(String login);
	
	public boolean delById(Long id);

}
