package tallermecanico.mvc.modelo.dao;

import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Vehiculo;
import tallermecanico.mvc.modelo.dominio.trabajo.TipoTrabajo;
import tallermecanico.mvc.modelo.dominio.trabajo.Trabajo;

public class Trabajos {
	
	private Trabajo[] trabajos;

	private final int MAX_TRABAJOS = 20;

	public Trabajos() {
		trabajos = new Trabajo[MAX_TRABAJOS];
	}
	
	public Trabajo[] getTrabajos() {
		return trabajos.clone();
	}
	
	public void abrirTrabajo(Vehiculo vehiculo, TipoTrabajo tipoTrabajo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(vehiculo);
		if (indiceNoSuperaTamano(indice))
			trabajos[indice] = tipoTrabajo.getInstancia(vehiculo);
		else
			throw new ExcepcionTallerMecanico("El array de trabajos está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistenciaOtroAbierto(Vehiculo vehiculo) {
		int indice = 0;
		boolean trabajoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !trabajoEncontrado) {
			if (trabajos[indice] == null)
				trabajoEncontrado = true;
			else
				if (trabajos[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula()) && 
						!trabajos[indice].getFinalizado())
					throw new ExcepcionTallerMecanico("Ya existe un trabajo abierto para este vehículo");
				else
					indice++;
		}
		return indice;
	}
	
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < trabajos.length;
	}
	
	public void cerrarTrabajo(Vehiculo vehiculo) {
		int indice = buscarTrabajoAbierto(vehiculo);
		if (indiceNoSuperaTamano(indice))
			trabajos[indice].cerrar();
		else
			throw new ExcepcionTallerMecanico("No hay ningún trabajo abierto para ese vehículo");
	}

	private int buscarTrabajoAbierto(Vehiculo vehiculo) {
		int indice = 0;
		boolean trabajoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !trabajoEncontrado && trabajos[indice] != null) {
			if (trabajos[indice].getVehiculo().getMatricula().equals(vehiculo.getMatricula()) &&
					!trabajos[indice].getFinalizado())
				trabajoEncontrado = true;
			else
				indice++;
		}
		return trabajoEncontrado ? indice : trabajos.length;
	}
	
	public void anadirHorasTrabajo(Vehiculo vehiculo, int horas) {
		int indice = buscarTrabajoAbierto(vehiculo);
		if (indiceNoSuperaTamano(indice))
			trabajos[indice].anadeHoras(horas);
		else
			throw new ExcepcionTallerMecanico("No hay ningún trabajo abierto para ese vehículo");
	}
	
	public void anadirPrecioMaterialTrabajo(Vehiculo vehiculo, double precioMaterial) {
		int indice = buscarTrabajoAbierto(vehiculo);
		if (indiceNoSuperaTamano(indice))
			trabajos[indice].anadePrecioMaterial(precioMaterial);
		else
			throw new ExcepcionTallerMecanico("No hay ningún trabajo abierto para ese vehículo");
	}

}
