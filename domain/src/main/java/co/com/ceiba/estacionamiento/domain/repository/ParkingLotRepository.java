package co.com.ceiba.estacionamiento.domain.repository;

import co.com.ceiba.estacionamiento.domain.entity.Ticket;
import co.com.ceiba.estacionamiento.domain.entity.Vehicle;

public interface ParkingLotRepository {
	
	Ticket registerVehicleEntry(Vehicle vehicle);
	Ticket findTicketByPlate();
	void registerVehicleExit(Ticket ticket);
}
