package pojo_tests;

import org.groupout.users_and_groups.pojos.User;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
	
	private static User user = new User();
	private static String FIRST_NAME = "Tom";
	private static String LAST_NAME = "Johns";
	private static String EMAIL_ADDRESS = "tom.johns@abf.com";
	private static String PHONE_NUMBER = "1112223333";
	private static String DATE_OF_BIRTH = "11-01-1990";
	
	@BeforeClass
	public static void initializeUserObject() {
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		user.setEmailAddress(EMAIL_ADDRESS);
		user.setPhoneNumber(PHONE_NUMBER);
		user.setDateOfBirth(DATE_OF_BIRTH);
		user.loadVariableMap();
	}

	@Test
	public void testInsert() {
		String result = user.insert();
		assertNotNull(result);
	}

	@Test
	public void testPojoMethods() {
		assertEquals(user.getFirstName(), FIRST_NAME);
		assertEquals(user.getLastName(), LAST_NAME);
		assertEquals(user.getEmailAddress(), EMAIL_ADDRESS);
		assertEquals(user.getPhoneNumber(), PHONE_NUMBER);
		assertEquals(user.getDateOfBirth(), DATE_OF_BIRTH);
	}
	
}
