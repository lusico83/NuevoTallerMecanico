package tallermecanico.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vehiculo {
	private Cliente propietario;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int cilindrada;
	
	public Vehiculo(Vehiculo vehiculo) {
		propietario = vehiculo.getPropietario();
		matricula = vehiculo.getMatricula();
		marca = vehiculo.getMarca();
		modelo = vehiculo.getModelo();
		color = vehiculo.getColor();
		cilindrada = vehiculo.getCilindrada();
	}
	
	public Vehiculo(Cliente propietario, String matricula, String marca, String modelo, String color, int cilindrada) {
		setPropietario(propietario);
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setColor(color);
		setCilindrada(cilindrada);
	}

	private void setPropietario(Cliente propietario) {
		if (propietario != null)
			this.propietario = new Cliente(propietario);
		else
			throw new ExcepcionTallerMecanico("El vehículo debe tener un propietario identificado");
	}

	private void setMatricula(String matricula) {
		if (compruebaMatricula(matricula))
			this.matricula = matricula;
		else
			throw new ExcepcionTallerMecanico("Matrícula no válida");
	}
	
	private boolean compruebaMatricula(String matricula) {
		Pattern patron = Pattern.compile("[0-9]{4}[B-DF-HJ-NP-TV-Z]{3}");
		Matcher emparejador = patron.matcher(matricula);
		return emparejador.matches();
	}

	private void setMarca(String marca) {
		if (marca != null && !marca.equals(""))
			this.marca = marca;
		else
			throw new ExcepcionTallerMecanico("Marca no válida");
	}

	private void setModelo(String modelo) {
		if (modelo != null && !modelo.equals(""))
			this.modelo = modelo;
		else 
			throw new ExcepcionTallerMecanico("Modelo no válido");
	}

	public
	void setColor(String color) {
		if (color != null && !color.equals(""))
			this.color = color;
		else
			throw new ExcepcionTallerMecanico("Color no válido");
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada > 0)
			this.cilindrada = cilindrada;
		else
			throw new ExcepcionTallerMecanico("Cilindrada no válida");
	}

	public Cliente getPropietario() {
		return new Cliente(propietario);
	}
	
	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}
	
	public String getColor() {
		return color;
	}

	public int getCilindrada() {
		return cilindrada;
	}
	
	public String toString() {
		return String.format("Matrícula: %s, Marca: %s Modelo: %s Color: %s Cilindrada: %d%n\tPropietario: %s", 
				matricula, marca, modelo, color, cilindrada, propietario);
	}

}
