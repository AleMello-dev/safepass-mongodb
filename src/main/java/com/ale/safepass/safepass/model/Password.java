package com.ale.safepass.safepass.model;

public class Password {
	
	private String id;
	private String service;
	private String login;
	private String hashPassword;
	
	public Password() {
	}

	public Password(String service, String login, String hashPassword) {
		this.service = service;
		this.login = login;
		this.hashPassword = hashPassword;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	
}
