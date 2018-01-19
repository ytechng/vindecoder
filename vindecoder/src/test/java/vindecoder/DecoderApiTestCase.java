package vindecoder;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import carfacts.vindecoder.dao.DecoderDAO;
import carfacts.vindecoder.dto.Decoder;

public class DecoderApiTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static DecoderDAO decoderDAO;
	
	private static Decoder decoder;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("carfacts.vindecoder");
		context.refresh();
		
		decoderDAO = (DecoderDAO) context.getBean("decoderDAO");
	}
	
	@Test
	public void testAdddecoderdecoder() {
		
		decoder = new Decoder();	
		decoder.setVin("WP1ABC9PZ3LA80199");
		decoder.setMake("Honda");
		decoder.setModelName("Corolla");
		decoder.setModelYear("2007");
		decoder.setFuelType("Petrol");
		decoder.setBodyType("SUV");
		decoder.setDriveWheels("All wheel");
		decoder.setEnginePower("123");
		decoder.setHorsePower("456");
		decoder.setCurbWeight("2567");
		decoder.setGrossVehicleWeight("2010");
		decoder.setPlant("Leipzig, Germany");
		decoder.setGearBox("Automatic");
		decoder.setMaxPayload("234");
		decoder.setCo2EmissionMixedDriving("N/A");
		decoder.setFuelConsumptionMixedDriving("N/A");
		
		assertEquals("Error adding new vin decoderd", true, decoderDAO.add(decoder));
		
		decoder = new Decoder();	
		decoder.setVin("WQ1ABB2DSALA80123");
		decoder.setMake("Toyata");
		decoder.setModelName("Venza");
		decoder.setModelYear("2002");
		decoder.setFuelType("Petrol");
		decoder.setBodyType("SUV");
		decoder.setDriveWheels("All wheel");
		decoder.setEnginePower("670");
		decoder.setHorsePower("145");
		decoder.setCurbWeight("3219");
		decoder.setGrossVehicleWeight("2345");
		decoder.setPlant("Leipzig, Canada");
		decoder.setGearBox("Automatic");
		decoder.setMaxPayload("267");
		decoder.setCo2EmissionMixedDriving("N/A");
		decoder.setFuelConsumptionMixedDriving("N/A");
		
		assertEquals("Error adding new vin ", true, decoderDAO.add(decoder));
		
	}
	
}
