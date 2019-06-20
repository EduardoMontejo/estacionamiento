package co.com.ceiba.estacionamiento.application.command;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;

public class RegisterVehicleEntryHandlerTest {
	
	@Test
	public void validateInitialLetterA() {
		//arrange
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		String plate = "ASD345";
		
		//act
		boolean value =  new RegisterVehicleEntryHandler(repository).initialLetterPlate(plate);
		
		//assert
		assertTrue(value);
	}
	
//	@Test
//	public void RegisterVehicleEntry() {
//		//arrange
//		Vehicle vehicle = new VehicleTestDataBuilder().build();
//		Ticket ticket = new TicketTestDataBuilder().withVehicle(vehicle).build();
//		
//		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
//		Mockito.when(repository.registerVehicleEntry(ticket)).thenReturn(ticket);
//		
//		//act
//		Ticket ticketEntry = new RegisterVehicleEntryHandler(repository).registerVehicleEntry(vehicle);
//		
//		//assert
//		assertEquals("<default>", ticketEntry.getVehicle().getPlate());
//	}
	
}
