package info.polarissolutions.moneymanager.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -4722205176224145716L;
	private static int USER_ID_COUNTER = 0;
	private int id;
	private String name;
	private String password;
	
	public User(String name, String password) {
		super();
		this.id = USER_ID_COUNTER++;
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if(other.id != id) {
			return false;
		}
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	

	
}
