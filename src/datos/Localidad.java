package datos;

import java.time.LocalDate;

public class Localidad extends Lugar{
	private String codPostal;
	private boolean cumplirCuarentena;
		
	public Localidad() {}
	
	public Localidad(String lugar, String codPostal, boolean cumplirCuarentena) {
		super(lugar);
		this.codPostal = codPostal;
		this.cumplirCuarentena = cumplirCuarentena;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public boolean isCumplirCuarentena() {
		return cumplirCuarentena;
	}

	public void setCumplirCuarentena(boolean cumplirCuarentena) {
		this.cumplirCuarentena = cumplirCuarentena;
	}

	@Override
	public String toString() {
		return "\nLocalidad [" + super.toString() + ", codPostal=" + codPostal + ", cumplirCuarentena=" + cumplirCuarentena + "]";
	}

	@Override
	public boolean ingresoHabilitado(Permiso permiso, LocalDate dia) {
		boolean activo = false;
		LocalDate fechaInicia = permiso.getFecha();
		LocalDate fechaVence = permiso.getFecha().plusDays(permiso.getCantDias());
		if ((dia.equals(fechaInicia) || dia.isAfter(fechaInicia)) && (dia.equals(fechaVence) || dia.isBefore(fechaVence))) {
			activo = true;
		}
		return activo;
	}
	
	

}
