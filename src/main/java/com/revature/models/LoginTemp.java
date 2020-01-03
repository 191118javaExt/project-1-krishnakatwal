package com.revature.models;

import java.io.Serializable;

public class LoginTemp implements Serializable {

	private static final long serialVersionUID = -5974323924391012722L;

	 private String email;
	 private String Password;
	 
	public LoginTemp() {
		super();

	}

	public LoginTemp(String email, String password) {
		super();
		this.email = email;
		Password = password;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getPassword() {
		return Password;
	}

	public final void setPassword(String password) {
		Password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		LoginTemp other = (LoginTemp) obj;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginTemp [email=" + email + ", Password=" + Password + "]";
	}
	
	
	 
}
