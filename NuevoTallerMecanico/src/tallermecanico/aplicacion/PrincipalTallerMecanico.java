package tallermecanico.aplicacion;

import tallermecanico.mvc.controlador.ControladorTallerMecanico;
import tallermecanico.mvc.controlador.IControladorTallerMecanico;
import tallermecanico.mvc.modelo.IModeloTallerMecanico;
import tallermecanico.mvc.modelo.TallerMecanico;
import tallermecanico.mvc.vista.IUTextual;
import tallermecanico.mvc.vista.IVistaTallerMecanico;

public class PrincipalTallerMecanico {

	public static void main(String[] args) {
		IModeloTallerMecanico modelo = new TallerMecanico();
		IVistaTallerMecanico vista = new IUTextual();
		IControladorTallerMecanico controlador = new ControladorTallerMecanico(vista, modelo);
		
		controlador.comenzar();
	}

}
