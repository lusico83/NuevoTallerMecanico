package tallermecanico.mvc.modelo;

import tallermecanico.mvc.modelo.dominio.Cliente;
import tallermecanico.mvc.modelo.dominio.Vehiculo;
import tallermecanico.mvc.modelo.dominio.trabajo.TipoTrabajo;
import tallermecanico.mvc.modelo.dominio.trabajo.Trabajo;

public interface IModeloTallerMecanico {

	void anadirCliente(Cliente cliente);

	void borrarCliente(String dni);

	Cliente buscarCliente(String dni);

	Cliente[] obtenerClientes();

	void anadirVehiculo(Vehiculo vehiculo);

	void borrarVehiculo(String matricula);

	Vehiculo buscarVehiculo(String matricula);

	Vehiculo[] obtenerVehiculos();

	void abrirTrabajo(Vehiculo vehiculo, TipoTrabajo tipoTrabajo);

	void cerrarTrabajo(Vehiculo vehiculo);

	void anadirHorasTrabajo(Vehiculo vehiculo, int horas);

	void anadirPrecioMaterialTrabajo(Vehiculo vehiculo, double precioMaterial);

	Trabajo[] obtenerTrabajos();

	void anadirDatosPrueba();

}