package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TUsers")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "NIF")
	private String nif;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CODIGOMESA")
	private int codigoMesa;

	@Column(name = "Password")
	private String password;

	public User() {

	}

	public User(String name, String NIF, String email, int codigoMesa, String password) {
		this.setName(name);
		this.setNIF(NIF);
		this.setEmail(email);
		this.setCodigoMesa(codigoMesa);
		this.setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNIF() {
		return nif;
	}

	public void setNIF(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(int codigoMesa) {
		this.codigoMesa = codigoMesa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
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
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", NIF=" + nif + ", email=" + email + ", codigoMesa=" + codigoMesa
				+ ", contraseña=" + password + "]";
	}

	public Long getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}