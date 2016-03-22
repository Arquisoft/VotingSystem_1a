package es.uniovi.asw.model;

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
	private String name;
	private String NIF;
	private String email;
	private int codigoMesa;
	private String contraseña;

	User() {

	}

	public User(String name, String NIF, String email, int codigoMesa,String contraseña) {
		this.setName(name);
		this.setNIF(NIF);
		this.setEmail(email);
		this.setCodigoMesa(codigoMesa);
		this.setContraseña(contraseña);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
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
		result = prime * result + ((NIF == null) ? 0 : NIF.hashCode());
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
		if (NIF == null) {
			if (other.NIF != null)
				return false;
		} else if (!NIF.equals(other.NIF))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", NIF=" + NIF + ", email=" + email + ", codigoMesa=" + codigoMesa
				+ ", contraseña=" + contraseña + "]";
	}

	public Long getId(){
		return id;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
