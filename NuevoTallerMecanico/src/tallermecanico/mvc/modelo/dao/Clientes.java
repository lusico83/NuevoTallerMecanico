package tallermecanico.mvc.modelo.dao;

import tallermecanico.mvc.modelo.dominio.Cliente;
import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;

public class Clientes {
	
	private Cliente[] clientes;
	
	private final int MAX_CLIENTES = 20;

	public Clientes() {
		clientes = new Cliente[MAX_CLIENTES];
	}
	
	public Cliente[] getClientes() {
		return clientes.clone();
	}
	
	public void anadirCliente(Cliente cliente) {
		int indice = buscarPrimerIndiceLibreComprobandoExistencia(cliente);
		if (indiceNoSuperaTamano(indice))
			clientes[indice] = new Cliente(cliente);
		else
			throw new ExcepcionTallerMecanico("El array de clientes está lleno.");
	}

	private int buscarPrimerIndiceLibreComprobandoExistencia(Cliente cliente) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
			if (clientes[indice] == null)
				clienteEncontrado = true;
			else
				if (clientes[indice].getDni().equals(cliente.getDni()))
					throw new ExcepcionTallerMecanico("Ya existe un cliente con ese DNI");
				else
					indice++;
		}
		return indice;
	}

	private boolean indiceNoSuperaTamano(int indice) {
		return indice < clientes.length;
	}
	
	public void borrarCliente(String dni) {
		int indice = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new ExcepcionTallerMecanico("El cliente a borrar no existe");
		}
	}
	
	private int buscarIndiceCliente(String dni) {
		int indice = 0;
		boolean clienteEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !clienteEncontrado && clientes[indice] != null) {
			if (clientes[indice].getDni().equals(dni))
				clienteEncontrado = true;
			else
				indice++;
		}
		return clienteEncontrado ? indice : clientes.length;
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
			clientes[i] = clientes[i+1];
		}
		if (indice == clientes.length - 1)
			clientes[clientes.length - 1] = null;
	}
	
	public Cliente buscarCliente(String dni) {
		int posicion = buscarIndiceCliente(dni);
		if (indiceNoSuperaTamano(posicion))
			return new Cliente(clientes[posicion]);
		else
			return null;
	}

}
