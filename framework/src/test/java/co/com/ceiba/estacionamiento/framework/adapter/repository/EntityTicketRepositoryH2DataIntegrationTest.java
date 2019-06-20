package co.com.ceiba.estacionamiento.framework.adapter.repository;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import co.com.ceiba.estacionamiento.application.command.RegisterVehicleEntryHandler;
import co.com.ceiba.estacionamiento.application.command.VehicleCommand;
import co.com.ceiba.estacionamiento.application.query.SelectAllVehiclesInParkingLotQueryHandler;
import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.framework.adapter.entity.EntityTicket;
import co.com.ceiba.estacionamiento.framework.testdatabuilder.EntityTicketTestDataBuilder;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityTicketRepositoryH2DataIntegrationTest {
	@Autowired
	private EntityTicketRepositoryData repository;

	@Autowired
	private RegisterVehicleEntryHandler registerVehicleEntryHandler;
	
	@Autowired 
	private SelectAllVehiclesInParkingLotQueryHandler selectAllVehiclesInParkingLot;
	
	@After
	public void tearDown() throws Exception {
		this.repository.deleteAll();
	}
	
	@Test
	public void shouldReturnOnlyVehiclesInParkingLot() throws Exception {
		//Arrange
		EntityTicket entityTicket = new EntityTicketTestDataBuilder().build();
		this.registerVehicleEntryHandler.handle(new VehicleCommand(
				entityTicket.getPlate(),
				entityTicket.getEngineDisplacement(),
				entityTicket.getTypeVehicle()));
				
		//Act
		Collection<Ticket> vehiclesInParkingLot = this.selectAllVehiclesInParkingLot.handle();
		
		//Assert
		assertEquals("1", String.valueOf(vehiclesInParkingLot.size()));
	}
}
