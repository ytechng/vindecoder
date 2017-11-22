package carfacts.vindecoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import carfacts.vindecoder.dao.ApiDAO;
import carfacts.vindecoder.dao.DecoderDAO;
import carfacts.vindecoder.dto.Api;
import carfacts.vindecoder.dto.Decoder;

@RestController
@RequestMapping("/json/data")
public class DecoderAPIController {
	
	@Autowired
	private ApiDAO apiDAO;
	
	@Autowired
	private DecoderDAO decoderDAO;
	
	
	// VIN from API
	@RequestMapping(value="/carfaxApi/{vin}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Api getVinDecode(@PathVariable("vin") int vin) {
		
		// Fetch the VIN record from the database using the supplied vin 
		Api api = apiDAO.get(vin);
		
		return api;
		
	}
	
	// VIN from local database
	@RequestMapping(value="/localApi/{vin}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Decoder getVinDecodeFromDb(@PathVariable("vin") int vin) {
		
		// Fetch the VIN record from the database using the supplied vin 
		Decoder decode = decoderDAO.get(vin);
		
		return decode;
	}
}
