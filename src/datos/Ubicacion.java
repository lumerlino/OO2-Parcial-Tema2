package datos;

import java.time.LocalDate;

public class Ubicacion extends Lugar{
	private double longitud;
	private double latitud;
	
	public Ubicacion() {}

	public Ubicacion(String lugar, double longitud, double latitud) {
		super(lugar);
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@Override
	public String toString() {
		return "\nUbicacion [" + super.toString() + "longitud=" + longitud + ", latitud=" + latitud + "]";
	}

	@Override
	public boolean ingresoHabilitado(Permiso permiso, LocalDate dia) {
		return dia.equals(permiso.getFecha());
	}
	
	

}
