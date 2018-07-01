package edu.jyu.stumgm.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import edu.jyu.stumgm.entity.StuAdmin;

public class StuAdminDAO extends BaseDAO implements IStuAdmin {

	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public StuAdminDAO() {
		super(StuAdmin.class);
	}
	@SuppressWarnings("unchecked")
	public StuAdminDAO(StuAdmin admin) {
		super(admin.getClass());
	}
	@Override
	public void addStuAdmin(StuAdmin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(admin);
		tx.commit();
		session.close();
	}
	@Override
	public void correctPassword(StuAdmin admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(admin);
		tx.commit();
		session.close();
	}
	@Override
	public StuAdmin getStuAdmin(String stuId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="From edu.jyu.stumgm.entity.StuAdmin S where S.stuId="+stuId;
		List list=session.createQuery(hql).list();
		StuAdmin admin=null;
		for(Iterator it=list.iterator();it.hasNext();)
		{
			admin=(StuAdmin)it.next();
		}
		tx.commit();
		session.close();
		return admin;
	}
	public void delectAdmin(String stuId) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println("Delete From edu.jyu.stumgm.entity.StuAdmin S where S.stuId="+stuId);
		session.createQuery("Delete From edu.jyu.stumgm.entity.StuAdmin S where S.stuId="+stuId).executeUpdate();
		tx.commit();
		session.close();
	}
}
