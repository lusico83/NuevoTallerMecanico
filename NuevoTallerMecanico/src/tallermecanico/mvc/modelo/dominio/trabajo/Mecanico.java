package tallermecanico.mvc.modelo.dominio.trabajo;

import tallermecanico.mvc.modelo.dominio.Vehiculo;

public class Mecanico extends Trabajo {
	
	private final double FACTOR_MATERIAL = 2.0;

	public Mecanico(Vehiculo vehiculo) {
		super(vehiculo);
	}

	public Mecanico(Trabajo trabajo) {
		super(trabajo);
	}

	@Override
	public double getPrecioFinalMaterial() {
		return getPrecioMaterial() + FACTOR_MATERIAL;
	}

	@Override
	public TipoTrabajo getTipoTrabajo() {
		return TipoTrabajo.MECANICO;
	}

}
