package net.voznjuk.dao;

import java.util.List;

public interface InvoiceLineDao {
	
	public List<InvoiceLineDao> getAll();
	
	public long add(InvoiceLineDao model);
	
	public void update(InvoiceLineDao model);
	
	public void delete(InvoiceLineDao model);
}
