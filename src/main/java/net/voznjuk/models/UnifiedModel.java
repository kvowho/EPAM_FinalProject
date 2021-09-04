/**
 * 
 */
package net.voznjuk.models;

import java.io.Serializable;

/**
 * @author Voznjuk K
 * 
 * This is synthetic model (higher level of abstraction) that unites the common 
 * features of all other models
 * 
 */
public class UnifiedModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2190965691750291276L;

	
	private Long id;
	
	public UnifiedModel() {
		
	}

	public UnifiedModel(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
