package es.uniovi.asw.model;

import java.io.Serializable;
import java.util.Date;

public class Conf implements Serializable {

	private static final long serialVersionUID = 1L;

	Date fecha;
	int hora_Inicio;
	int hora_Fin;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + hora_Fin;
		result = prime * result + hora_Inicio;
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
		Conf other = (Conf) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora_Fin != other.hora_Fin)
			return false;
		if (hora_Inicio != other.hora_Inicio)
			return false;
		return true;
	}
	
	

}
