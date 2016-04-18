package es.uniovi.asw.model;

import java.io.Serializable;

public class UserLogin implements Serializable {

	static final long serialVersionUID = 1L;

	private String login;
	private String name;
	private Long id;

	public UserLogin(String login, String name, Long id) {
		super();
		this.login = login;
		this.name = name;
		this.setId(id);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}