package co.com.ceiba.estacionamiento.domain.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.com.ceiba.estacionamiento.domain.exception.ParkingLotException;
import co.com.ceiba.estacionamiento.domain.testdatabuilder.VehicleTestDataBuilder;

public class VehicleTest {
	
	@Test(expected = ParkingLotException.class)
	public void validatePlate() {
		//arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().withPlate(null);
				
		//act - assert
		vehicleTestDataBuilder.build();
	}
	
	@Test
	public void validatePlateWithValue() {
		//arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().withPlate("WSN25C");
				
		//act
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		//assert
		assertEquals("WSN25C", vehicle.getPlate());
		
	}
	
	@Test(expected = ParkingLotException.class)
	public void validateSizePlate() {
		//arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().withPlate("WSN");
		
		//act - assert
		vehicleTestDataBuilder.build();
	}
}
