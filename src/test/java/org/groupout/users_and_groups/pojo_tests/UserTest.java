package org.groupout.users_and_groups.pojo_tests;

import java.util.Date;

import org.groupout.users_and_groups.pojos.User;
import org.groupout.users_and_groups.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Date date;
	private User testUserObject;
	
	@Before
	public void dataSetup() {
		sessionFactory = HibernateUtil.getSessionFactory();
		date = new Date();
		
		testUserObject = new User();
		testUserObject.setUserId("test.user");
		testUserObject.setActive(true);
		testUserObject.setEmailAddress("test.user@abc.com");
		testUserObject.setFirstName("Test");
		testUserObject.setLastName("User");
		testUserObject.setPassword("xyz");
		testUserObject.setRegisteredOn(date.toString());
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(testUserObject);;
		transaction.commit();
		session.close();
		
		// Retrieve the saved session object
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", "test.user"));
		testUserObject = (User) criteria.uniqueResult();
	}
	
	@Test
	public void testUserId() {
		assertEquals("test.user", testUserObject.getUserId());
	}
	
	@Test
	public void testFirstName() {
		assertEquals("Test", testUserObject.getFirstName());
	}
	
}
