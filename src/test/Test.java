package test;

import java.time.LocalDate;

import datos.Permiso;
import negocio.LugarABM;
import negocio.PermisoABM;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1)");
		int id = 4;
		System.out.println(PermisoABM.getInstance().traerPermiso(id));
		
		System.out.println("2)");
		int idLocalidad = 3;
		System.out.println(LugarABM.getInstance().traerLocalidad(idLocalidad));
		
		System.out.println("3)");
		Permiso p = PermisoABM.getInstance().traerPermiso(id);
		System.out.println(LugarABM.getInstance().traerLocalidad(idLocalidad).ingresoHabilitado(p, LocalDate.of(2021, 5, 12)));
		
		System.out.println("4)");
		Permiso per = PermisoABM.getInstance().traerPermiso(id);
		System.out.println(LugarABM.getInstance().traerLocalidad(idLocalidad).ingresoHabilitado(per, LocalDate.of(2021, 5, 20)));
		
		System.out.println("5)");
		Permiso permiso = PermisoABM.getInstance().traerPermiso(id);
		System.out.println(LugarABM.getInstance().traerLocalidad(idLocalidad).ingresoHabilitado(permiso, LocalDate.of(2021, 5, 25)));
		
		System.out.println("6)");
		int idUbicacion = 4;
		System.out.println(LugarABM.getInstance().traerUbicacion(idUbicacion));
		
		System.out.println("7)");
		int idPermiso = 3;
		Permiso permiso1 = PermisoABM.getInstance().traerPermiso(idPermiso);
		System.out.println(LugarABM.getInstance().traerUbicacion(idUbicacion).ingresoHabilitado(permiso1, LocalDate.of(2021, 4, 30)));
		
		System.out.println("8)");
		Permiso permiso2 = PermisoABM.getInstance().traerPermiso(idPermiso);
		System.out.println(LugarABM.getInstance().traerUbicacion(idUbicacion).ingresoHabilitado(permiso2, LocalDate.of(2021, 3, 31)));

	}

}
