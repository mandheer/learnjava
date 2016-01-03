/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.learning.hibernate.dto.UserDetails;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateCRUDTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetails userDetails = null;
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			/*
			 * session.beginTransaction(); for (int i = 50; i <= 100; i++) { userDetails = new
			 * UserDetails(); userDetails.setUserName("User Name " + i); session.save(userDetails);
			 * } session.getTransaction().commit(); session.close();
			 */
			session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
			session.beginTransaction();
			// userDetails = session.get(UserDetails.class, 51l);
			// userDetails.setUserName("Updated User");
			// session.delete(userDetails);
			// session.update(userDetails);
			// session.getTransaction().commit();
			// session.close();
			Criteria criteria = session.createCriteria(UserDetails.class);
			ProjectionList p1 = Projections.projectionList();
			p1.add(Projections.property("userName"));
			// criteria.add(Restrictions.gt("userId", 49l)).add(Restrictions.like("userName",
			// "Up%"));
			Criterion criterion = Restrictions.lt("userId", 25l);
			Criterion criterion2 = Restrictions.gt("userId", 50l);
			criteria.add(Restrictions.or(criterion, criterion2));
			// criteria.setProjection(p1);
			List list = criteria.list();
			
			System.out.println(list.size());
		} finally {
			if (session.isOpen())
				session.close();
			SessionFactoryCreatorDemo.shutdown();
		}
	}
	
}
