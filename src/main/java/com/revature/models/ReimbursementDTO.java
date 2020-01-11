package com.revature.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

public class ReimbursementDTO implements Serializable {

	private static final long serialVersionUID = -2599858684487092879L;
	
	private int id;
	private double amount;
	private int resolver;
	private String description;
	private byte[] receipt;
	private int author;
	private Timestamp resolved;
	private int status_id;
	private int type_id;
	
	
	public ReimbursementDTO() {
		super();
		
	}


	public ReimbursementDTO(int id, double amount, int resolver, String description, byte[] receipt, int author,
			Timestamp resolved, int status_id, int type_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.resolver = resolver;
		this.description = description;
		this.receipt = receipt;
		this.author = author;
		this.resolved = resolved;
		this.status_id = status_id;
		this.type_id = type_id;
	}


	public final int getId() {
		return id;
	}


	public final void setId(int id) {
		this.id = id;
	}


	public final double getAmount() {
		return amount;
	}


	public final void setAmount(double amount) {
		this.amount = amount;
	}


	public final int getResolver() {
		return resolver;
	}


	public final void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public final String getDescription() {
		return description;
	}


	public final void setDescription(String description) {
		this.description = description;
	}


	public final byte[] getReceipt() {
		return receipt;
	}


	public final void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}


	public final int getAuthor() {
		return author;
	}


	public final void setAuthor(int author) {
		this.author = author;
	}


	public final Timestamp getResolved() {
		return resolved;
	}


	public final void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}


	public final int getStatus_id() {
		return status_id;
	}


	public final void setStatus_id(int status_id) {
		this.status_id = status_id;
	}


	public final int getType_id() {
		return type_id;
	}


	public final void setType_id(int type_id) {
		this.type_id = type_id;
	}


	public static final long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + author;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(receipt);
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + resolver;
		result = prime * result + status_id;
		result = prime * result + type_id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementDTO other = (ReimbursementDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author != other.author)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(receipt, other.receipt))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver != other.resolver)
			return false;
		if (status_id != other.status_id)
			return false;
		if (type_id != other.type_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ReimbursementDTO [id=" + id + ", amount=" + amount + ", resolver=" + resolver + ", description="
				+ description + ", receipt=" + Arrays.toString(receipt) + ", author=" + author + ", resolved="
				+ resolved + ", status_id=" + status_id + ", type_id=" + type_id + "]";
	}
	
	
	

}
