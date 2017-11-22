package carfacts.vindecoder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	private static Logger logger = LoggerFactory.getLogger(PageController.class);
		
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index(@RequestParam(name="vin", required=false) String vin) {
		
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inseide PageController index method - DEBUG");
		
		if (vin != null) {
			mv.addObject("vinResult", "True");
		}
		
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
	
		
	@RequestMapping(value={"/show"})
	public ModelAndView test(@RequestParam(name="vin", required=true) String vin) {
		
		ModelAndView mv = new ModelAndView("page");
		
		if (vin != null) {
			mv.addObject("vinResult", vin);
		}
				
		mv.addObject("userClickVinDecode", true);
		mv.addObject("title", "Vin Decoder");
		
		return mv;
	}

}