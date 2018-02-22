package tallermecanico.mvc.modelo;

import tallermecanico.mvc.modelo.dao.Clientes;
import tallermecanico.mvc.modelo.dao.Trabajos;
import tallermecanico.mvc.modelo.dao.Vehiculos;
import tallermecanico.mvc.modelo.dominio.Cliente;
import tallermecanico.mvc.modelo.dominio.DireccionPostal;
import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Vehiculo;
import tallermecanico.mvc.modelo.dominio.trabajo.TipoTrabajo;
import tallermecanico.mvc.modelo.dominio.trabajo.Trabajo;

public class TallerMecanico implements IModeloTallerMecanico {
	private Clientes clientes;
	private Vehiculos vehiculos;
	private Trabajos trabajos;
	
	public TallerMecanico() {
		clientes = new Clientes();
		vehiculos = new Vehiculos();
		trabajos = new Trabajos();
	}
	
	@Override
	public void anadirCliente(Cliente cliente) {
		clientes.anadirCliente(cliente);
	}
	
	@Override
	public void borrarCliente(String dni) {
		clientes.borrarCliente(dni);
	}
	
	@Override
	public Cliente buscarCliente(String dni) {
		return clientes.buscarCliente(dni);
	}
	
	@Override
	public Cliente[] obtenerClientes() {
		return clientes.getClientes();
	}
	
	@Override
	public void anadirVehiculo(Vehiculo vehiculo) {
		comprobarExsitenciaPropietario(vehiculo);
		vehiculos.anadirVehiculo(vehiculo);
	}

	private void comprobarExsitenciaPropietario(Vehiculo vehiculo) {
		if (clientes.buscarCliente(vehiculo.getPropietario().getDni()) == null)
			throw new ExcepcionTallerMecanico("El propietario del vehículo no existe");
	}
	
	@Override
	public void borrarVehiculo(String matricula) {
		vehiculos.borrarVehiculo(matricula);
	}
	
	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		return vehiculos.buscarVehiculo(matricula);
	}
	
	@Override
	public Vehiculo[] obtenerVehiculos() {
		return vehiculos.getVehiculos();
	}
	
	@Override
	public void abrirTrabajo(Vehiculo vehiculo, TipoTrabajo tipoTrabajo) {
		comprobarExistenciaVehiculo(vehiculo);
		trabajos.abrirTrabajo(vehiculo, tipoTrabajo);
	}

	private void comprobarExistenciaVehiculo(Vehiculo vehiculo) {
		if (vehiculos.buscarVehiculo(vehiculo.getMatricula()) == null)
			throw new ExcepcionTallerMecanico("El vehículo no existe");
	}
	
	@Override
	public void cerrarTrabajo(Vehiculo vehiculo) {
		comprobarExistenciaVehiculo(vehiculo);
		trabajos.cerrarTrabajo(vehiculo);
	}
	
	@Override
	public void anadirHorasTrabajo(Vehiculo vehiculo, int horas) {
		comprobarExistenciaVehiculo(vehiculo);
		trabajos.anadirHorasTrabajo(vehiculo, horas);
	}
	
	@Override
	public void anadirPrecioMaterialTrabajo(Vehiculo vehiculo, double precioMaterial) {
		comprobarExistenciaVehiculo(vehiculo);
		trabajos.anadirPrecioMaterialTrabajo(vehiculo, precioMaterial);
	}
	
	@Override
	public Trabajo[] obtenerTrabajos() {
		return trabajos.getTrabajos();
	}

	@Override
	public void anadirDatosPrueba() {
		Cliente cliente1 = new Cliente("aa", "11111111A", "950111111", new DireccionPostal("aa", "Almería", "04001"));
		Cliente cliente2 = new Cliente("bb", "22222222B", "950222222", new DireccionPostal("bb", "Almería", "04002"));
		anadirCliente(cliente1);
		anadirCliente(cliente2);
		Vehiculo vehiculo1 = new Vehiculo(cliente1, "1111BBB", "Seat", "Ibiza", "Blanco", 1900);
		Vehiculo vehiculo2 = new Vehiculo(cliente2, "2222BBB", "Opel", "Corsa", "Negro", 1600);
		anadirVehiculo(vehiculo1);
		anadirVehiculo(vehiculo2);
		abrirTrabajo(vehiculo1, TipoTrabajo.CHAPA_PINTURA);
		abrirTrabajo(vehiculo2, TipoTrabajo.REVISION);
		cerrarTrabajo(vehiculo1);
		abrirTrabajo(vehiculo1, TipoTrabajo.MECANICO);
		anadirHorasTrabajo(vehiculo1, 1);
	}

}
