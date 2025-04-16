package com.login.model;

public class User {
	 private int Id;
	    private String username;
	    private String password;
	    private String email;
	    private String phoneNumber;

	    // Default constructor
	    public User() {}

	    // Parameterized constructor

	 // Getter and Setter methods for all fields
	    public int getUserId() {
	        return Id;
	    }

	    public User(int Id, String username, String password, String email, String phoneNumber) {
			super();
			this.Id = Id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.phoneNumber = phoneNumber;
		}

		public void setUserId(int userId) {
	        this.Id = userId;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

}
