package co.com.ceiba.estacionamiento.domain.entity;

import org.junit.Test;
import co.com.ceiba.estacionamiento.domain.base.BaseTest;
import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.testdatabuilder.VehicleTestDataBuilder;

public class VehicleTest {
	
	@Test
	public void validatePlateRequired() {
		//Arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		vehicleTestDataBuilder.withPlate(null);
		
		//Act - Assert
		BaseTest.assertThrows(() -> vehicleTestDataBuilder.build(), ParkingLotException.class,"La placa es requerida");

	}
}
