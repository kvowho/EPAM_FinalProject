package net.voznjuk.dao;

import java.math.BigDecimal;

public interface ProductToInvoiceDao {
	
	public int getProductsByInvoiceId(Long id);
	
	public int addProductToInvoice(Long id);
	
	public int delProductFromInvoiceById(Long id);
	
	public int updProductInInvoiceById(Long id);
	
	public float getInvoiceSum(Long id);

}
