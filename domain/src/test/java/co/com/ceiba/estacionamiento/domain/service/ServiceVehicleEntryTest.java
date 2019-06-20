package co.com.ceiba.estacionamiento.domain.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;
import co.com.ceiba.estacionamiento.domain.testdatabuilder.TicketTestDataBuilder;
import co.com.ceiba.estacionamiento.domain.testdatabuilder.VehicleTestDataBuilder;

public class ServiceVehicleEntryTest {
	
	@Test(expected = ParkingLotException.class)
	public void registerVehicleWithPlateInitA() {
		//arrange
		Vehicle vehicle = new VehicleTestDataBuilder().withPlate("AAA444").build();
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleEntry service = new ServiceRegisterVehicleEntry(repository);
		
		//act - assert
		service.registerVehicleEntry(vehicle);
	}
	
	@Test
	public void countMotorcycles() {
		//arrange
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleEntry service = new ServiceRegisterVehicleEntry(repository);
		
		Collection<Ticket> tickets = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			Vehicle newVehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("moto").build();
			Ticket newTicket = new TicketTestDataBuilder().withVehicle(newVehicle).build();
			tickets.add(newTicket);
		}
		
		Mockito.when(repository.findVehiclesInParkingLot()).thenReturn(tickets);
		
		//act
		int numMotorcycle = service.countVehicles("moto");
		
		//assert
		assertTrue(10 == numMotorcycle);
	}
	
	@Test
	public void countCars() {
		//arrange
		ParkingLotRepository repository = Mockito.mock(ParkingLotRepository.class);
		ServiceRegisterVehicleEntry service = new ServiceRegisterVehicleEntry(repository);
		
		Collection<Ticket> tickets = new ArrayList<>();
		
		for(int i = 0; i < 20; i++) {
			Vehicle newVehicle = new VehicleTestDataBuilder().withPlate("WSN25C").withTypeVehicle("carro").build();
			Ticket newTicket = new TicketTestDataBuilder().withVehicle(newVehicle).build();
			tickets.add(newTicket);
		}
		
		Mockito.when(repository.findVehiclesInParkingLot()).thenReturn(tickets);
		
		//act
		int numMotorcycle = service.countVehicles("carro");
		
		//assert
		assertTrue(20 == numMotorcycle);
	}
}
