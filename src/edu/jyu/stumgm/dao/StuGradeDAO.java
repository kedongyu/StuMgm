package edu.jyu.stumgm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import edu.jyu.stumgm.entity.StuGrade;


public class StuGradeDAO extends BaseDAO<StuGrade> implements IStuGradeDAO{

	private SessionFactory sessionFactory;
	private List<StuGrade> list;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public StuGradeDAO() {
		super(StuGrade.class);
	}
	@Override
	public void add(StuGrade stuGrade) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		try {
		session.save(stuGrade);
		tx.commit();
		}
		catch(HibernateException he) {
			if(tx!=null) tx.rollback();
		}
		session.close();
	}

	@Override
	public void delete(int csId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		String hql ="delete from edu.jyu.stumgm.entity.StuGrade S where S.csId="+csId;
		session.createQuery(hql).executeUpdate();
		session.close();
	}

	@Override
	public void delete(String stuId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		String hql ="delete from edu.jyu.stumgm.entity.StuGrade S where S.stuNum="+stuId;
		session.createQuery(hql).executeUpdate();
		session.close();
	}

	@Override
	public void delete(String stuId, int csId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		String hql ="delete from edu.jyu.stumgm.entity.StuGrade S where S.csId="+csId +" and S.stuNum="+stuId;
		session.createQuery(hql).executeUpdate();
		session.close();
	}

	@Override
	public void correct(StuGrade stuGrade) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(stuGrade);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StuGrade> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(StuGrade.class);
		list = (List<StuGrade>)criteria.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StuGrade> findByStuId(String stuId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(StuGrade.class);
		criteria.add(Restrictions.eq("stuNum", stuId));
		list = (List<StuGrade>)criteria.list();
		if(list==null||list.isEmpty()) return null;
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StuGrade> findByCourseId(int csId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(StuGrade.class);
		criteria.add(Restrictions.eq("csId", csId));
		list = (List<StuGrade>)criteria.list();
		if(list==null||list.isEmpty()) return null;
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public StuGrade findOne(String stuId, int csId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(StuGrade.class);
		criteria.add(Restrictions.eq("stuNum", stuId));
		criteria.add(Restrictions.eq("csId", csId));
		list = (List<StuGrade>)criteria.list();
		if(list==null||list.isEmpty()) return null;
		return list.get(0);
	}
	
	
}
