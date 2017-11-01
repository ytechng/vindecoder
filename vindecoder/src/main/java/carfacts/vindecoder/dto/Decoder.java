package carfacts.vindecoder.dto;

import java.sql.Date;

public class Decoder {

	private int id;
	private String vin;
	private String make;
	private String modelName;
	private String modelYear;
	private String fuelType;
	private String bodyType;
	private String driveWheels;
	private String enginePower;
	private String horsePower;
	private String curbWeight;
	private String grossVehicleWeight;
	private String plant;
	private String gearBox;
	private String maxPayload;
	// col = co2_emission_mixed_driving
	private String co2EmissionMixedDriving;
	private String fuelConsumptionMixedDriving;
	private Date createdAt;
	private boolean status = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getDriveWheels() {
		return driveWheels;
	}

	public void setDriveWheels(String driveWheels) {
		this.driveWheels = driveWheels;
	}

	public String getEnginePower() {
		return enginePower;
	}

	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}

	public String getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(String horsePower) {
		this.horsePower = horsePower;
	}

	public String getCurbWeight() {
		return curbWeight;
	}

	public void setCurbWeight(String curbWeight) {
		this.curbWeight = curbWeight;
	}

	public String getGrossVehicleWeight() {
		return grossVehicleWeight;
	}

	public void setGrossVehicleWeight(String grossVehicleWeight) {
		this.grossVehicleWeight = grossVehicleWeight;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public String getMaxPayload() {
		return maxPayload;
	}

	public void setMaxPayload(String maxPayload) {
		this.maxPayload = maxPayload;
	}

	public String getCo2EmissionMixedDriving() {
		return co2EmissionMixedDriving;
	}

	public void setCo2EmissionMixedDriving(String co2EmissionMixedDriving) {
		this.co2EmissionMixedDriving = co2EmissionMixedDriving;
	}

	public String getFuelConsumptionMixedDriving() {
		return fuelConsumptionMixedDriving;
	}

	public void setFuelConsumptionMixedDriving(String fuelConsumptionMixedDriving) {
		this.fuelConsumptionMixedDriving = fuelConsumptionMixedDriving;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Decoder [id=" + id + ", vin=" + vin + ", make=" + make + ", modelName=" + modelName + ", modelYear="
				+ modelYear + ", fuelType=" + fuelType + ", bodyType=" + bodyType + ", driveWheels=" + driveWheels
				+ ", enginePower=" + enginePower + ", horsePower=" + horsePower + ", curbWeight=" + curbWeight
				+ ", grossVehicleWeight=" + grossVehicleWeight + ", plant=" + plant + ", gearBox=" + gearBox
				+ ", maxPayload=" + maxPayload + ", co2EmissionMixedDriving=" + co2EmissionMixedDriving
				+ ", fuelConsumptionMixedDriving=" + fuelConsumptionMixedDriving + ", createdAt=" + createdAt
				+ ", status=" + status + "]";
	}

}
