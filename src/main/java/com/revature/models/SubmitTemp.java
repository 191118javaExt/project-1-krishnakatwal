package com.revature.models;

import java.io.Serializable;

public class SubmitTemp implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int author_id;
	private double amount;
	private String description;
	private String type_id;
	private int resolver;
	private int status_id;
	public SubmitTemp(int author_id, double amount, String description, String type_id, int resolver,int status_id ) {
		super();
		this.author_id = author_id;
		this.amount = amount;
		this.description = description;
		this.type_id = type_id;
		this.resolver = resolver;
		this.status_id = status_id;
	}
	public SubmitTemp() {
		super();
	}
	public final int getAuthor_id() {
		return author_id;
	}
	public final void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public final double getAmount() {
		return amount;
	}
	public final void setAmount(double amount) {
		this.amount = amount;
	}
	public final String getDescription() {
		return description;
	}
	public final void setDescription(String description) {
		this.description = description;
	}
	public final String getType_id() {
		return type_id;
	}
	public final void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public final int getResolver() {
		return resolver;
	}
	public final void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public final int getStatus_id() {
		return status_id;
	}
	public final void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	
	
	
}
