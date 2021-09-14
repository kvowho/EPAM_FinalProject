package net.voznjuk.models;

import java.time.Instant;
import java.util.Date;

public class Invoice extends UnifiedModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8473072110203895212L;
	
	private String status;
	private Instant date;
	private String comments;

	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public Invoice(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(Long id, String status, Instant date, String comments) {
		super(id);
		this.status = status;
		this.date = date;
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant instant) {
		this.date = instant;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
