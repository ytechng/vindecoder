package carfacts.vindecoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import carfacts.vindecoder.dao.ApiDAO;
import carfacts.vindecoder.dao.DecoderDAO;
import carfacts.vindecoder.dao.UserDAO;
import carfacts.vindecoder.dto.Api;
import carfacts.vindecoder.dto.Decoder;
import carfacts.vindecoder.dto.User;
import carfacts.vindecoder.dto.VinLog;

@RestController
@RequestMapping("/carfacts/api")
public class DecoderAPIController {

	@Autowired
	private ApiDAO apiDAO;

	@Autowired
	private DecoderDAO decoderDAO;

	@Autowired
	private UserDAO userDAO;

	// VIN from API
	@RequestMapping(value="/carfaxApi/{vin}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Api getVinDecode(@PathVariable("vin") String vin) {

		// Fetch the VIN record from the database using the supplied vin
		Api api = apiDAO.get(vin);

		return api;

	}

	// VIN from local database
	@RequestMapping(value="/localApi/{vin}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Decoder getVinDecodeFromDb(@PathVariable("vin") String vin) {

		// Fetch the VIN record from the database using the supplied vin
		Decoder decode = decoderDAO.get(vin);

		return decode;
	}

	// Vin Logs
	@RequestMapping("/getVinLogs/{userId}/user")
	public List<VinLog> getVinLogs(@PathVariable int userId) {

		return userDAO.getVinLogs(userId);
	}

	// Get business users list
	@RequestMapping(value = "/getBusinessUsers")
	public List<User> getBusinessUsers() {

		return userDAO.getUsersByRole("business");
	}

	// Get admin users list
	@RequestMapping(value = "/getAdminUsers")
	public List<User> getAdminUsers() {

		return userDAO.getUsersByRole("admin");
	}
}
