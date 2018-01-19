package carfacts.vindecoder.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.Transaction;
import carfacts.vindecoder.dto.User;

@Controller
@RequestMapping("/manage")
public class AdminController {

	private static Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/user/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String userActivation(@PathVariable int id) {
		// get the user from the database
		User user = userDAO.get(id);

		boolean isActive = user.isActive();

		// user ativation and deactivation
		user.setActive(!user.isActive());

		// update the user
		userDAO.update(user);

		return (isActive) ? "You have successfully deactivated the user with email: " + user.getEmail()
				: "You have successfully activated the user with email: " + user.getEmail();
	}

	@RequestMapping(value = "/checkUserData", method = RequestMethod.POST)
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

		logger.debug("Inseide AdminController editProfile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickAdminEditProfile", true);
		mv.addObject("title", "Edit Profile");

		return mv;
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	public ModelAndView updateProfile(HttpServletRequest request) {

		logger.debug("Inseide AdminController updateProfile method - DEBUG");

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
			// nUser.setEmail(request.getParameter("email"));

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
	@RequestMapping(value = "/addCredit", method = RequestMethod.POST)
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

		logger.debug("Inseide AdminController showUploadExcelFile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickUploadExcel", true);
		mv.addObject("title", "Upload Excel File");

		return mv;
	}
	
	
	/**
	 * Upload single file using Spring Controller
	 */
	@RequestMapping(value = "/uploadExcelFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file) {
		
		logger.debug("Inseide AdminController uploadFile method - DEBUG");

		String name = "VH_Report.xls";

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");

				File dir = new File(rootPath + File.separator + "tmpFiles");

				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location=" + serverFile.getAbsolutePath());

				return null; //"You successfully uploaded file=" + name;

			} catch (Exception e) {

				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			
			return null; //"You failed to upload " + name + " because the file was empty.";
		}

	}

}
