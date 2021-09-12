package net.voznjuk.models;

import java.util.Date;

public class Invoice extends UnifiedModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8473072110203895212L;
	
	private String status;
	private Date date;

	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public Invoice(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(Long id, String status, Date date) {
		super(id);
		this.status = status;
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
