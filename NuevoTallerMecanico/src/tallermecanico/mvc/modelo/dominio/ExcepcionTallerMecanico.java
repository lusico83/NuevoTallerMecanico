package tallermecanico.mvc.modelo.dominio;

public class ExcepcionTallerMecanico extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionTallerMecanico(String mensaje) {
		super(mensaje);
	}

}
