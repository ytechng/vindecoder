package vindecoder;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import carfacts.vindecoder.dao.ApiDAO;
import carfacts.vindecoder.dto.Api;

public class DecoderApiTestCase {

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
		api.setVin("WP1ABC9PZ3LA80123");
		api.setMake("Honda");
		api.setModelName("Corolla");
		api.setModelYear("2007");
		api.setFuelType("Petrol");
		api.setBodyType("SUV");
		api.setDriveWheels("All wheel");
		api.setEnginePower("123");
		api.setHorsePower("456");
		api.setCurbWeight("2567");
		api.setGrossVehicleWeight("2010");
		api.setPlant("Leipzig, Germany");
		api.setGearBox("Automatic");
		api.setMaxPayload("234");
		api.setCo2EmissionMixedDriving("N/A");
		api.setFuelConsumptionMixedDriving("N/A");
		
		assertEquals("Error adding new vin apid", true, apiDAO.add(api));
		
		api = new Api();	
		api.setVin("WP1ABB2DSALA80123");
		api.setMake("Toyata");
		api.setModelName("Venza");
		api.setModelYear("2002");
		api.setFuelType("Petrol");
		api.setBodyType("SUV");
		api.setDriveWheels("All wheel");
		api.setEnginePower("670");
		api.setHorsePower("145");
		api.setCurbWeight("3219");
		api.setGrossVehicleWeight("2345");
		api.setPlant("Leipzig, Canada");
		api.setGearBox("Automatic");
		api.setMaxPayload("267");
		api.setCo2EmissionMixedDriving("N/A");
		api.setFuelConsumptionMixedDriving("N/A");
		
		assertEquals("Error adding new vin apid", true, apiDAO.add(api));
		
	}
	
}
