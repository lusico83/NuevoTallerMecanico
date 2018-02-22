package tallermecanico.mvc.modelo.dominio.trabajo;

import tallermecanico.mvc.modelo.dominio.Vehiculo;

public class ChapaPintura extends Trabajo {
	
	private final double FACTOR_MATERIAL = 1.5;

	public ChapaPintura(Vehiculo vehiculo) {
		super(vehiculo);
	}

	public ChapaPintura(Trabajo trabajo) {
		super(trabajo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPrecioFinalMaterial() {
		return getPrecioMaterial() * FACTOR_MATERIAL;
	}

	@Override
	public TipoTrabajo getTipoTrabajo() {
		return TipoTrabajo.CHAPA_PINTURA;
	}

}
