package es.uniovi.asw.model;

import java.io.Serializable;

public class VotoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String opcion;
	 long lugar;
	
	 
	 
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (lugar ^ (lugar >>> 32));
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
		VotoId other = (VotoId) obj;
		if (lugar != other.lugar)
			return false;
		if (opcion == null) {
			if (other.opcion != null)
				return false;
		} else if (!opcion.equals(other.opcion))
			return false;
		return true;
	}
	 
	 

}
