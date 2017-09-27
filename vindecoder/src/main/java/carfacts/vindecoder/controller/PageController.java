package carfacts.vindecoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickHome", true);
		mv.addObject("title", "Vin Decoder");
		return mv;
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickContact", true);
		mv.addObject("title", "Contact Us");
		return mv;
	}
	
	@RequestMapping(value="/profile")
	public ModelAndView profile() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickProfile", true);
		mv.addObject("title", "My Profile");
		return mv;
	}

}