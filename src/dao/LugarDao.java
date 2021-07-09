package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Localidad;
import datos.Ubicacion;

public class LugarDao {
	private static Session session;
	private Transaction tx;
	private static LugarDao instancia=null;
	
	protected LugarDao() {}
	
	public static LugarDao getInstance() {
		if(instancia==null) {
			instancia=new LugarDao();
		}
		return instancia;
	}
	
	protected void iniciaOperacion() throws HibernateException { 
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	protected void manejaExcepcion(HibernateException he) throws HibernateException { 
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Ubicacion traerUbicacion(int id) throws HibernateException{
		Ubicacion objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Ubicacion u where u.idLugar="+id;
			objeto = (Ubicacion) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	public Localidad traerLocalidad(int id) throws HibernateException{
		Localidad objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Localidad u where u.idLugar="+id;
			objeto = (Localidad) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}

}
