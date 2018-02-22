package tallermecanico.mvc.vista;

import tallermecanico.mvc.controlador.IControladorTallerMecanico;

public interface IVistaTallerMecanico {

	void setControlador(IControladorTallerMecanico controlador);

	void comenzar();

}