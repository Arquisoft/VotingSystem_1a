package es.uniovi.asw.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TVotes")
public class Voto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String opcion;

	@Id
	private long lugar;
	
	private int numero;
	
	
	public Voto() {
	}


	public Voto(String opcion, long lugar, int numero) {
		super();
		this.opcion = opcion;
		this.lugar = lugar;
		this.numero = numero;
	}


	public String getOpcion() {
		return opcion;
	}


	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}


	public long getLugar() {
		return lugar;
	}


	public void setLugar(long lugar) {
		this.lugar = lugar;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (lugar ^ (lugar >>> 32));
		result = prime * result + numero;
		result = prime * result + ((opcion == null) ? 0 : opcion.hashCode());
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
		Voto other = (Voto) obj;
		if (lugar != other.lugar)
			return false;
		if (numero != other.numero)
			return false;
		if (opcion == null) {
			if (other.opcion != null)
				return false;
		} else if (!opcion.equals(other.opcion))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Voto [opcion=" + opcion + ", lugar=" + lugar + ", numero=" + numero + "]";
	}


	
		
}
