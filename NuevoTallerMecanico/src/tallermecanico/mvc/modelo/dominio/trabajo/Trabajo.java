package tallermecanico.mvc.modelo.dominio.trabajo;

import java.text.SimpleDateFormat;
import java.util.Date;

import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Vehiculo;

public abstract class Trabajo {
	private Vehiculo vehiculo;
	private Date fecha;
	private int dias;
	private int horas;
	private double precioMaterial;
	private boolean finalizado;
	
	private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private final int MS_DIA = 1000 * 60 * 60 * 24;
	private final double PRECIO_HORA = 30.0;
	private final double PRECIO_DIA = 10.0;

	public Trabajo(Vehiculo vehiculo) {
		setVehiculo(vehiculo);
		fecha = new Date();
		dias = 0;
		horas = 0;
		precioMaterial = 0;
		finalizado = false;
	}

	private void setVehiculo(Vehiculo vehiculo) {
		if (vehiculo != null)
			this.vehiculo = new Vehiculo(vehiculo);
		else
			throw new ExcepcionTallerMecanico("El trabajo debe tener un vehículo identificado");
	}
	
	public abstract double getPrecioFinalMaterial();
	
	public abstract TipoTrabajo getTipoTrabajo();
	
	public Trabajo(Trabajo trabajo) {
		vehiculo = trabajo.getVehiculo();
		fecha = trabajo.getFecha();
		dias = trabajo.getDias();
		horas = trabajo.getHoras();
		precioMaterial = trabajo.getPrecioMaterial();
	}
	
	public Vehiculo getVehiculo() {
		return new Vehiculo(vehiculo);
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public int getDias() {
		return dias;
	}
	
	public int getHoras() {
		return horas;
	}
	
	public double getPrecioMaterial() {
		return precioMaterial;
	}
	
	public boolean getFinalizado() {
		return finalizado;
	}

	public void anadeHoras(int horas) {
		if (horas < 0)
			throw new ExcepcionTallerMecanico("Sólo se pueden añadir horas y no restar");
		if (!finalizado)
			this.horas += horas;
		else
			throw new ExcepcionTallerMecanico("No se pueden añadir horas a un trabajo finalizado");
	}
	
	public void anadePrecioMaterial(double precioMaterial) {
		if (precioMaterial < 0)
			throw new ExcepcionTallerMecanico("Sólo se puede añadir precio de material y no restar");
		if (!finalizado)
			this.precioMaterial += precioMaterial;
		else
			throw new ExcepcionTallerMecanico("No se puede añadir material a un trabajo finalizado");
	}
	
	public void cerrar() {
		Date ahora = new Date();
		dias = difDias(ahora, fecha);
		finalizado = true;
	}
	
	private int difDias(Date fechaFin, Date fechaInicio) {
		long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
		long dias = milisegundos / MS_DIA;
		return (int) dias + 1;
	}
	
	public double getPrecio() {
		return dias * PRECIO_DIA + horas * PRECIO_HORA + getPrecioFinalMaterial();
	}
	
	public String toString() {
		return String.format("Fecha entrada: %s, Días: %d Horas invertidas: %d Precio material: %.2f Precio Final: %.2f Tipo trabajo: %s Finalizado: %b%n\tVehiculo: %s", 
				FORMATO_FECHA.format(fecha), dias, horas, getPrecioFinalMaterial(), getPrecio(), getTipoTrabajo(), finalizado, vehiculo);
	}

}
