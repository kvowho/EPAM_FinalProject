package net.voznjuk.models;

public class InvoiceLine {
	
	InvoiceLineKey id;
	Invoice invoice;
	Product product;
	float price;
	Long quantity;
	
	public InvoiceLineKey getId() {
		return id;
	}
	public void setId(InvoiceLineKey id) {
		this.id = id;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public InvoiceLine(InvoiceLineKey id, Invoice invoice, Product product, float price, Long quantity) {
		super();
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
}
