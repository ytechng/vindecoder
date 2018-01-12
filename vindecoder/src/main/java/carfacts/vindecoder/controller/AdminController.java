package carfacts.vindecoder.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.Transaction;
import carfacts.vindecoder.dto.User;

@Controller
@RequestMapping("/manage")
public class AdminController {
	
	private static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	private String fileLocation;
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/user/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String userActivation(@PathVariable int id) {
		// get the user from the database
		User user = userDAO.get(id);
		
		boolean isActive = user.isActive();
		
		// user ativation and deactivation
		user.setActive(!user.isActive());
		
		// update the user
		userDAO.update(user);
		
		return (isActive) ? 
				"You have successfully deactivated the user with email: " + user.getEmail() :
				"You have successfully activated the user with email: " + user.getEmail();
	}
	
	
	@RequestMapping(value="/checkUserData", method=RequestMethod.POST)
	@ResponseBody
	public String checkUserData(HttpServletRequest request) {
		
		String email = request.getParameter("email");
		
		User user = userDAO.getUserByEmail(email);
		
		return (user != null) ? null : "No user found for the email address provided!";		
	}
	
	
	@RequestMapping(value = "/profile")
	public ModelAndView profile() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminProfile", true);
		mv.addObject("title", "My Profile");
		return mv;
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile() {

		logger.debug("Inseide BusinessController editProfile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminEditProfile", true);
		mv.addObject("title", "Edit Profile");

		return mv;
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	public ModelAndView updateProfile(HttpServletRequest request) {

		logger.debug("Inseide BusinessController updateProfile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminEditProfile", true);
		mv.addObject("title", "Edit Profile");
		
		int userId = Integer.parseInt(request.getParameter("id"));

		if (userId != 0) {

			User nUser = userDAO.get(userId);
			
			// set user update information
			nUser.setFirstName(request.getParameter("firstName"));
			nUser.setLastName(request.getParameter("lastName"));
			nUser.setPhoneNo(request.getParameter("phoneNo"));
			nUser.setCompanyName(request.getParameter("companyName"));
			nUser.setCompanyAddress(request.getParameter("companyAddress"));
			//nUser.setEmail(request.getParameter("email"));

			// update the use if id is not 0
			userDAO.update(nUser);
			
			mv.addObject("successMsg", "Profile updated successfully!");
		}

		return mv;
	}
	
	
	@RequestMapping(value = "/showAdminUsersList", method = RequestMethod.GET)
	public ModelAndView showAdminUsersList() {

		logger.debug("Inseide BusinessController editProfile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminUsersList", true);
		mv.addObject("title", "Admin Users");

		return mv;
	}
	
	// handle adding credit
	@RequestMapping(value="/addCredit", method=RequestMethod.POST)
	public String handleAddCreditSubmission(HttpServletRequest request) {
		String email = request.getParameter("email");
		int credit = Integer.parseInt(request.getParameter("credit"));
		
		User user = userDAO.getUserByEmail(email);
		user.setCredit(user.getCredit() + credit);
		
		// update user credit
		userDAO.update(user);
		
		// create transaction log
		// 1. get the admin user details (for created_by column)
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User aUser = userDAO.getUserByEmail(auth.getName());
		
		Transaction tranx = new Transaction();
		tranx.setUserId(user.getId());
		tranx.setCreatedBy(aUser.getId());
		tranx.setCredit(credit);
		
		// add the transaction log
		userDAO.addTranactionLog(tranx);
		
		return "redirect:/home?operation=" + email;
	}
	
	@RequestMapping(value = "/uploadExcelFile", method = RequestMethod.GET)
	public ModelAndView showUploadExcelFile() {

		logger.debug("Inseide AdminController showUploadEcelFile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickUploadExcel", true);
		mv.addObject("title", "Upload Excel File");

		return mv;
	}
	
	@PostMapping(value="/uploadFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
		
		InputStream in = file.getInputStream();
		
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
		FileOutputStream out = new FileOutputStream(fileLocation);
		
		int ch = 0;
		
		while ((ch = in.read()) != -1) {
			out.write(ch);
		}
		
		out.flush();
		out.close();
		
		model.addAttribute("message", "File: " + file.getOriginalFilename() + " has been uploaded successfully!");
		
		return "excel";
		
	}

}
