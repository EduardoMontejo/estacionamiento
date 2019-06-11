package co.com.ceiba.estacionamiento.domain.service;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;

public class ParkingLotService {
	public static final int MAXIMUM_NUMBER_OF_CARS = 20;
	public static final int MAXIMUM_NUMBER_OF_MOTORCYCLES = 10;
	public static final int PRICE_HOUR_MOTORCYCLE = 500;
	public static final int PRICE_HOUR_CAR = 1000;
	public static final int PRICE_DAY_MOTORCYCLE = 4000;
	public static final int PRICE_DAY_CAR = 8000;
	
	public int calculateValue(Ticket ticket) {
		return 1;
	}
	
	public boolean initialLetterPlate(Vehicle vehicle) {
		//regular expression
		return true;
	}
	
	public boolean validateMaximumCapacity() {
		return true;
	}
}
