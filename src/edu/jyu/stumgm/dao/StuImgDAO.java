package edu.jyu.stumgm.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.jyu.stumgm.entity.StuAdmin;
import edu.jyu.stumgm.entity.StuImg;

public class StuImgDAO extends BaseDAO<StuImg> implements IStuImgDAO{
	
	private SessionFactory sessionFactory;
	public StuImgDAO() {
		super(StuImg.class);
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public void add(StuImg stuImg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(stuImg);
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public void correct(StuImg stuImg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(stuImg);
		session.getTransaction().commit();
		session.close();	
	}


	@Override
	public void delete(String stuId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.createQuery("Delete From edu.jyu.stumgm.entity.StuImg S where S.stuId="+stuId).executeUpdate();
		tx.commit();
		session.close();
	}


	@Override
	public StuImg find(String stuId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql="From edu.jyu.stumgm.entity.StuImg S where S.stuId="+stuId;
		List list=session.createQuery(hql).list();
		StuImg stuImg=null;
		for(Iterator it=list.iterator();it.hasNext();)
		{
			stuImg=(StuImg)it.next();
		}
		tx.commit();
		session.close();
		return stuImg;
	}
	

}
