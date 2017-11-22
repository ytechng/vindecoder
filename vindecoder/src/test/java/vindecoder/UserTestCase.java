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
	
	@Test
	public void testAddUser() {
		user = new User();
		user.setFirstName("Opeyemi");
		user.setLastName("Ajayi");
		user.setEmail("ytechng@gmail.com");
		user.setPassword("test1234");
		user.setRole("BUSINESS");
		user.setCompanyName("Whytech Integrated Solution");
		user.setCompanyAddress("270, Alagomeji Yaba Lagos");
		user.setPhoneNo("08020908829");
		
		// add the user
		assertEquals("Failed to add user!", true, userDAO.add(user));
	}

}
