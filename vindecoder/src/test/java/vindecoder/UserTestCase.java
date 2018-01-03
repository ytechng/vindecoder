package vindecoder;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("carfacts.vindecoder");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	/*@Test
	public void testAddUser() {
		user = new User();
		user.setFirstName("Olaoluwa");
		user.setLastName("Ezekiel");
		user.setEmail("ezekiel@gmail.com");
		user.setPassword("test1234");
		user.setRole("business");
		user.setCompanyName("Whytech Integrated Solution");
		user.setCompanyAddress("270, Alagomeji Yaba Lagos");
		user.setPhoneNo("08020908829");
		
		// add the user
		assertEquals("Failed to add user!", true, userDAO.add(user));
	}*/
	
	/*@Test
	public void testUpdateUser() {
				
		user = userDAO.get(7);
			
		user.setFirstName("Ezekiel");
		user.setLastName("John111");
		user.setEmail("ezekiel@gmail.com");
		
		assertEquals("Failed to update user!", true, userDAO.delete(user));
	}*/
	
	/*@Test
	public void testDeleteUser() {
				
		user = userDAO.get(1);
		
		assertEquals("Failed to delete user!", true, userDAO.delete(user));
	}*/
	
	/*@Test
	public void testActivateUser() {
				
		user = userDAO.get(1);
		
		assertEquals("Failed to activate user!", true, userDAO.activateUser(user));
	}*/
	
	/*@Test
	public void testGetUserByEmail() {
				
		
		assertEquals("Failed to activate user!", "Opeyemi", 
				userDAO.getUserByEmail("ytechng@gmail.com").getFirstName());
	}*/
	
	@Test
	public void testGetUsersByRole() {
				
		
		assertEquals("Failed to get users by role!", 2, userDAO.getUsersByRole("business").size());
	}
	
	/*@Test
	public void testGetUserList() {
		
		assertEquals("Failed to fetched records from users table", 5,
				userDAO.list().size());
		
	}*/

}
