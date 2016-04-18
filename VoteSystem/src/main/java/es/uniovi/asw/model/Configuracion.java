package es.uniovi.asw.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "TConfig")
@IdClass(Conf.class)
public class Configuracion {

	
	@Id private Date fecha;
	@Id @Column(name="HORAINICIO")
	private int hora_Inicio;
	@Id @Column(name="HORAFIN")
	private int hora_Fin;
	
	public Configuracion() {

	}

	@Override
	public String toString() {
		return "Configuracion [ fecha=" + fecha + ", horaInicio=" + hora_Inicio + ", horaFin=" + hora_Fin
				+ "]";
	}



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
		Configuracion other = (Configuracion) obj;
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



	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getHoraInicio() {
		return hora_Inicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.hora_Inicio = horaInicio;
	}

	public int getHoraFin() {
		return hora_Fin;
	}

	public void setHoraFin(int horaFin) {
		this.hora_Fin = horaFin;
	}

}
