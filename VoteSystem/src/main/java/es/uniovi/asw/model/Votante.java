package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TVotantes")
public class Votante {

	@Id
	public String dni;
	
	public Votante(){
		
	}
	
	public Votante(String dni){
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Votante [id=" + dni + "]";
	}

	public String getId() {
		return dni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Votante other = (Votante) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
}
