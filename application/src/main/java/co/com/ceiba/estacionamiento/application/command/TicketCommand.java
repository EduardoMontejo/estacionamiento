package co.com.ceiba.estacionamiento.application.command;

public class TicketCommand {
	
	private String plate;
	private String typeVehicle;
    private int engineDisplacement;
	
	public String getPlate() {
		return plate;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public String getTypeVehicle() {
		return typeVehicle;
	}
	
	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
	
	public int getEngineDisplacement() {
		return engineDisplacement;
	}
	
	public void setEngineDisplacement(int engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
	}
}
