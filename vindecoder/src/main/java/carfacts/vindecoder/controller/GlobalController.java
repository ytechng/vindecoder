package carfacts.vindecoder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.User;
import carfacts.vindecoder.model.UserModel;

@ControllerAdvice
@Scope("session")
public class GlobalController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserDAO userDAO;

	private UserModel userModel;

	@ModelAttribute("userModel")
	public UserModel getUserModel() {

		if (session.getAttribute("userModel") == null) {

			// add the user model
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			User user = userDAO.getUserByEmail(auth.getName());

			if (user != null) {
				// create new UserModel object to pass the user details
				userModel = new UserModel();

				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setPassword(user.getPassword());
				userModel.setFirstName(user.getFirstName());
				userModel.setLastName(user.getLastName());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				userModel.setCompanyName(user.getCompanyName());
				userModel.setCompanyAddress(user.getCompanyAddress());
				userModel.setPhoneNo(user.getPhoneNo());
				userModel.setRegDate(user.getRegDate());
				userModel.setRole(user.getRole());
				userModel.setCredit(user.getCredit());

				if (userModel.getRole().equals("business")) {
					// do something for business users
				}

				// set the userModel in the session
				session.setAttribute("userModel", userModel);

				return userModel;
			}
		}

		return (UserModel) session.getAttribute("userModel");

	}

}
