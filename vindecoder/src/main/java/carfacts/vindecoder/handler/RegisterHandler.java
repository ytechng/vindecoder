package carfacts.vindecoder.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.User;
import carfacts.vindecoder.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public String save(RegisterModel registerModel) {
		String transitionValue = "success";
		
		// fetch the user record
		User user = registerModel.getUser();
		
		userDAO.add(user);
		
		return transitionValue;
	}

}
