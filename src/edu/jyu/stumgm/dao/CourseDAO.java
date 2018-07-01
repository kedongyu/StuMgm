package edu.jyu.stumgm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.jyu.stumgm.entity.Course;
import edu.jyu.stumgm.entity.Grade;
import edu.jyu.stumgm.entity.Student;

public class CourseDAO extends BaseDAO<Course> implements ICourseDAO {
	public CourseDAO() {
		super(Course.class);
	}
	protected CourseDAO(Class<Course> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	private SessionFactory sessionFactory;
	private List<Course> courselist;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void saveOrUpdate(Course obj) {
		// TODO Auto-generated method stub
		
	}
	public void save(Course course) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
		session.close();		
	}
	@Override
	public void deleteByCourseId(int courseId) {
		// TODO Auto-generated method stub
		String hql="delete From Course C Where C.id = "+ courseId;
		System.out.println(hql);
		Session session = sessionFactory.openSession();
		session.createQuery(hql).executeUpdate();
		session.close();
	}
	@Override
	public void deleteByCourseId(List<Integer> numbers) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Course findByCourseId(int courseId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Course course=(Course)session.get(Course.class,courseId);
		tx.commit();
		session.close();
		
		return course;
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		template.bulkUpdate("delete from edu.jyu.stumgm.entity.Course");
	}
	@SuppressWarnings("unchecked")
	public List<Course> findAll()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		
		List<Course> list = (List<Course>)criteria.list();
		session.close();
		return list;
	}
	public void update(Course course) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(course);
		tx.commit();
		session.close();
	}
}
