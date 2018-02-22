package tallermecanico.mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DireccionPostal {
	
	private String calle;
	private String localidad;
	private String codigoPostal;
	
	public DireccionPostal(DireccionPostal direccionPostal) {
		calle = direccionPostal.getCalle();
		localidad = direccionPostal.getLocalidad();
		codigoPostal = direccionPostal.getCodigoPostal();
	}
	
	public DireccionPostal(String calle, String localidad, String codigoPostal) {
		setCalle(calle);
		setLocalidad(localidad);
		setCodgioPostal(codigoPostal);
	}

	private void setCodgioPostal(String codigoPostal) {
		if (compruebaCodigoPostal(codigoPostal))
			this.codigoPostal = codigoPostal;
		else
			throw new ExcepcionTallerMecanico("Código Postal no válido");
	}

	private void setLocalidad(String localidad) {
		if (localidad != null && !localidad.equals(""))
			this.localidad = localidad;
		else
			throw new ExcepcionTallerMecanico("Localidad no válida");
	}

	private void setCalle(String calle) {
		if (calle != null && !calle.equals(""))
			this.calle = calle;
		else 
			throw new ExcepcionTallerMecanico("Calle no válida");
	}
	
	boolean compruebaCodigoPostal(String codigoPostal) {
		Pattern patron = Pattern.compile("[0-9]{5}");
		Matcher emparejador = patron.matcher(codigoPostal);
		return emparejador.matches();
	}
	
	public String getCalle() {
		return calle;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public String toString() {
		return String.format("Direccion: %s Localidad: %s Código Postal: %s", calle, localidad, codigoPostal);
	}

}