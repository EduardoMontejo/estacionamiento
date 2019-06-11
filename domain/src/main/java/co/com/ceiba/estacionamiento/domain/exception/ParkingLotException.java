package co.com.ceiba.estacionamiento.domain.exception;

public class ParkingLotException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ParkingLotException(String message) {
		super(message);
	}
}
