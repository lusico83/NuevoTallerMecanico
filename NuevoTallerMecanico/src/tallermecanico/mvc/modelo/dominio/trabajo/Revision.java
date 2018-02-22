package tallermecanico.mvc.modelo.dominio.trabajo;

import tallermecanico.mvc.modelo.dominio.Vehiculo;

public class Revision extends Trabajo {
	
	private final double FACTOR_MATERIAL = 1.0;

	public Revision(Vehiculo vehiculo) {
		super(vehiculo);
	}

	public Revision(Trabajo trabajo) {
		super(trabajo);
	}

	@Override
	public double getPrecioFinalMaterial() {
		return getPrecioMaterial() * FACTOR_MATERIAL;
	}

	@Override
	public TipoTrabajo getTipoTrabajo() {
		return TipoTrabajo.REVISION;
	}

}
