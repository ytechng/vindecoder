package carfacts.vindecoder.dto;

public class USTeaserDetails {

	private String vin;
	private String year;
	private String make;
	private String model;
	private String records;
	private String engineType;
	private String bodyStyle;
	private String manufacturedIn;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public String getManufacturedIn() {
		return manufacturedIn;
	}

	public void setManufacturedIn(String manufacturedIn) {
		this.manufacturedIn = manufacturedIn;
	}

}
