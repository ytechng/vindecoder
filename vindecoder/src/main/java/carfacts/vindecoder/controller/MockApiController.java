package carfacts.vindecoder.controller;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import carfacts.vindecoder.dao.APIErrorDAO;
import carfacts.vindecoder.dto.EUTeaserDetails;
import carfacts.vindecoder.dto.USTeaserDetails;

@RestController
@RequestMapping("/mock")
public class MockApiController {
	
	@Autowired
	private APIErrorDAO apiErrorDAO;

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
		
		String uid_ = "carfacts";
		String vin_ = "WAUED64B9YN120707";
		String ipAddr = "192.168.0.103";
		
		// get user ip from api
			
		if (!uid.equalsIgnoreCase(uid_)) {
			return apiErrorDAO.getErrorByCode("E03");
		}		
		
		else if (!vinReg.equalsIgnoreCase(vin_)) {
			return apiErrorDAO.getErrorByCode("E01");
		} 
		
		else if (uid_.equalsIgnoreCase(uid) && vin_.equalsIgnoreCase(vinReg)) {
			return teaser;
		}
		
		return "Unknown error! Please contact an Administrators";
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
	
	@RequestMapping(value="/getServerIP", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Object getServerIp() {
		
		InetAddress ip;
		String hostName;
		
		try {
			ip = InetAddress.getLocalHost();
			hostName = ip.getHostAddress();
			
			return hostName;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/getIp", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Object getIp(HttpServletRequest request) {
		
		String remoteAddress = "";
		
		if (request != null) {
			remoteAddress = request.getHeader("X-FORWARDED-FOR");
			
			if (remoteAddress == null || remoteAddress.equals("")) {
				remoteAddress = request.getRemoteAddr();
			}
		}
		
		return remoteAddress;
	}
}
