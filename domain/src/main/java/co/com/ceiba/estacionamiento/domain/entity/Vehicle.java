package co.com.ceiba.estacionamiento.domain.entity;

public class Vehicle {
	
	private static final String PLATE_IS_REQUIRED = "La placa es requerida";
	private static final String TYPE_VEHICLE_IS_REQUIRED = "El tipo de vehiculo es requerida";
	private static final String PLATE_MUST_HAVE_MINIMUM_LETTERS = "La placa debe tener minimo 6 letras.";
	private static final int MINIMUM_SIZE = 6;
	
	private String plate;
	private int engineDisplacement;
	private String typeVehicle;
	
	public Vehicle(String plate, int engineDisplacement, String typeVehicle) {
		ValidatorArgument.validateRequired(plate, PLATE_IS_REQUIRED);
		ValidatorArgument.validateRequired(typeVehicle, TYPE_VEHICLE_IS_REQUIRED);
		ValidatorArgument.validateSize(plate, MINIMUM_SIZE, PLATE_MUST_HAVE_MINIMUM_LETTERS);
		
		this.plate = plate;
		this.engineDisplacement = engineDisplacement;
		this.typeVehicle = typeVehicle;
	}

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
