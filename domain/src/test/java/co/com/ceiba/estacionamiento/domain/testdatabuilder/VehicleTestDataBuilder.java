package co.com.ceiba.estacionamiento.domain.testdatabuilder;

import co.com.ceiba.estacionamiento.domain.entity.Vehicle;

public class VehicleTestDataBuilder {
	private String plate;
	private int engineDisplacement;
	private String typeVehicle;
	
	public VehicleTestDataBuilder() {
		this.plate = "<default>";
		this.engineDisplacement = 500;
		this.typeVehicle = "<default>";
	}
	
	public VehicleTestDataBuilder withPlate(String plate) {
		this.plate = plate;
		return this;
	}
	
	public VehicleTestDataBuilder withEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
		return this;
	}
	
	public VehicleTestDataBuilder withTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
		return this;
	}
	
	public Vehicle build() {
		return new Vehicle(plate, engineDisplacement, typeVehicle);
	}
}
