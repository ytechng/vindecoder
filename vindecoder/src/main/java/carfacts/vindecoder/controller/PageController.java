package carfacts.vindecoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import carfacts.vindecoder.dto.Decoder;

@Controller
public class PageController {
	
	
	@RequestMapping(value={"/", "/home", "/index"})
	public ModelAndView index(@RequestParam(name="vin", required=false) String vin) {
		
		ModelAndView mv = new ModelAndView("page");
		
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
	
	@RequestMapping(value="/profile")
	public ModelAndView profile() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickProfile", true);
		mv.addObject("title", "My Profile");
		return mv;
	}
	
	@RequestMapping(value="/editProfile")
	public ModelAndView editProfile() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditProfile", true);
		mv.addObject("title", "Edit Profile");
		return mv;
	}
	
	@RequestMapping(value="/changePassword")
	public ModelAndView changePassword() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickChangePassword", true);
		mv.addObject("title", "Change Password");
		return mv;
	}
	
	@RequestMapping(value={"/signin"})
	public ModelAndView signin() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickSignIn", true);
		mv.addObject("title", "Sign In");
		
		return mv;
	}
	
	
	@RequestMapping(value="/decode/")
	public ModelAndView dispayVIN(@RequestParam String vin) {
		
		ModelAndView mv = new ModelAndView("page");
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/vindecoder/localApi/{vin}";		
		
		Decoder decoder = restTemplate.getForObject(url, Decoder.class, vin);
		
		if (decoder == null) {
			
			url = "http://localhost:8080/vindecoder/carfaxApi/{vin}";
			decoder = restTemplate.getForObject(url, Decoder.class, vin);
			
		}
		
		mv.addObject("userClickVinDecode", true);
		mv.addObject("title", "VIN Decode Result");
		mv.addObject("decoder", decoder);
		
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