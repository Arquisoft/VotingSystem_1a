package es.uniovi.asw.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TConfiguration")
public class Configuracion {

	@Id 
	@GeneratedValue
	private Long id;
	private Date fecha;
	private LocalTime HoraInicio;
	private LocalTime HoraFin;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraInicio() {
		return HoraInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		HoraInicio = horaInicio;
	}
	public LocalTime getHoraFin() {
		return HoraFin;
	}
	public void setHoraFin(LocalTime horaFin) {
		HoraFin = horaFin;
	}
	
	

}
