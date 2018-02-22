package tallermecanico.mvc.modelo.dominio.trabajo;

import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;
import tallermecanico.mvc.modelo.dominio.Vehiculo;

public enum TipoTrabajo {
	REVISION("Trabajo de revisión") {
		public Revision getInstancia(Vehiculo vehiculo) {
			return new Revision(vehiculo);
		}
	},
	MECANICO("Reparación mecánica") {
		public Mecanico getInstancia(Vehiculo vehiculo) {
			return new Mecanico(vehiculo);
		}
	},
	CHAPA_PINTURA("Trabajo de chapa y pintura") {
		public ChapaPintura getInstancia(Vehiculo vehiculo) {
			return new ChapaPintura(vehiculo);
		}
	};
	
	private String tipoTrabajo;
	
	private TipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	
	public abstract Trabajo getInstancia(Vehiculo vehiculo);
	
	public String toString() {
		return tipoTrabajo;
	}
	
	public static TipoTrabajo getTipoTrabajoSegunOrdinal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionTallerMecanico("Ordinal del tipo de trabajo no válido");
	}
	
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}
}
