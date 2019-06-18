package co.com.ceiba.estacionamiento.domain.entity;

public class ParkingLot {
	
	public static final int MAXIMUM_NUMBER_OF_CARS = 20;
	public static final int MAXIMUM_NUMBER_OF_MOTORCYCLES = 10;
	public static final int PRICE_HOUR_MOTORCYCLE = 500;
	public static final int PRICE_HOUR_CAR = 1000;
	public static final int PRICE_DAY_MOTORCYCLE = 4000;
	public static final int PRICE_DAY_CAR = 8000;
	
	private int numMotorcycles;
	private int numCars;

	public int getNumMotorcycles() {
		return numMotorcycles;
	}

	public void setNumMotorcycles(int numMotorcycles) {
		this.numMotorcycles = numMotorcycles;
	}

	public int getNumCars() {
		return numCars;
	}

	public void setNumCars(int numCars) {
		this.numCars = numCars;
	}
}
