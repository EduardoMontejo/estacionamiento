package co.com.ceiba.estacionamiento.domain.service;


import org.junit.Test;
import org.mockito.Mockito;

import co.com.ceiba.estacionamiento.domain.entity.Vehicle;
import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.port.ParkingLotRepository;
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
}
