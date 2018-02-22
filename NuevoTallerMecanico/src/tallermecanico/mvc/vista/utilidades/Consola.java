package tallermecanico.mvc.vista.utilidades;

import tallermecanico.mvc.modelo.dominio.Cliente;
import tallermecanico.mvc.modelo.dominio.DireccionPostal;
import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Vehiculo;
import tallermecanico.mvc.modelo.dominio.trabajo.TipoTrabajo;
import tallermecanico.mvc.vista.Opcion;

public class Consola {
	
	public static void mostrarMenu() {
		mostrarCabecera("Taller mecánico");
		for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}
	}
	
	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		System.out.println(String.format("%0" + mensaje.length() + "d%n", 0).replace("0", "-"));
	}
	
	public static int elegirOpcion() {
		int ordinalOpcion;
		do {
			System.out.print("\nElige una opción: ");
			ordinalOpcion = Entrada.entero();
		} while (!Opcion.esOrdinalValido(ordinalOpcion));
		return ordinalOpcion;
	}
	
	public static Cliente leerCliente() {
		Cliente cliente = null;
		System.out.print("Nombre: ");
		String nombre = Entrada.cadena();
		System.out.print("DNI: ");
		String dni = Entrada.cadena();
		System.out.print("Teléfono: ");
		String telefono = Entrada.cadena();
		System.out.print("Dirección: ");
		String direccion = Entrada.cadena();
		System.out.print("Localidad: ");
		String localidad = Entrada.cadena();
		System.out.print("Código postal: ");
		String codigoPostal = Entrada.cadena();
		cliente = new Cliente(nombre, dni, telefono, new DireccionPostal(direccion, localidad, codigoPostal));
		return cliente;
	}
	
	public static String leerDni() {
		System.out.print("Introduce el DNI del cliente: ");
		String dniBorrar = Entrada.cadena();
		return dniBorrar;
	}
	
	public static Vehiculo leerVehiculo(Cliente propietario) {
		Vehiculo nuevoVehiculo = null;
		System.out.print("Matrícula: ");
		String matricula = Entrada.cadena();
		System.out.print("Marca: ");
		String marca = Entrada.cadena();
		System.out.print("Modelo: ");
		String modelo = Entrada.cadena();
		System.out.print("Color: ");
		String color = Entrada.cadena();
		System.out.print("Cilindrada: ");
		int cilindrada = Entrada.entero();
		nuevoVehiculo = new Vehiculo(propietario, matricula, marca, modelo, color, cilindrada);
		return nuevoVehiculo;
	}
	
	public static String leerMatricula() {
		System.out.print("Introduce la matrícula del vehículo: ");
		String matriculaBorrar = Entrada.cadena();
		return matriculaBorrar;
	}
	
	public static int leerHorasAnadir() {
		System.out.print("Introduce el número de horas a añadir: ");
		int horas = Entrada.entero();
		return horas;
	}
	
	public static double leerPrecioMaterial() {
		System.out.print("Introduce el precio del material a añadir: ");
		double precioMaterial = Entrada.realDoble();
		return precioMaterial;
	}
	
	public static int elegirTipoTrabajo() {
		int ordinalTipoTrabajo;
		do {
			System.out.printf("Elige el tipo de trabajo: ( %s)", obtenerTiposTrabajo());
			ordinalTipoTrabajo = Entrada.entero();
		} while (!TipoTrabajo.esOrdinalValido(ordinalTipoTrabajo));
		return ordinalTipoTrabajo;
	}
	
	private static String obtenerTiposTrabajo() {
		StringBuilder tiposTrabajos = new StringBuilder("");
		for (TipoTrabajo tipoTrabajo: TipoTrabajo.values()) {
			tiposTrabajos.append(tipoTrabajo.ordinal()).append(".- ").append(tipoTrabajo).append(" ");
		}
		return tiposTrabajos.toString();
	}

}
