package co.com.ceiba.estacionamiento.application.command;

public class VehicleCommand {
	
	private String plate;
	private int engineDisplacement;
	private String typeVehicle;
	
	public String getPlate() {
		return plate;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public int getEngineDisplacement() {
		return engineDisplacement;
	}
	
	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
}
