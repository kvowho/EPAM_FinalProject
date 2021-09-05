package net.voznjuk.models;

public class User extends UnifiedModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 923001460744692971L;
	
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String role;
	
	public User() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public User(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public User(Long id, String firstname, String lastname, String login, String password, String role) {
		super(id);
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
