package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Permiso;

public class PermisoDao {
	private static Session session;
	private Transaction tx;
	private static PermisoDao instancia=null;
	
	protected PermisoDao() {}
	
	public static PermisoDao getInstance() {
		if(instancia==null) {
			instancia=new PermisoDao();
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
	
	public Permiso traerPermiso(int id) throws HibernateException{
		Permiso objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Permiso p where p.idPermiso="+id;
			objeto = (Permiso) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(objeto.getPersona());
			Hibernate.initialize(objeto.getRodado());
			Hibernate.initialize(objeto.getDesdeHasta());
		}finally {
			session.close();
		}
		return objeto;
	}

}
