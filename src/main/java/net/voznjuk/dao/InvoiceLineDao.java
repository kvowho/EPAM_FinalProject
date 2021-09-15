package net.voznjuk.dao;

import java.util.List;

import net.voznjuk.models.Invoice;
import net.voznjuk.models.InvoiceLine;

public interface InvoiceLineDao {
	
	public List<InvoiceLine> getAll();
	
	public List<InvoiceLine> getLinesByInvoice(Invoice model);
	
	public long add(InvoiceLine model);
	
	public void update(InvoiceLine model);
	
	public void delete(InvoiceLine model);

}
