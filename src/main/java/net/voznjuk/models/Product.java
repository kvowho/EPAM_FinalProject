/**
 * 
 */
package net.voznjuk.models;

/**
 * @author master
 *
 */
public class Product extends UnifiedModel{

	private static final long serialVersionUID = 1049379795355925890L;
	
	private String name;
	private String description;
	private long stockQuantity;
	private float price;
	private int availabilityStatus;

	/**
	 * 
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, String description, long stockQuantity, float price, int availabilityStatus) {
		super(id);
		this.name = name;
		this.description = description;
		this.stockQuantity = stockQuantity;
		this.price = price;
		this.availabilityStatus = availabilityStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(int availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	

}
