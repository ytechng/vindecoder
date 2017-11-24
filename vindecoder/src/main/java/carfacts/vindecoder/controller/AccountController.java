package carfacts.vindecoder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	// Login
	@RequestMapping(value = { "/login" })
	public ModelAndView login(@RequestParam(name = "error", required = false) String error) {

		ModelAndView mv = new ModelAndView("page");

		logger.info("Inside AccountController login method - INFO");
		logger.debug("Inseide AccountController login method - DEBUG");

		mv.addObject("userClickSignIn", true);
		mv.addObject("title", "Sign In");

		if (error != null) {
			mv.addObject("errorMsg", "Invalid username and/or password!");
		}

		return mv;
	}

	// Register
	@RequestMapping(value = { "/register" })
	public ModelAndView register() {

		ModelAndView mv = new ModelAndView("page");

		logger.info("Inside AccountController register method - INFO");
		logger.debug("Inseide AccountController register method - DEBUG");

		mv.addObject("title", "Sign Up");

		return mv;
	}

}
