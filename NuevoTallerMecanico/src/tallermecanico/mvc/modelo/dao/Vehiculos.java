package tallermecanico.mvc.modelo.dao;

import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Vehiculo;

public class Vehiculos {
	
	private Vehiculo[] vehiculos;
	
	private final int MAX_VEHICULOS = 20;

	public Vehiculos() {
		vehiculos = new Vehiculo[MAX_VEHICULOS];
	}
	
	public Vehiculo[] getVehiculos() {
		return vehiculos.clone();
	}
	
	public void anadirVehiculo(Vehiculo vehiculo) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
		if (indiceNoSuperaTamano(indice))
			vehiculos[indice] = new Vehiculo(vehiculo);
		else
			throw new ExcepcionTallerMecanico("El array de vehículos está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
			if (vehiculos[indice] == null)
				vehiculoEncontrado = true;
			else
				if (vehiculos[indice].getMatricula().equals(vehiculo.getMatricula()))
					throw new ExcepcionTallerMecanico("Ya existe un vehículo con esa matrícula");
				else
					indice++;
		}
		return indice;
	}
	
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < vehiculos.length;
	}
	
	public void borrarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new ExcepcionTallerMecanico("El vehículo a borrar no existe");
		}
	}

	private int buscarIndiceVehiculo(String matricula) {
		int indice = 0;
		boolean vehiculoEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado && vehiculos[indice] != null) {
			if (vehiculos[indice].getMatricula().equals(matricula))
				vehiculoEncontrado = true;
			else
				indice++;
		}
		return vehiculoEncontrado ? indice : vehiculos.length;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < vehiculos.length - 1 && vehiculos[i] != null; i++) {
			vehiculos[i] = vehiculos[i+1];
		}
		if (indice == vehiculos.length - 1)
			vehiculos[vehiculos.length - 1] = null;
	}
	
	public Vehiculo buscarVehiculo(String matricula) {
		int indice = buscarIndiceVehiculo(matricula);
		if (indiceNoSuperaTamano(indice))
			return new Vehiculo(vehiculos[indice]);
		else
			return null;
	}

}
