package carfacts.vindecoder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carfacts.vindecoder.dto.EUTeaserDetails;
import carfacts.vindecoder.dto.USTeaserDetails;

@RestController
@RequestMapping("/ag")
public class BusinessAPIController {
	
	@RequestMapping(value="/getEUTeaserJson", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Object getEUTeaserJson() {

		EUTeaserDetails teaser = new EUTeaserDetails();

		teaser.setMake("Toyota");
		teaser.setModel("Camry");
		teaser.setVhrRecords("35");
		teaser.setFeature1("Odometer readings");
		teaser.setFeature2("Service records");
		teaser.setFeature3("Full US History");

		return teaser;
	}
	
	
	@RequestMapping(value="/getUSTeaserJson", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Object getUSTeaserJson() {
		
		USTeaserDetails usTeaser = new USTeaserDetails();
		
		usTeaser.setVin("WAUED64B9YN120707");
		usTeaser.setModel("Toyota");
		usTeaser.setMake("Venza");
		usTeaser.setYear("2016");
		usTeaser.setBodyStyle("");
		usTeaser.setEngineType("");
		usTeaser.setRecords("21");
		usTeaser.setManufacturedIn("");
		
		return usTeaser;
	}

}
