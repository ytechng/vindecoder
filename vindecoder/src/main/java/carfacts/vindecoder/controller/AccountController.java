package carfacts.vindecoder.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.CookieParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	/*Login*/
	@RequestMapping(value = { "/login" })
	public ModelAndView login(
			@RequestParam(name = "error", required = false) String error, 
			@RequestParam(name = "logout", required = false) String logout
			) {

		ModelAndView mv = new ModelAndView("page");

		logger.info("Inside AccountController login method - INFO");
		logger.debug("Inseide AccountController login method - DEBUG");

		mv.addObject("userClickSignIn", true);
		mv.addObject("title", "Sign In");

		if (logout != null) {
			mv.addObject("logoutMsg", "You have successfully logout!");
		}
		
		if (error != null) {
			mv.addObject("errorMsg", "Invalid username and/or password!");
		} 

		return mv;
	}

	/*Register*/
	@RequestMapping(value = { "/register" })
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView("page");

		logger.info("Inside AccountController register method - INFO");
		logger.debug("Inseide AccountController register method - DEBUG");

		mv.addObject("title", "Sign Up");

		return mv;
	}
	
	/*Logout*/
	@RequestMapping(value = "/account-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("Inside AccountController logout method - INFO");
		logger.debug("Inseide AccountController logout method - DEBUG");
		
		// fatch the authentication
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {				
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}

}
