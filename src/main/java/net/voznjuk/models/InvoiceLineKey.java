package net.voznjuk.models;

public class InvoiceLineKey {
	
	Long productId;
	Long invoiceId;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	public InvoiceLineKey(Long productId, Long invoiceId) {
		super();
		this.productId = productId;
		this.invoiceId = invoiceId;
	}
}
