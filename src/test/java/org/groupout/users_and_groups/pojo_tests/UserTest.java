package org.groupout.users_and_groups.pojo_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.groupout.users_and_groups.pojos.Device;
import org.groupout.users_and_groups.pojos.User;
import org.groupout.users_and_groups.utils.HibernateUtil;
import org.groupout.users_and_groups.utils.IdGenerator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;
	private static Date date;
	private static User testUserObject;
	
	@BeforeClass
	public static void setUpData() {
		sessionFactory = HibernateUtil.getSessionFactory();
		date = new Date();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Device device = new Device();
		String deviceId = IdGenerator.generateId();
		device.setDeviceId(deviceId);
		device.setCountryCode("+091");
		device.setPhoneNumber("9880067731");
		device.setRegisteredOn(date.toString());
		session.saveOrUpdate(device);
		
		testUserObject = new User();
		testUserObject.setUserId("test.user");
		testUserObject.setActive(true);
		testUserObject.setEmailAddress("test.user@abc.com");
		testUserObject.setFirstName("Test");
		testUserObject.setLastName("User");
		testUserObject.setPassword("xyz");
		testUserObject.setRegisteredOn(date.toString());		
		testUserObject.setPrimaryDevice(device);
		session.saveOrUpdate(testUserObject);
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
		System.out.println("SKPDebug User Id : " + testUserObject.getUserId());
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
	
	@Test
	public void testGetPrimaryDevice() {
		//assertEquals("+091", testUserObject.getPrimaryDevice().getCountryCode());
	}
}
