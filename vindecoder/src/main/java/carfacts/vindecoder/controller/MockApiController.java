package carfacts.vindecoder.controller;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import carfacts.vindecoder.dto.EUTeaserDetails;
import carfacts.vindecoder.dto.USTeaserDetails;

@RestController
@RequestMapping("/mock")
public class MockApiController {

	//getEUTeaserJson?{UID}.eu_vhrteaser_json&{vinreg}
	@RequestMapping(value="/getEUTeaserJson/{UID}/{vinreg}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Object getEUTeaserJson(@PathVariable("UID") @NotNull String uid, 
			@PathVariable("vinreg") @NotNull String vinReg) {

		EUTeaserDetails teaser = new EUTeaserDetails();

		teaser.setMake("Toyota");
		teaser.setModel("Camry");
		teaser.setVhrRecords("35");
		teaser.setFeature1("Odometer readings");
		teaser.setFeature2("Service records");
		teaser.setFeature3("Full US History");
		
		String userID = "carfacts";
		String vinDetail = "WAUED64B9YN120707";
		
		if (uid.equals("") || uid == null) {
			return "Error 101: User ID is empty!";
		}
		
		else if (vinReg.equals("") || vinReg == null) {
			return "Error 102: VinReg is empty!";
		}
		
		else if (!uid.toUpperCase().equals(userID.toUpperCase())) {
			return "Error 103: User ID not found!";
		}
		
		else if(!vinReg.equalsIgnoreCase(vinDetail)) {
			return "Error 104: Invalid VIN!";
		}
		
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
