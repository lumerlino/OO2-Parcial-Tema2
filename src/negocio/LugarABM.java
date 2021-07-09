package negocio;

import dao.LugarDao;
import datos.Localidad;
import datos.Ubicacion;

public class LugarABM {
	private static LugarABM instancia = null;
	
	protected LugarABM () {}
	
	public static LugarABM getInstance() {
		if(instancia==null) {
			instancia=new LugarABM();
		}
		return instancia;
	}
	
	public Ubicacion traerUbicacion(int id) {
		return LugarDao.getInstance().traerUbicacion(id);
	}
	
	public Localidad traerLocalidad(int id) {
		return LugarDao.getInstance().traerLocalidad(id);
	}

}
