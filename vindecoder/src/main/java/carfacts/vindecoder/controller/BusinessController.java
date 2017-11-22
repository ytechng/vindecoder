package carfacts.vindecoder.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import carfacts.vindecoder.dao.DecoderDAO;
import carfacts.vindecoder.dto.Decoder;

@Controller
@RequestMapping("/business")
public class BusinessController {

	private static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private DecoderDAO decoderDAO;
	
	@RequestMapping(value = "/profile")
	public ModelAndView profile() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickProfile", true);
		mv.addObject("title", "My Profile");
		return mv;
	}

	@RequestMapping(value = "/editProfile")
	public ModelAndView editProfile() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickEditProfile", true);
		mv.addObject("title", "Edit Profile");
		return mv;
	}

	@RequestMapping(value = "/changePassword")
	public ModelAndView changePassword() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickChangePassword", true);
		mv.addObject("title", "Change Password");
		return mv;
	}

	@RequestMapping(value = "/decode/")
	public ModelAndView dispayVIN(@RequestParam int vin) {

		ModelAndView mv = new ModelAndView("page");

		logger.info("Inside PageController displayVin method - INFO");
		logger.debug("Inseide PageController displayVin method - DEBUG");

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/vindecoder/json/data/localApi/{vin}";

		Decoder decoderApi = restTemplate.getForObject(url, Decoder.class, vin);

		if (decoderApi == null) {

			url = "http://localhost:8080/vindecoder/json/data/carfaxApi/{vin}";
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
		}

		mv.addObject("userClickVinDecode", true);
		mv.addObject("title", "VIN Decode Result");
		mv.addObject("decoder", decoderApi);

		return mv;
	}

}
