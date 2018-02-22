package tallermecanico.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private String nombre;
	private String dni;
	private String telefono;
	private DireccionPostal direccionPostal;
	private int identificador;
	private static int ultimoIdentificador = 0;
	
	public Cliente(Cliente cliente) {
		nombre = cliente.getNombre();
		dni = cliente.getDni();
		telefono = cliente.getTelefono();
		direccionPostal = cliente.getDireccionPostal();
		//asignarNuevoIdentificador();
		identificador = cliente.getIdentificador();
	}

	private void asignarNuevoIdentificador() {
		ultimoIdentificador++;
		identificador = ultimoIdentificador;
	}
	
	public Cliente(String nombre, String dni, String telefono, DireccionPostal direccionPostal) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
		setDireccionPostal(direccionPostal);
		asignarNuevoIdentificador();
	}

	private void setNombre(String nombre) {
		if (nombre != null && !nombre.equals(""))
			this.nombre = nombre;
		else 
			throw new ExcepcionTallerMecanico("Nombre no válido");
	}
	
	public void setTelefono(String telefono) {
		if (compruebaTelefono(telefono))
			this.telefono = telefono;
		else
			throw new ExcepcionTallerMecanico("Teléfono no válido");
	}
	
	private boolean compruebaTelefono(String telefono) {
		Pattern patron = Pattern.compile("[0-9]{9}");
		Matcher emparejador = patron.matcher(telefono);
		return emparejador.matches();
	}
	
	private void setDni(String dni) {
		if (compruebaDni(dni))
			this.dni = dni;
		else
			throw new ExcepcionTallerMecanico("DNI no válido");
	}
	
	private boolean compruebaDni(String dni) {
		Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher emparejador = patron.matcher(dni);
		return emparejador.matches();
	}
	
	
	public void setDireccionPostal(DireccionPostal direccionPostal) {
		this.direccionPostal = new DireccionPostal(direccionPostal);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public DireccionPostal getDireccionPostal() {
		return new DireccionPostal(direccionPostal);
	}
	
	public int getIdentificador() {
		return identificador;
	}
	
	public String toString() {
		return String.format("Identificador: %d Nombre: %s DNI: %s Teléfono: %s %s", 
				identificador, nombre, dni, telefono, direccionPostal);
	}
	
}
