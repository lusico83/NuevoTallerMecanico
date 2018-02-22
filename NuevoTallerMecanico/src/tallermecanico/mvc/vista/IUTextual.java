package tallermecanico.mvc.vista;

import tallermecanico.mvc.controlador.IControladorTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Cliente;
import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Vehiculo;
import tallermecanico.mvc.modelo.dominio.trabajo.TipoTrabajo;
import tallermecanico.mvc.modelo.dominio.trabajo.Trabajo;
import tallermecanico.mvc.vista.utilidades.Consola;

public class IUTextual implements IVistaTallerMecanico {

	IControladorTallerMecanico controlador;
	
	public IUTextual() {
		Opcion.setVista(this);
	}
	
	@Override
	public void setControlador(IControladorTallerMecanico controlador) {
		this.controlador = controlador;
	}

	@Override
	public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOridnal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}
	
	public void salir() {
		System.out.println("Hasta luego Lucas!!!!");
	}
	
	public void anadirCliente() {
		Consola.mostrarCabecera("Añadir cliente");
		try {
			Cliente cliente = Consola.leerCliente();	
			controlador.anadirCliente(cliente);
			System.out.println("Cliente añadido satisfactoriamente\n");
		} catch (ExcepcionTallerMecanico e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}
	
	public void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		String dni = Consola.leerDni();
		try {
			controlador.borrarCliente(dni);
			System.out.println("Cliente borrado satisfactoriamente\n");
		} catch (Exception e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}
	
	public void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		String dni = Consola.leerDni();
		Cliente cliente = controlador.buscarCliente(dni);
		String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
		System.out.printf("%s%n%n", mensaje);
	}
	
	public void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		for (Cliente cliente: controlador.obtenerClientes()) {
			if (cliente != null)
				System.out.println(cliente);
		}
		System.out.println("");
	}
	
	public void anadirVehiculo() {
		Consola.mostrarCabecera("Añadir vehículo");
		String dni = Consola.leerDni();
		Cliente propietario = controlador.buscarCliente(dni);
		try {
			Vehiculo vehiculo = Consola.leerVehiculo(propietario);
			controlador.anadirVehiculo(vehiculo);
			System.out.println("Vehículo añadido satisfactoriamente\n");
		} catch (ExcepcionTallerMecanico e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}
	
	public void borrarVehiculo() {
		Consola.mostrarCabecera("Borrar vehículo");
		String matricula = Consola.leerMatricula();
		try {
			controlador.borrarVehiculo(matricula);
			System.out.println("Turismo borrado satisfactoriamente\n");
		} catch (ExcepcionTallerMecanico e) {
			System.out.printf("ERROR: %s%n%n", e.getMessage());
		}
	}
	
	public void buscarVehiculo() {
		Consola.mostrarCabecera("Buscar vehículo");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculoBuscado = controlador.buscarVehiculo(matricula);
		String mensaje = (vehiculoBuscado != null) ? vehiculoBuscado.toString() : "El vehículo no existe";
		System.out.printf("%s%n%n", mensaje);
	}
	
	public void listarVehiculos() {
		Consola.mostrarCabecera("Listar vehículos");
		for (Vehiculo vehiculo: controlador.obtenerVehiculos()) {
			if (vehiculo != null)
				System.out.println(vehiculo);
		}
		System.out.println("");
	}
	
	public void abrirTrabajo() {
		Consola.mostrarCabecera("Abrir trabajo");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		if (vehiculo == null)
			System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
		else {
			int ordinalTipoTrabajo = Consola.elegirTipoTrabajo();
			try {
				controlador.abrirTrabajo(vehiculo, TipoTrabajo.getTipoTrabajoSegunOrdinal(ordinalTipoTrabajo));;
				System.out.println("Trabajo abierto satisfactoriamente\n");
			} catch (ExcepcionTallerMecanico e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}
	
	public void cerrarTrabajo() {
		Consola.mostrarCabecera("Cerrar trabajo");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		if (vehiculo == null)
			System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
		else {
			try {
				controlador.cerrarTrabajo(vehiculo);
				System.out.println("Trabajo cerrado satisfactoriamente\n");
			} catch (ExcepcionTallerMecanico e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}
	
	public void anadirHorasTrabajo() {
		Consola.mostrarCabecera("Añadir horas a un trabajo");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		if (vehiculo == null)
			System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
		else {
			int horas = Consola.leerHorasAnadir();
			try {
				controlador.anadirHorasTrabajo(vehiculo, horas);
				System.out.println("Horas añadidas satisfactoriamente\n");
			} catch (ExcepcionTallerMecanico e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}
	
	public void anadirPrecioMaterialTrabajo() {
		Consola.mostrarCabecera("Añadir precio del material a un trabajo");
		String matricula = Consola.leerMatricula();
		Vehiculo vehiculo = controlador.buscarVehiculo(matricula);
		if (vehiculo == null)
			System.out.println("ERROR: No existe un vehículo con dicha matrícula\n");
		else {
			double precioMaterial = Consola.leerPrecioMaterial();
			try {
				controlador.anadirPrecioMaterialTrabajo(vehiculo, precioMaterial);
				System.out.println("Precio del material añadido satisfactoriamente\n");
			} catch (ExcepcionTallerMecanico e) {
				System.out.printf("ERROR: %s%n%n", e.getMessage());
			}
		}
	}
	
	public void listarTrabajos() {
		Consola.mostrarCabecera("Listar trabajos");
		for (Trabajo trabajo: controlador.obtenerTrabajos()) {
			if (trabajo != null)
				System.out.println(trabajo);
		}
		System.out.println("");
	}
}
