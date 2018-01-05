package carfacts.vindecoder.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import carfacts.vindecoder.dao.DecoderDAO;
import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.Decoder;
import carfacts.vindecoder.dto.User;
import carfacts.vindecoder.dto.VinLog;

@Controller
@RequestMapping("/business")
public class BusinessController {

	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private DecoderDAO decoderDAO;

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/profile")
	public ModelAndView profile() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickProfile", true);
		mv.addObject("title", "My Profile");
		return mv;
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile() {

		logger.debug("Inseide BusinessController editProfile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditProfile", true);
		mv.addObject("title", "Edit Profile");

		return mv;
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	public ModelAndView updateProfile(HttpServletRequest request) {

		logger.debug("Inseide BusinessController updateProfile method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditProfile", true);
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

	@RequestMapping(value = "/changePassword")
	public ModelAndView changePassword(@RequestParam(name = "changed", required = false) String changed) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickChangePassword", true);
		mv.addObject("title", "Change Password");
		
		if (changed != null) {
			
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/updatePassword")
	public String updatePassword(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickChangePassword", true);
		mv.addObject("title", "Change Password");
		
		int userId = Integer.parseInt(request.getParameter("id"));
		
		return "redirect:/changePassword?changed";
	}

	@RequestMapping(value = "/decode/")
	public ModelAndView dispayVIN(@RequestParam String vin, @RequestParam int id) {

		ModelAndView mv = new ModelAndView("page");

		logger.info("Inside PageController displayVin method - INFO");
		logger.debug("Inseide PageController displayVin method - DEBUG");
		
		mv.addObject("userClickVinDecode", true);
		mv.addObject("title", "VIN Decode Result");
		
		// use user id to fetch the user credit		
		if (userDAO.get(id).getCredit() > 0) {

			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/vindecoder/carfacts/api/localApi/";
	
			Decoder decoderApi = restTemplate.getForObject(url, Decoder.class, vin);
	
			if (decoderApi == null) {
	
				url = "http://localhost:8080/vindecoder/carfacts/api/carfaxApi/";
				decoderApi = restTemplate.getForObject(url, Decoder.class, vin);
	
				if (decoderApi != null) {
					Decoder decoder = new Decoder();
					decoder.setVin(decoderApi.getVin());
					decoder.setMake(decoderApi.getMake());
					decoder.setModelName(decoderApi.getModelName());
					decoder.setModelYear(decoderApi.getModelYear());
					decoder.setFuelType(decoderApi.getFuelType());
					decoder.setBodyType(decoderApi.getBodyType());
					decoder.setDriveWheels(decoderApi.getDriveWheels());
					decoder.setEnginePower(decoderApi.getEnginePower());
					decoder.setHorsePower(decoderApi.getHorsePower());
					decoder.setCurbWeight(decoderApi.getCurbWeight());
					decoder.setGrossVehicleWeight(decoderApi.getGrossVehicleWeight());
					decoder.setPlant(decoderApi.getPlant());
					decoder.setGearBox(decoderApi.getGearBox());
					decoder.setMaxPayload(decoderApi.getMaxPayload());
					decoder.setCo2EmissionMixedDriving(decoderApi.getCo2EmissionMixedDriving());
					decoder.setFuelConsumptionMixedDriving(decoderApi.getFuelConsumptionMixedDriving());
	
					// add record to the database
					decoderDAO.add(decoder);
	
				}
	
			}
	
			// check if record is found and redirect to show page else redirect back
			// to home page
			if (decoderApi == null) {
				mv.addObject("errorMsg", "There was no record found matching the VIN (" + vin + ")");
			} else {
				// deduct user credit -1
				User user = userDAO.get(id);
				userDAO.deductCredit(user);
				
				// set vin logs data
				VinLog vinLog = new VinLog();
				vinLog.setUserId(user.getId());
				vinLog.setVin(vin);
				vinLog.setMake(decoderApi.getMake());
				vinLog.setModelYear(decoderApi.getModelYear());
				
				// add vin logs
				userDAO.addVinLogs(vinLog);
			}
	
			mv.addObject("decoder", decoderApi);
			
		} else {
			mv.addObject("errorMsg", "Insuficient credit to complete the check!");
		}

		return mv;
	}
	
	
	@RequestMapping(value = "/showVinLogs", method = RequestMethod.GET)
	public ModelAndView showVinLogs() {

		logger.debug("Inseide BusinessController getVinLogs method - DEBUG");

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickGetVinLogs", true);
		mv.addObject("title", "Vin Logs");

		return mv;
	}

}
