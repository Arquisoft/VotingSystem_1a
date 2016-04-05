package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TPlace")
public class LugarVoto {
	
	@Id
	private long identificador;
	private String nombre;
	private String password;
	private String ciudad;
	private String pais;
	
	public LugarVoto(){
		
	}

	public LugarVoto(long identificador, String nombre, String password, String ciudad, String pais) {
		this.identificador = identificador;
		this.nombre = nombre;
		this.password = password;
		this.ciudad = ciudad;
		this.pais = pais;
	}


	public long getIdentificador() {
		return identificador;
	}
	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (identificador ^ (identificador >>> 32));
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
		LugarVoto other = (LugarVoto) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LugarVoto [identificador=" + identificador + ", nombre=" + nombre + ", password=" + password
				+ ", ciudad=" + ciudad + ", pais=" + pais + "]";
	}
	
	


}
