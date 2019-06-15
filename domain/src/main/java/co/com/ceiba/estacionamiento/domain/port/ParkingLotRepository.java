package co.com.ceiba.estacionamiento.domain.port;

import java.util.Collection;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;

public interface ParkingLotRepository {
	
	Ticket registerVehicleEntry(Ticket ticket);
	
	Collection<Ticket> findVehiclesInParkingLot();
	
	Ticket findById(Integer id);
	
	Ticket registerVehicleExit(Ticket ticket);
}
