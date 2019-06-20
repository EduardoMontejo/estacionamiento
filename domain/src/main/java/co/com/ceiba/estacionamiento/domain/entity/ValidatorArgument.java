package co.com.ceiba.estacionamiento.domain.entity;

import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;

public final class ValidatorArgument {
	
	private ValidatorArgument() {
		//
	}
	
	public static void validateRequired(Object value, String message) {
		if(value == null) {
			throw new ParkingLotException(message);
		}
	}
	
	public static void validateSize(String value, int length, String message) {
		if(value.length() < length) {
			throw new ParkingLotException(message);
		}
	}
}
