package co.com.ceiba.estacionamiento.application.command;

public class VehicleCommand {
	
	private String plateCommand;
	private int engineDisplacementCommand;
	private String typeVehicleCommand;
	
	public VehicleCommand() {
		//
	}	
	
	public VehicleCommand(String plateCommand, int engineDisplacementCommand, String typeVehicleCommand) {
		super();
		this.plateCommand = plateCommand;
		this.engineDisplacementCommand = engineDisplacementCommand;
		this.typeVehicleCommand = typeVehicleCommand;
	}

	public String getPlateCommand() {
		return plateCommand;
	}
	
	public void setPlateComamand(String plateCommand) {
		this.plateCommand = plateCommand;
	}
	
	public int getEngineDisplacementCommand() {
		return engineDisplacementCommand;
	}
	
	public void setEngineDisplacementCommand(int engineDisplacementCommand) {
		this.engineDisplacementCommand = engineDisplacementCommand;
	}
	
	public String getTypeVehicleCommand() {
		return typeVehicleCommand;
	}
	
	public void setTypeVehicleCommand(String typeVehicleCommand) {
		this.typeVehicleCommand = typeVehicleCommand;
	}
}
