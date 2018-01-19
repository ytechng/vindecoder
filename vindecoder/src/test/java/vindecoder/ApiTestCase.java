package vindecoder;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import carfacts.vindecoder.dao.ApiDAO;
import carfacts.vindecoder.dto.Api;

public class ApiTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ApiDAO apiDAO;
	
	private static Api api;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("carfacts.vindecoder");
		context.refresh();
		
		apiDAO = (ApiDAO) context.getBean("apiDAO");
	}
	
	@Test
	public void testAddapiAPI() {
		
		api = new Api();	
		api.setVin("WP1ZZZ9PZ3LA80863");
		api.setMake("Porch");
		api.setModelName("Cayenne");
		api.setModelYear("2003");
		api.setFuelType("Petrol");
		api.setBodyType("SUV");
		api.setDriveWheels("All wheel");
		api.setEnginePower("331");
		api.setHorsePower("450");
		api.setCurbWeight("2430");
		api.setGrossVehicleWeight("3080");
		api.setPlant("Leipzig, Germany");
		api.setGearBox("Automatic");
		api.setMaxPayload("650");
		api.setCo2EmissionMixedDriving("CO2 emissions in mixed driving");
		api.setFuelConsumptionMixedDriving("Fuel consumption in mixed driving");
		
		assertEquals("Error adding new vin apid", true, apiDAO.add(api));
		
	}
	
	
	/*@Test
	public void testUpdateVin() {
		
		api = apiDAO.get("WQ1ABB2DSALA801FG");
		
		api.setModelName("Honda");
		api.setModelYear("2000");
		api.setFuelType("Diesel");
		
		// update record
		assertEquals("Failed to update vin!", true, apiDAO.update(api));
		
	}*/
	
}
