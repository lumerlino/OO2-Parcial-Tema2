package negocio;

import dao.PermisoDao;
import datos.Permiso;

public class PermisoABM {
	private static PermisoABM instancia = null;
	
	protected PermisoABM () {}
	
	public static PermisoABM getInstance() {
		if(instancia==null) {
			instancia=new PermisoABM();
		}
		return instancia;
	}
	
	public Permiso traerPermiso(int id) {
		return PermisoDao.getInstance().traerPermiso(id);
	}

}
