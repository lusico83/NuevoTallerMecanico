package tallermecanico.mvc.controlador;

import tallermecanico.mvc.modelo.IModeloTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Cliente;
import tallermecanico.mvc.modelo.dominio.Vehiculo;
import tallermecanico.mvc.modelo.dominio.trabajo.TipoTrabajo;
import tallermecanico.mvc.modelo.dominio.trabajo.Trabajo;
import tallermecanico.mvc.vista.IVistaTallerMecanico;

public class ControladorTallerMecanico implements IControladorTallerMecanico {

	private IModeloTallerMecanico modelo;
	private IVistaTallerMecanico vista;

	public ControladorTallerMecanico(IVistaTallerMecanico vista, IModeloTallerMecanico modelo) {
		this.vista = vista;
		this.modelo = modelo;
		vista.setControlador(this);
	}
	
	@Override
	public void comenzar() {
		modelo.anadirDatosPrueba();
		vista.comenzar();
	}
	
	@Override
	public void anadirCliente(Cliente cliente) {
		modelo.anadirCliente(cliente);
	}
	
	@Override
	public void borrarCliente(String dni) {
		modelo.borrarCliente(dni);
	}
	
	@Override
	public Cliente buscarCliente(String dni) {
		return modelo.buscarCliente(dni);
	}
	
	@Override
	public Cliente[] obtenerClientes() {
		return modelo.obtenerClientes();
	}
	
	@Override
	public void anadirVehiculo(Vehiculo vehiculo) {
		modelo.anadirVehiculo(vehiculo);
	}
	
	@Override
	public void borrarVehiculo(String matricula) {
		modelo.borrarVehiculo(matricula);
	}
	
	@Override
	public Vehiculo buscarVehiculo(String matricula) {
		return modelo.buscarVehiculo(matricula);
	}
	
	@Override
	public Vehiculo[] obtenerVehiculos() {
		return modelo.obtenerVehiculos();
	}
	
	@Override
	public void abrirTrabajo(Vehiculo vehiculo, TipoTrabajo tipoTrabajo) {
		modelo.abrirTrabajo(vehiculo, tipoTrabajo);
	}
	
	@Override
	public void cerrarTrabajo(Vehiculo vehiculo) {
		modelo.cerrarTrabajo(vehiculo);
	}
	
	@Override
	public void anadirHorasTrabajo(Vehiculo vehiculo, int horas) {
		modelo.anadirHorasTrabajo(vehiculo, horas);
	}
	
	@Override
	public void anadirPrecioMaterialTrabajo(Vehiculo vehiculo, double precioMaterial) {
		modelo.anadirPrecioMaterialTrabajo(vehiculo, precioMaterial);
	}
	
	@Override
	public Trabajo[] obtenerTrabajos() {
		return modelo.obtenerTrabajos();
	}

	@Override
	public void anadirDatosPrueba() {
		modelo.anadirDatosPrueba();
	}


}
