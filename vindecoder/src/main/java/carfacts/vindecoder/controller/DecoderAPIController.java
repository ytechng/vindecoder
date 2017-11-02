package carfacts.vindecoder.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import carfacts.vindecoder.dto.Decoder;

@RestController
public class DecoderAPIController {

	@RequestMapping(value="/business/{vin}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Decoder getVinDecode(@PathVariable("vin") String vin) {
		
		// Fetch the VIN record from the database using the supplied vin 
		Decoder decode = new Decoder();
		
		decode.setId(1);
		decode.setVin("WP1ZZZ9PZ3LA80863");
		decode.setMake("Porsche");
		decode.setModelName("Cayenne");
		decode.setModelYear("2003");
		decode.setFuelType("Petrol");
		decode.setBodyType("SUV");
		decode.setDriveWheels("All wheel");
		decode.setEnginePower("331");
		decode.setHorsePower("450");
		decode.setCurbWeight("2430");
		decode.setGrossVehicleWeight("2013");
		decode.setPlant("Leipzig, Germany");
		decode.setGearBox("Automatic");
		decode.setMaxPayload("650");
		decode.setCo2EmissionMixedDriving("");
		decode.setFuelConsumptionMixedDriving("");
		
		return decode;
		
	}
}
