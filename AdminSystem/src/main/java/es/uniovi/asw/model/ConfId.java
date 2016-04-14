package es.uniovi.asw.model;

import java.util.Date;

public class ConfId {

	 Date fecha;
	 int horaInicio;
	 int horaFin;
	
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + horaFin;
		result = prime * result + horaInicio;
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
		ConfId other = (ConfId) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (horaFin != other.horaFin)
			return false;
		if (horaInicio != other.horaInicio)
			return false;
		return true;
	}
	 
	 
}
