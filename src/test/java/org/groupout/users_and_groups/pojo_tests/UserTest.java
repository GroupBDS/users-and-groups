package org.groupout.users_and_groups.pojo_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.groupout.users_and_groups.pojos.User;
import org.groupout.users_and_groups.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private Date date;
	private User testUserObject;
	
	@Before
	public void setUpData() {
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
		transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", "test.user"));
		testUserObject = (User) criteria.uniqueResult();
		transaction.commit();
		session.close();
	}
	
	@After
	public void clearData() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		testUserObject = null;
		testUserObject = session.load(User.class, "test.user");
		if (testUserObject != null)
			session.delete(testUserObject);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testUserId() {
		assertEquals("test.user", testUserObject.getUserId());
	}
	
	@Test
	public void testFirstName() {
		assertEquals("Test", testUserObject.getFirstName());
	}
	
	@Test
	public void testLastName() {
		assertEquals("User", testUserObject.getLastName());
	}
	
	@Test
	public void testEmailAddress() {
		assertEquals("test.user@abc.com", testUserObject.getEmailAddress());
	}
	
	@Test
	public void testIsActive() {
		assertTrue(testUserObject.isActive());
	}

	@Test
	public void testPassword() {
		assertEquals("xyz", testUserObject.getPassword());
	}
	
	@Test
	public void testGetRegisteredOn() {
		assertEquals(date.toString(), testUserObject.getRegisteredOn());
	}	
}
