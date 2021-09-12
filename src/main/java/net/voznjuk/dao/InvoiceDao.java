package net.voznjuk.dao;

import net.voznjuk.models.Invoice;

public interface InvoiceDao extends UnifiedDao<Invoice> {
	
	public int delById(Long id);

}
