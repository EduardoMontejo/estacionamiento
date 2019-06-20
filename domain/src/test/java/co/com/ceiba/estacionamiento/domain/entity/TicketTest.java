package co.com.ceiba.estacionamiento.domain.entity;

import org.junit.Test;

import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.testdatabuilder.TicketTestDataBuilder;

public class TicketTest {

	@Test(expected = ParkingLotException.class)
	public void validateAdmissionDate() {
		//arrange
		TicketTestDataBuilder tickeTestDataBuilder = new TicketTestDataBuilder().withAdmissionDate(null);
				
		//act - assert
		tickeTestDataBuilder.build();
	}
	
	@Test(expected = ParkingLotException.class)
	public void validateVehicle() {
		//arrange
		TicketTestDataBuilder tickeTestDataBuilder = new TicketTestDataBuilder();
				
		//act - assert
		tickeTestDataBuilder.build();
	}
}
