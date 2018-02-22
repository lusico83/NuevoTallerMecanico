package tallermecanico.mvc.vista;

import tallermecanico.mvc.modelo.dominio.ExcepcionTallerMecanico;

public enum Opcion {
	SALIR("Salir") {
		public void ejecutar() {
			vista.salir();
		}
	},
	ANADIR_CLIENTE("Añadir cliente") {
		public void ejecutar() {
			vista.anadirCliente();
		}
	},
	BORRAR_CLIENTE("Borrar cliente") {
		public void ejecutar() {
			vista.borrarCliente();
		}
	},
	BUSCAR_CLIENTE("Buscar cliente") {
		public void ejecutar() {
			vista.buscarCliente();
		}
	},
	LISTAR_CLIENTES("Listar clientes") {
		public void ejecutar() {
			vista.listarClientes();
		}
	},
	ANADIR_VEHICULO("Añadir vehículo") {
		public void ejecutar() {
			vista.anadirVehiculo();
		}
	},
	BORRAR_VEHICULO("Borrar vehículo") {
		public void ejecutar() {
			vista.borrarVehiculo();
		}
	},
	BUSCAR_VEHICULO("Buscar vehículo") {
		public void ejecutar() {
			vista.buscarVehiculo();
		}
	},
	LISTAR_VEHICULOS("Listar vehículos") {
		public void ejecutar() {
			vista.listarVehiculos();
		}
	},
	ABRIR_TRABAJO("Abrir trabajo") {
		public void ejecutar() {
			vista.abrirTrabajo();
		}
	},
	CERRAR_TRABAJO("Cerrar trabajo") {
		public void ejecutar() {
			vista.cerrarTrabajo();
		}
	},
	ANADIR_HORAS_TRABAJO("Añadir horas a un trabajo") {
		public void ejecutar() {
			vista.anadirHorasTrabajo();
		}
	},
	ANADIR_PRECIO_MATERIAL_TRABAJO("Añadir precio del material a un trabajo") {
		public void ejecutar() {
			vista.anadirPrecioMaterialTrabajo();
		}
	},
	LISTAR_TRABAJOS("Listar trabajos") {
		public void ejecutar() {
			vista.listarTrabajos();
		}
	};
	
	private String mensaje;
	private static IUTextual vista;
	
	private Opcion(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public abstract void ejecutar();
	
	public String getMensaje() {
		return mensaje;
	}
	
	public static void setVista(IUTextual vista) {
		Opcion.vista = vista;
	}
	
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensaje);
	}
	
	public static Opcion getOpcionSegunOridnal(int ordinal) {
		if (esOrdinalValido(ordinal))
			return values()[ordinal];
		else
			throw new ExcepcionTallerMecanico("Ordinal de la opción no válido");
	}
	
	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
	}
}
